package sp.co.soe.emp.domain.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import sp.co.soe.emp.app.helper.EmployeeInventoryChkHelper;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.repository.DateMapper;
import sp.co.soe.emp.domain.repository.EmployeeInventoryChkMapper;
import sp.co.soe.emp.domain.service.InventoryRequestService;
import sp.co.soe.emp.domain.service.mail.MailService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class InventoryRequestServiceImpl implements InventoryRequestService {
    private final MailService mailService;
    private final EmployeeInventoryChkMapper employeeInventoryChkMapper;
    private final DateMapper dateMapper;

    public InventoryRequestServiceImpl(MailService mailService, EmployeeInventoryChkMapper employeeInventoryChkMapper, DateMapper dateMapper) {
        this.mailService = mailService;
        this.employeeInventoryChkMapper = employeeInventoryChkMapper;
        this.dateMapper = dateMapper;
    }

    @Override
    public boolean sendInventoryRequestEmail(String deadline, Model model, HttpServletResponse response, HttpSession session) {
        List<EmployeeInventoryChkHelper> employeeList;
        employeeList = employeeInventoryChkMapper.selectEmployeesForInventoryRequest(getInventoryDate(), Const.unCheckedFlag);
        if (null != employeeList || !employeeList.isEmpty()) {
            for (EmployeeInventoryChkHelper employee :
                    employeeList) {
                mailService.sendEmailFromTemplate(employee, deadline, Const.INVENTORY_EMAIL_TEMPLATE, Const.INVENTORY_EMAIL_TITLE);
            }
        }
        return true;
    }

    @Override
    public boolean sendInventoryRequestReminder(Model model, HttpServletResponse response, HttpSession session) {
        return false;
    }

    private Date getInventoryDate() {
        return dateMapper.selectFirstDayOfMonth();
    }
}
