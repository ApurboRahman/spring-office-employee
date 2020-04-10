package sp.co.soe.emp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sp.co.soe.emp.common.util.Const;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = Const.LEDGER_CREATE_URL)
public class LedgerController {

    @GetMapping(value = Const.INIT_URL)
    public String index(Model model){
        return Const.LEDGER_CREATE;
    }

    @GetMapping(value = Const.CREATE)
    public String create(Model model, HttpSession session, HttpServletResponse response){
        return Const.LEDGER_CREATE;
    }
}
