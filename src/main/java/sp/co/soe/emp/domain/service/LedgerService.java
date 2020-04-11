package sp.co.soe.emp.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public interface LedgerService {
    boolean create(Model model, HttpSession session, HttpServletResponse response);
}
