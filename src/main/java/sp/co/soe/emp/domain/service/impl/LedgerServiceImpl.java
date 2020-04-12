package sp.co.soe.emp.domain.service.impl;

import com.opencsv.bean.CsvToBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import sp.co.soe.emp.app.bean.CloseStatusBean;
import sp.co.soe.emp.app.bean.DonglesChkBean;
import sp.co.soe.emp.common.enums.StatusType;
import sp.co.soe.emp.common.util.CSVParserUtil;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.common.util.Messages;
import sp.co.soe.emp.domain.entity.CloseStatus;
import sp.co.soe.emp.domain.entity.DonglesChk;
import sp.co.soe.emp.domain.repository.CardsChkMapper;
import sp.co.soe.emp.domain.repository.DateMapper;
import sp.co.soe.emp.domain.repository.DonglesChkMapper;
import sp.co.soe.emp.domain.service.EmployeeMasterService;
import sp.co.soe.emp.domain.service.LedgerService;
import sp.co.soe.emp.domain.service.StatusTypeService;
import sp.co.soe.emp.domain.service.SystemParamService;
import sp.co.soe.emp.domain.service.transformer.CardLedgerTransformer;
import sp.co.soe.emp.domain.service.transformer.DongleChkTransformer;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Slf4j
public class LedgerServiceImpl implements LedgerService {
    private final DongleChkTransformer dongleChkTransformer;
    private final CardLedgerTransformer cardLedgerTransformer;
    private final DonglesChkMapper donglesChkMapper;
    private final CardsChkMapper cardsChkMapper;
    private final SystemParamService systemParamService;
    private final StatusTypeService statusTypeService;
    private final EmployeeMasterService employeeMasterService;
    private final DateMapper dateMapper;

    public LedgerServiceImpl(DongleChkTransformer dongleChkTransformer, CardLedgerTransformer cardLedgerTransformer, DonglesChkMapper donglesChkMapper,
                             CardsChkMapper cardsChkMapper, SystemParamService systemParamService, StatusTypeService statusTypeService, EmployeeMasterService employeeMasterService, DateMapper dateMapper) {
        this.dongleChkTransformer = dongleChkTransformer;
        this.cardLedgerTransformer = cardLedgerTransformer;
        this.donglesChkMapper = donglesChkMapper;
        this.cardsChkMapper = cardsChkMapper;
        this.systemParamService = systemParamService;
        this.statusTypeService = statusTypeService;
        this.employeeMasterService = employeeMasterService;
        this.dateMapper = dateMapper;
    }

    @Override
    public boolean create(Model model, HttpSession session, HttpServletResponse response) {
        CloseStatusBean closeStatus = statusTypeService.getStatus(dateMapper.selectFirstDayOfMonth());
        if (closeStatus != null && closeStatus.getCloseFlag() == StatusType.REGISTERED_TO_MASTER.getValue()) {
            List<String> employeeList = employeeMasterService.getAllEmployeesId();
            if (createCardLedger(employeeList, model) && createDongleLedger(model) &&
                    CSVParserUtil.renameCSVFilesAndSaveInBackupFolder(getDirectoryPath())) {
                if (updateCloseStatus(closeStatus))
                    model.addAttribute("status", "success");
                return true;
            }
        }
        return false;
    }

    private boolean createDongleLedger(Model model) {
        CsvToBean<DonglesChkBean> chkBeans = CSVParserUtil.csvToBean(DonglesChkBean.class, getDirectoryPath(), Const.VPN_DONGLE_CSV);
        if (null != chkBeans) {
            for (DonglesChkBean dongle : chkBeans) {
                if (!dongle.getEmployeeId().isEmpty() || dongle.getEmployeeId() != null) {
                    try {
                        DonglesChk chk = dongleChkTransformer.transform(dongle);
                        donglesChkMapper.deleteByPrimaryKey(chk.getPeriodMonth(), chk.getEmployeeId(), chk.getManageNum());
                        donglesChkMapper.insert(chk);
                    } catch (Exception ex) {
                        log.error(ex.getMessage());
                        model.addAttribute("error", Messages.VPN_CSV_ERROR);
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean createCardLedger(List<String> employeeList, Model model) {
        if (null != employeeList) {
            for (String employee : employeeList) {
                try {
                    cardsChkMapper.deleteByPrimaryKey(dateMapper.selectFirstDayOfMonth(), employee);
                    cardsChkMapper.insert(cardLedgerTransformer.transform(employee));
                } catch (Exception ex) {
                    log.error(ex.getMessage());
                    model.addAttribute("error", Messages.CARD_LEDGER_ERROR);
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean updateCloseStatus(CloseStatusBean closeStatus) {
        closeStatus.setCloseDate(dateMapper.selectFirstDayOfMonth());
        closeStatus.setCloseFlag(StatusType.LEDGER_CREATED.getValue());
        closeStatus.setUpdatePgid("SYSTEM");
        int result = statusTypeService.updateStatus(closeStatus);
        return result != 0;
    }

    private String getDirectoryPath() {
        return systemParamService.getUploadDirectoryPathFromSystemParam();
    }

}
