package sp.co.soe.emp.domain.service.impl;

import com.github.dozermapper.core.Mapper;
import com.opencsv.bean.CsvToBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import sp.co.soe.emp.app.bean.CardInformationBean;
import sp.co.soe.emp.app.bean.EmployeeInformationBean;
import sp.co.soe.emp.common.util.CSVParserUtil;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.common.util.Messages;
import sp.co.soe.emp.domain.entity.CardsRetain;
import sp.co.soe.emp.domain.entity.CardsRetainKey;
import sp.co.soe.emp.domain.entity.EmployeesM;
import sp.co.soe.emp.domain.repository.CardsRetainMapper;
import sp.co.soe.emp.domain.repository.DateMapper;
import sp.co.soe.emp.domain.repository.EmployeesMMapper;
import sp.co.soe.emp.domain.service.MasterRegistrationService;
import sp.co.soe.emp.domain.service.SystemParamService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;

@Service
@Slf4j
public class MasterRegistrationServiceImpl implements MasterRegistrationService {

    private final EmployeesMMapper employeesMMapper;
    private final CardsRetainMapper cardsRetainMapper;
    private final SystemParamService systemParamService;
    private final DateMapper dateMapper;
    private final Mapper dozerMapper;

    public MasterRegistrationServiceImpl(EmployeesMMapper employeesMMapper, CardsRetainMapper cardsRetainMapper,
                                         SystemParamService systemParamService, DateMapper dateMapper, Mapper dozerMapper) {
        this.employeesMMapper = employeesMMapper;
        this.cardsRetainMapper = cardsRetainMapper;
        this.systemParamService = systemParamService;
        this.dateMapper = dateMapper;
        this.dozerMapper = dozerMapper;
    }

    @Override
    public boolean uploadCSVFile(Model model, HttpSession session, MultipartFile file, String fileName) {

        return uploadCSVFile(model, file, fileName);
    }

    @Override
    public void create(Model model, HttpSession session, HttpServletResponse response) {
        if (!checkUploadFile(model)) {
            return;
        }
        createEmployeeMaster(model);
        createCardMaster(model);
    }

    private boolean uploadCSVFile(Model model, MultipartFile file, String fileName) {
        if (!CSVParserUtil.validateCSVFile(model, file)) {
            return false;
        }
        String directoryPath = getDirectoryPath();
        if (null == directoryPath) {
            model.addAttribute("error", Messages.UPLOAD_ERROR);
            return false;
        }
        if (!CSVParserUtil.saveCSVFileInGivenPatch(model, file, directoryPath, fileName)) {
            return false;
        }
        model.addAttribute("message", file.getOriginalFilename());
        model.addAttribute("status", Messages.UPLOAD_SUCCESS);
        return true;
    }


    private boolean checkUploadFile(Model model) {
        if (fileNotUploaded(Const.EMPLOYEE_CSV)) {
            model.addAttribute("message", Const.EMPLOYEE_CSV);
            model.addAttribute("error", Messages.EMP_MASTER_ERROR);
            return false;
        }
        if (fileNotUploaded(Const.VPN_DONGLE_CSV)) {
            model.addAttribute("message", Const.VPN_DONGLE_CSV);
            model.addAttribute("error", Messages.VPN_MASTER_ERROR);
            return false;
        }
        if (fileNotUploaded(Const.CARD_RETAIN_CSV)) {
            model.addAttribute("message", Const.CARD_RETAIN_CSV);
            model.addAttribute("error", Messages.CARD_MASTER_CREATE);
            return false;
        }
        return true;
    }

    private boolean createEmployeeMaster(Model model) {
        CsvToBean<EmployeeInformationBean> csvToBean = CSVParserUtil.csvToBean(EmployeeInformationBean.class, getDirectoryPath(), Const.EMPLOYEE_CSV);

        if (null != csvToBean) {
            for (EmployeeInformationBean employee : csvToBean) {
                if (!employee.getEmployeeId().isEmpty()) {
                    try {
                        EmployeesM employeesM = new EmployeesM();

                        employee.setCreateUser("SYSTEM");
                        employee.setCreateDate(new Date());
                        employee.setCreatePgid("SYSTEM");
                        employee.setUpdateUser("SYSTEM");
                        employee.setUpdateDate(new Date());
                        employee.setUpdatePgid("SYSTEM");
                        dozerMapper.map(employee, employeesM);
                        employeesMMapper.deleteByPrimaryKey(employeesM.getEmployeeId());
                        employeesMMapper.insert(employeesM);
                        //// employeesMMapper.insertOrUpdate(employeeMasterTransformer.transform(employee));
                        //  usersAccountMapper.insertOrUpdate(userAccountTransformer.transform(employee.getManNo()));
                    } catch (Exception ex) {
                        log.error(ex.getMessage());
                        model.addAttribute("error", Messages.EMP_CSV_ERROR);
                        return false;
                    }
                }
            }
            model.addAttribute("empCreate", Messages.EMP_MASTER_CREATE);
            return true;
        } else {
            model.addAttribute("message", Const.EMPLOYEE_CSV);
            model.addAttribute("error", Messages.EMP_MASTER_ERROR);
            return false;
        }
    }

    private boolean createCardMaster(Model model) {
        CsvToBean<CardInformationBean> csvToBean = CSVParserUtil.csvToBean(CardInformationBean.class, getDirectoryPath(), Const.CARD_RETAIN_CSV);
        if (null != csvToBean) {
            for (CardInformationBean card : csvToBean) {

                CardsRetainKey cardsRetainKey = new CardsRetain();
                CardsRetain cardsRetain = new CardsRetain();
                card.setPeriodMonth(dateMapper.selectFirstDayOfMonth());
                card.setCreateUser("SYSTEM");
                card.setCreateDate(new Date());
                card.setCreatePgid("SYSTEM");
                card.setUpdateUser("SYSTEM");
                card.setUpdateDate(new Date());
                card.setUpdatePgid("SYSTEM");
                dozerMapper.map(card, cardsRetain);
                cardsRetainKey.setEmployeeId(cardsRetain.getEmployeeId());
                cardsRetainKey.setPeriodMonth(cardsRetain.getPeriodMonth());
                cardsRetainMapper.deleteByPrimaryKey(cardsRetainKey);
                cardsRetainMapper.insert(cardsRetain);
            }
            model.addAttribute("cardCreate", Messages.CARD_MASTER_CREATE);
            return true;
        } else {
            model.addAttribute("message", Const.CARD_RETAIN_CSV);
            model.addAttribute("error", Messages.CARD_MASTER_ERROR);
            return false;
        }
    }

    private String getDirectoryPath() {
        return systemParamService.getUploadDirectoryPathFromSystemParam();
    }

    private boolean fileNotUploaded(String fileName) {
        File[] files = new File(getDirectoryPath()).listFiles();
        if (files == null) {
            return true;
        }
        for (File file : files) {
            if (file.isFile() && file.getName().equals(fileName)) {
                return false;
            }
        }
        return true;
    }
}
