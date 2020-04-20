package sp.co.soe.emp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.service.InventoryRequestService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(Const.MAIL_SEND_URL)
public class InventoryRequestController {

    private final InventoryRequestService inventoryRequestService;

    public InventoryRequestController(InventoryRequestService inventoryRequestService) {
        this.inventoryRequestService = inventoryRequestService;
    }

    @GetMapping(Const.INIT_URL)
    public String index(Model model) {
        return Const.MAIL_SEND;
    }

    @PostMapping(Const.SEND)
    public String sendInventoryRequestEmail(Model model, @RequestParam String date, HttpServletResponse response, HttpSession session) {
        inventoryRequestService.sendInventoryRequestEmail(date, model, response, session);
        return Const.MAIL_SEND;
    }

    @PostMapping(Const.REMINDER)
    public String sendInventoryRequestReminder(Model model, HttpServletResponse response, HttpSession session) {
        inventoryRequestService.sendInventoryRequestReminder(model, response, session);
        return Const.MAIL_SEND;
    }
}
