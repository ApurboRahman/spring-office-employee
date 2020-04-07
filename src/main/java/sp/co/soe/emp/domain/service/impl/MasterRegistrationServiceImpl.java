package sp.co.soe.emp.domain.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import sp.co.soe.emp.common.util.CSVParserUtil;
import sp.co.soe.emp.domain.service.MasterRegistrationService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
@Slf4j
public class MasterRegistrationServiceImpl implements MasterRegistrationService {
    @Override
    public boolean uploadCSVFile(Model model, HttpSession session, MultipartFile file, String fileName) {

        if (!CSVParserUtil.validateCSVFile(model,file)){
            return false;
        }
        return true;
    }

    @Override
    public void create(Model model, HttpSession session, HttpServletResponse response) {

    }
}
