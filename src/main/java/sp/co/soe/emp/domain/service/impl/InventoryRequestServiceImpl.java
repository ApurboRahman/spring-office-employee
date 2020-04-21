package sp.co.soe.emp.domain.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import sp.co.soe.emp.app.bean.CloseStatusBean;
import sp.co.soe.emp.app.bean.EmployeeInformationBean;
import sp.co.soe.emp.app.bean.MessageBean;
import sp.co.soe.emp.app.helper.EmployeeInventoryChkHelper;
import sp.co.soe.emp.common.enums.Screen;
import sp.co.soe.emp.common.enums.StatusType;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.repository.DateMapper;
import sp.co.soe.emp.domain.repository.EmployeeInventoryChkMapper;
import sp.co.soe.emp.domain.service.*;
import sp.co.soe.emp.domain.service.mail.MailService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InventoryRequestServiceImpl implements InventoryRequestService {
    private final StatusTypeService statusTypeService;
    private final MailService mailService;
    private final EmployeeInventoryChkMapper employeeInventoryChkMapper;
    private final DateMapper dateMapper;
    private final EmployeeMasterService employeeMasterService;
    private final MessageService messageService;

    public InventoryRequestServiceImpl(StatusTypeService statusTypeService,
                                       MailService mailService,
                                       EmployeeInventoryChkMapper employeeInventoryChkMapper,
                                       DateMapper dateMapper, EmployeeMasterService employeeMasterService, MessageService messageService) {
        this.statusTypeService = statusTypeService;
        this.mailService = mailService;
        this.employeeInventoryChkMapper = employeeInventoryChkMapper;
        this.dateMapper = dateMapper;
        this.employeeMasterService = employeeMasterService;
        this.messageService = messageService;
    }

    @Override
    public boolean sendInventoryRequestEmail(String deadline, Model model, HttpServletResponse response, HttpSession session) {
        CloseStatusBean closeStatus = statusTypeService.getStatus(dateMapper.selectFirstDayOfMonth());
        if (closeStatus.getCloseFlag().equals(StatusType.LEDGER_CREATED.getValue())) {
            if (sendMail(deadline, null, Const.INVENTORY_EMAIL_TEMPLATE, Const.INVENTORY_EMAIL_TITLE))
                if (updateCloseStatus(closeStatus, StatusType.REQUESTED_INVENTORY.getValue())) {
                    saveMessage(StatusType.REQUESTED_INVENTORY.getValue());
                    model.addAttribute("status", "sendSuccess");
                    return true;
                }
        }
        model.addAttribute("error", "sendError");
        return true;
    }

    @Override
    public boolean sendInventoryRequestReminder(Model model, HttpServletResponse response, HttpSession session) {
        CloseStatusBean closeStatus = statusTypeService.getStatus(dateMapper.selectFirstDayOfMonth());
        List<EmployeeInformationBean> sectionManagers = employeeMasterService.getAllSectionManagersOrHigher();
        List<EmployeeInformationBean> securityOffer = employeeMasterService.getAllSecurityCommitteeMembers();
        sectionManagers.removeAll(securityOffer);
        securityOffer.addAll(sectionManagers);
        List<String> emailAddressForCC = securityOffer.stream().map(EmployeeInformationBean::getMailAddress).collect(Collectors.toList());
        Integer status = closeStatus.getCloseFlag();
        if (status.equals(StatusType.REQUESTED_INVENTORY.getValue()) || status.equals(StatusType.SENT_REMIND.getValue())) {
            if (sendMail(Const.NULL_STRING, emailAddressForCC, Const.REMINDER_EMAIL_TEMPLATE, Const.REMINDER_EMAIL_TITLE))
                if (updateCloseStatus(closeStatus, StatusType.SENT_REMIND.getValue())) {
                    model.addAttribute("status", "remindSuccess");
                    return true;
                }
        }
        model.addAttribute("error", "remindError");
        return false;
    }

    private boolean sendMail(String deadline, List<String> ccList, String template, String title) {
        List<EmployeeInventoryChkHelper> employeeList;
        employeeList = employeeInventoryChkMapper.selectEmployeesForInventoryRequest(getInventoryDate(), Const.unCheckedFlag);
        if (null != employeeList || !employeeList.isEmpty()) {
            for (EmployeeInventoryChkHelper employee :
                    employeeList) {
                boolean send = mailService.sendEmailFromTemplate(employee, ccList, deadline, template, title);
                if (!send) {
                    log.error("Mail could not not be sent to " + employee.getMailAddress() + ". Please confirm email id");
                }
            }
            return true;
        }
        return false;
    }

    private boolean updateCloseStatus(CloseStatusBean closeStatus, Integer status) {
        closeStatus.setCloseDate(dateMapper.selectFirstDayOfMonth());
        closeStatus.setCloseFlag(status);
        closeStatus.setUpdatePgid(Screen.MAIL_SEND_RESEND.getScreenId());
        int result = statusTypeService.updateStatus(closeStatus);
        return result != 0;
    }

    private void saveMessage( Integer status) {
        MessageBean bean = new MessageBean();
        bean.setMessageId(status);
        bean.setMessageNm( Const.INVENTORY_MESSAGE_FIRST+" "+ dateMapper.selectMonthFromCurrentDate()+" " +Const.INVENTORY_MESSAGE_LAST);
        bean.setCreatePgid(Screen.MAIL_SEND_RESEND.getScreenId());
        bean.setUpdatePgid(Screen.MAIL_SEND_RESEND.getScreenId());
        messageService.insertOrUpdate(bean);
    }

    private Date getInventoryDate() {
        return dateMapper.selectFirstDayOfMonth();
    }

}
