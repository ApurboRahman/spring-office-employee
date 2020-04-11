package sp.co.soe.emp.domain.service.impl;

import com.opencsv.bean.CsvToBean;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import sp.co.soe.emp.app.bean.DonglesChkBean;
import sp.co.soe.emp.common.util.CSVParserUtil;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.entity.DonglesChk;
import sp.co.soe.emp.domain.repository.DateMapper;
import sp.co.soe.emp.domain.repository.DonglesChkMapper;
import sp.co.soe.emp.domain.service.LedgerService;
import sp.co.soe.emp.domain.service.SystemParamService;
import sp.co.soe.emp.domain.service.transformer.DongleChkTransformer;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class LedgerServiceImpl implements LedgerService {
    private final DongleChkTransformer dongleChkTransformer;
    private final DonglesChkMapper donglesChkMapper;
    private final SystemParamService systemParamService;
    private final DateMapper dateMapper;

    public LedgerServiceImpl(DongleChkTransformer dongleChkTransformer, DonglesChkMapper donglesChkMapper, SystemParamService systemParamService, DateMapper dateMapper) {
        this.dongleChkTransformer = dongleChkTransformer;
        this.donglesChkMapper = donglesChkMapper;
        this.systemParamService = systemParamService;
        this.dateMapper = dateMapper;
    }

    @Override
    public boolean create(Model model, HttpSession session, HttpServletResponse response) {
        CsvToBean<DonglesChkBean> chkBeans = CSVParserUtil.csvToBean(DonglesChkBean.class, getDirectoryPath(), Const.VPN_DONGLE_CSV);
        if (null == chkBeans) {
            return false;
        }
        for (DonglesChkBean dongle : chkBeans) {
            if (!dongle.getEmployeeId().isEmpty() || dongle.getEmployeeId() != null) {
                DonglesChk chk = dongleChkTransformer.transform(dongle);
                donglesChkMapper.deleteByPrimaryKey(chk.getPeriodMonth(), chk.getEmployeeId(), chk.getManageNum());
                donglesChkMapper.insert(chk);
            }

        }

        return true;
    }

    private String getDirectoryPath() {
        return systemParamService.getUploadDirectoryPathFromSystemParam();
    }

}
