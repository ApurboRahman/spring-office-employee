package sp.co.soe.emp.domain.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import sp.co.soe.emp.common.util.CSVParserUtil;
import sp.co.soe.emp.common.util.Messages;
import sp.co.soe.emp.domain.service.MasterRegistrationService;
import sp.co.soe.emp.domain.service.SystemParamService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
@Slf4j
public class MasterRegistrationServiceImpl implements MasterRegistrationService {
    private final SystemParamService systemParamService;

    public MasterRegistrationServiceImpl(SystemParamService systemParamService) {
        this.systemParamService = systemParamService;
    }

    @Override
    public boolean uploadCSVFile(Model model, HttpSession session, MultipartFile file, String fileName) {

        return uploadCSVFile(model, file, fileName);
    }

    @Override
    public void create(Model model, HttpSession session, HttpServletResponse response) {

    }

    private boolean uploadCSVFile(Model model, MultipartFile file, String fileName) {
        if (!CSVParserUtil.validateCSVFile(model, file)) {
            return false;
        }
        String directoryPath = getDirectoryPath();
        if (null == directoryPath) {
            model.addAttribute("error", Messages.UPLOAD_ERROR);
            return false;
        }
        if (!CSVParserUtil.saveCSVFileInGivenPatch(model, file, directoryPath, fileName)) {
            return false;
        }
        model.addAttribute("message", file.getOriginalFilename());
        model.addAttribute("status", Messages.UPLOAD_SUCCESS);
        return true;
    }

    private String getDirectoryPath() {
        return systemParamService.getUploadDirectoryPathFromSystemParam();
    }
}
