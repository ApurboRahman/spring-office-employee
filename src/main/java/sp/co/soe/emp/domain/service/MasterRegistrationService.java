package sp.co.soe.emp.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public interface MasterRegistrationService {
    boolean uploadCSVFile(Model model, HttpSession session, MultipartFile file, String fileName);
    void create(Model model, HttpSession session, HttpServletResponse response);
}
