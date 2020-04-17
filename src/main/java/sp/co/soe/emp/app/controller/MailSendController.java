package sp.co.soe.emp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sp.co.soe.emp.common.util.Const;

@Controller
@RequestMapping(Const.MAIL_SEND_URL)
public class MailSendController {

    @GetMapping(Const.INIT_URL)
    public String index(Model model) {
        return Const.MAIL_SEND;
    }

    @PostMapping(Const.SEND)
    public String mailSend(Model model) {
        return Const.MAIL_SEND;
    }

    @PostMapping(Const.REMINDER)
    public String reminderSend(Model model) {
        return Const.MAIL_SEND;
    }
}
