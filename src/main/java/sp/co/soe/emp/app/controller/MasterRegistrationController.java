package sp.co.soe.emp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.service.MasterRegistrationService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(Const.MASTER_REGISTRATION_URL)
public class MasterRegistrationController {
    private final MasterRegistrationService masterRegistrationService;

    public MasterRegistrationController(MasterRegistrationService masterRegistrationService) {
        this.masterRegistrationService = masterRegistrationService;
    }

    @GetMapping(value = "")
    public String index() {
        return Const.MASTER_REGISTRATION;
    }

    @PostMapping(value = Const.EMPLOYEE_UPLOAD_URL)
    public String uploadEmployeeInfo(Model model, HttpSession session, @RequestParam MultipartFile employeeFileName) {
        masterRegistrationService.uploadCSVFile(model, session, employeeFileName, Const.EMPLOYEE_CSV);
        return Const.MASTER_REGISTRATION;
    }

    @PostMapping(value = Const.VPN_DONGLE_UPLOAD_URL)
    public String uploadDongleInfo(Model model, HttpSession session, @RequestParam MultipartFile VPNFileName) {
        masterRegistrationService.uploadCSVFile(model, session, VPNFileName, Const.VPN_DONGLE_CSV);
        return Const.MASTER_REGISTRATION;
    }

    @PostMapping(value = Const.CARD_UPLOAD_URL)
    public String uploadCardInfo(Model model, HttpSession session, @RequestParam MultipartFile CardFileName) {
        masterRegistrationService.uploadCSVFile(model, session, CardFileName, Const.CARD_RETAIN_CSV);
        return Const.MASTER_REGISTRATION;
    }

    @PostMapping(value = Const.CREATE)
    public String crate(Model model, HttpSession session, HttpServletResponse response) {
        masterRegistrationService.create(model, session, response);
        return Const.MASTER_REGISTRATION;
    }
}
