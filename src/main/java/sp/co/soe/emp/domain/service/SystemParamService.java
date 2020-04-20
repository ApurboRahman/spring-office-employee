package sp.co.soe.emp.domain.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SystemParamService {

    String getUploadDirectoryPathFromSystemParam();
    List<String> getAllDepartmentCodeForBusinessPlanner();
    List<String>  getPostCodeForSectionManagerOrHigher();
}
