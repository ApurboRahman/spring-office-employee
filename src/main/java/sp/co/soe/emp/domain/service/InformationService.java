package sp.co.soe.emp.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import sp.co.soe.emp.domain.entity.EmployeesM;

import javax.servlet.http.HttpSession;

@Service
public interface InformationService {
    void getInformationDetails(Model model, HttpSession session);
    EmployeesM getUserDetails();
}
