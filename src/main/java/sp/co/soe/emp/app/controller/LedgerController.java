package sp.co.soe.emp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.service.LedgerService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = Const.LEDGER_CREATE_URL)
public class LedgerController {
    private final LedgerService ledgerService;

    public LedgerController(LedgerService ledgerService) {
        this.ledgerService = ledgerService;
    }

    @GetMapping(value = Const.INIT_URL)
    public String index(Model model){
        return Const.LEDGER_CREATE;
    }

    @PostMapping(value = Const.CREATE)
    public String create(Model model, HttpSession session, HttpServletResponse response){
        ledgerService.create(model,session,response);
        return Const.LEDGER_CREATE;
    }
}
