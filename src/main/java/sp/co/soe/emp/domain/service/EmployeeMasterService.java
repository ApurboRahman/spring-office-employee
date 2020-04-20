package sp.co.soe.emp.domain.service;

import org.springframework.stereotype.Service;
import sp.co.soe.emp.app.bean.EmployeeInfoBean;
import sp.co.soe.emp.app.bean.EmployeeInformationBean;

import java.util.List;

@Service
public interface EmployeeMasterService {
    List<String> getAllEmployeesId();

    List<EmployeeInformationBean> getAllBusinessPlanners();

    List<EmployeeInformationBean> getAllSectionManagersOrHigher();

    List<EmployeeInformationBean> getAllSecurityCommitteeMembers();
}
