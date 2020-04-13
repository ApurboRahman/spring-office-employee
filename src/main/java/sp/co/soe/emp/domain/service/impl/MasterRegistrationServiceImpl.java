package sp.co.soe.emp.domain.service.impl;

import com.github.dozermapper.core.Mapper;
import com.opencsv.bean.CsvToBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import sp.co.soe.emp.app.bean.CardInformationBean;
import sp.co.soe.emp.app.bean.CloseStatusBean;
import sp.co.soe.emp.app.bean.EmployeeInformationBean;
import sp.co.soe.emp.app.bean.UserAccountBean;
import sp.co.soe.emp.common.enums.Screen;
import sp.co.soe.emp.common.enums.StatusType;
import sp.co.soe.emp.common.util.CSVParserUtil;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.common.util.Messages;
import sp.co.soe.emp.domain.entity.CardsRetain;
import sp.co.soe.emp.domain.entity.CardsRetainKey;
import sp.co.soe.emp.domain.repository.CardsRetainMapper;
import sp.co.soe.emp.domain.repository.DateMapper;
import sp.co.soe.emp.domain.repository.EmployeesMMapper;
import sp.co.soe.emp.domain.repository.UsersAccountMapper;
import sp.co.soe.emp.domain.service.MasterRegistrationService;
import sp.co.soe.emp.domain.service.StatusTypeService;
import sp.co.soe.emp.domain.service.SystemParamService;
import sp.co.soe.emp.domain.service.transformer.CardMasterTransformer;
import sp.co.soe.emp.domain.service.transformer.EmployeeTransformer;
import sp.co.soe.emp.domain.service.transformer.UserAccountTransformer;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;

@Service
@Slf4j
public class MasterRegistrationServiceImpl implements MasterRegistrationService {

    private final EmployeesMMapper employeesMMapper;
    private final CardsRetainMapper cardsRetainMapper;
    private final UsersAccountMapper usersAccountMapper;
    private final SystemParamService systemParamService;
    private final EmployeeTransformer employeeTransformer;
    private final UserAccountTransformer userAccountTransformer;
    private final CardMasterTransformer cardMasterTransformer;
    private final StatusTypeService statusTypeService;
    private final DateMapper dateMapper;

    public MasterRegistrationServiceImpl(EmployeesMMapper employeesMMapper, CardsRetainMapper cardsRetainMapper,
                                         UsersAccountMapper usersAccountMapper, SystemParamService systemParamService,
                                         EmployeeTransformer employeeTransformer, UserAccountTransformer userAccountTransformer,
                                         CardMasterTransformer cardMasterTransformer, StatusTypeService statusTypeService, DateMapper dateMapper, Mapper dozerMapper) {
        this.employeesMMapper = employeesMMapper;
        this.cardsRetainMapper = cardsRetainMapper;
        this.usersAccountMapper = usersAccountMapper;
        this.systemParamService = systemParamService;
        this.employeeTransformer = employeeTransformer;
        this.userAccountTransformer = userAccountTransformer;
        this.cardMasterTransformer = cardMasterTransformer;
        this.statusTypeService = statusTypeService;
        this.dateMapper = dateMapper;
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
        CloseStatusBean closeStatus = statusTypeService.getStatus(dateMapper.selectFirstDayOfPreviousMonth());
        if (closeStatus == null || closeStatus.getCloseFlag().equals(StatusType.MONTHLY_CLOSING_DONE.getValue())) {
            if (createEmployeeMaster(model) && createCardMaster(model)) {
                insertCloseStatus();
            }
        } else {
            model.addAttribute("error", Messages.MASTER_CREATE_ERROR);
        }
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

        if (null == csvToBean) {
            model.addAttribute("message", Const.EMPLOYEE_CSV);
            model.addAttribute("error", Messages.EMP_MASTER_ERROR);
            return false;
        }
        for (EmployeeInformationBean employee : csvToBean) {
            if (!employee.getEmployeeId().isEmpty()) {
                try {
                    employee.setCreatePgid(Screen.MASTER_REGISTRATION.getScreenId());
                    employee.setUpdatePgid(Screen.MASTER_REGISTRATION.getScreenId());
                    employeesMMapper.insertOrUpdate(employeeTransformer.transform(employee));
                    UserAccountBean userBean = new UserAccountBean();
                    userBean.setUserName(employee.getEmployeeId());
                    userBean.setCreatePgid(Screen.MASTER_REGISTRATION.getScreenId());
                    userBean.setUpdatePgid(Screen.MASTER_REGISTRATION.getScreenId());
                    usersAccountMapper.insertOrUpdate(userAccountTransformer.transform(userBean));
                } catch (Exception ex) {
                    log.error(ex.getMessage());
                    model.addAttribute("error", Messages.EMP_CSV_ERROR);
                    return false;
                }
            }
        }
        model.addAttribute("empCreate", Messages.EMP_MASTER_CREATE);
        return true;
    }

    private boolean createCardMaster(Model model) {
        CsvToBean<CardInformationBean> csvToBean = CSVParserUtil.csvToBean(CardInformationBean.class, getDirectoryPath(), Const.CARD_RETAIN_CSV);
        if (null == csvToBean) {
            model.addAttribute("message", Const.CARD_RETAIN_CSV);
            model.addAttribute("error", Messages.CARD_MASTER_ERROR);
            return false;
        }
        for (CardInformationBean card : csvToBean) {
            if (card.getEmployeeId().isEmpty()) {
                try {
                    card.setCreatePgid(Screen.MASTER_REGISTRATION.getScreenId());
                    card.setUpdatePgid(Screen.MASTER_REGISTRATION.getScreenId());
                    CardsRetain cardsRetain = cardMasterTransformer.transform(card);
                    cardsRetainMapper.deleteByPrimaryKey(getCardsRetainKey(card.getEmployeeId()));
                    cardsRetainMapper.insert(cardsRetain);
                } catch (Exception ex) {
                    log.error(ex.getMessage());
                    model.addAttribute("error", Messages.CARD_CSV_ERROR);
                    return false;
                }
            }
        }
        model.addAttribute("cardCreate", Messages.CARD_MASTER_CREATE);
        return true;
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

    private void insertCloseStatus() {
        statusTypeService.deleteStatus(dateMapper.selectFirstDayOfMonth());
        CloseStatusBean closeStatusBean = new CloseStatusBean();
        closeStatusBean.setCloseDate(dateMapper.selectFirstDayOfMonth());
        closeStatusBean.setCloseFlag(StatusType.REGISTERED_TO_MASTER.getValue());
        closeStatusBean.setCreatePgid(Screen.MASTER_REGISTRATION.getScreenId());
        closeStatusBean.setUpdatePgid(Screen.MASTER_REGISTRATION.getScreenId());
        statusTypeService.insertStatus(closeStatusBean);

    }

    private CardsRetainKey getCardsRetainKey(String employeeId) {
        CardsRetainKey cardsRetainKey = new CardsRetainKey();
        cardsRetainKey.setEmployeeId(employeeId);
        cardsRetainKey.setPeriodMonth(dateMapper.selectFirstDayOfMonth());
        return cardsRetainKey;
    }
}
