package sp.co.soe.emp.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public interface InventoryRequestService {
    boolean sendInventoryRequestEmail(String deadline, Model model, HttpServletResponse response, HttpSession session);

    boolean sendInventoryRequestReminder(Model model, HttpServletResponse response, HttpSession session);
}
