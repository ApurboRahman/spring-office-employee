package sp.co.soe.emp.domain.service.impl;

import org.springframework.ui.Model;
import sp.co.soe.emp.domain.service.LedgerService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LedgerServiceImpl implements LedgerService {
    @Override
    public boolean create(Model model, HttpSession session, HttpServletResponse response) {
        return true;
    }
}
