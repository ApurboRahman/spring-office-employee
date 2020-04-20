package sp.co.soe.emp.domain.service.impl;

import org.springframework.stereotype.Service;
import sp.co.soe.emp.app.bean.EmployeeInformationBean;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.entity.EmployeesM;
import sp.co.soe.emp.domain.entity.EmployeesMExample;
import sp.co.soe.emp.domain.repository.EmployeesMMapper;
import sp.co.soe.emp.domain.service.EmployeeMasterService;
import sp.co.soe.emp.domain.service.SystemParamService;
import sp.co.soe.emp.domain.service.transformer.EmployeeTransformer;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeMasterServiceImpl implements EmployeeMasterService {
    private final EmployeesMMapper employeesMMapper;
    private final EmployeesMExample employeesMExample;
    private final EmployeeTransformer employeeTransformer;
    private final SystemParamService systemParamService;

    public EmployeeMasterServiceImpl(EmployeesMMapper employeesMMapper,
                                     EmployeesMExample employeesMExample,
                                     EmployeeTransformer employeeTransformer, SystemParamService systemParamService) {
        this.employeesMMapper = employeesMMapper;
        this.employeesMExample = employeesMExample;
        this.employeeTransformer = employeeTransformer;
        this.systemParamService = systemParamService;
    }

    @Override
    public List<String> getAllEmployeesId() {
        return employeesMMapper.getAllEmployeesId();
    }

    @Override
    public List<EmployeeInformationBean> getAllBusinessPlanners() {
        List<String> deptCode = systemParamService.getAllDepartmentCodeForBusinessPlanner();
        employeesMExample.clear();
        employeesMExample.createCriteria().andDeptCodeIn(deptCode);
        List<EmployeesM> employeesM = employeesMMapper.selectByExample(employeesMExample);
        List<EmployeeInformationBean> employeeBeans = new ArrayList<>();
        if (employeesM != null) {
            for (EmployeesM emp : employeesM) {
                EmployeeInformationBean bean = employeeTransformer.transformBack(emp);
                employeeBeans.add(bean);
            }
        }
        return employeeBeans;
    }

    /**
     * @return
     */
    @Override
    public List<EmployeeInformationBean> getAllSectionManagersOrHigher() {
        List<String> postCode = systemParamService.getPostCodeForSectionManagerOrHigher();
        employeesMExample.clear();
        employeesMExample.createCriteria().andDeptCodeIn(postCode);
        List<EmployeesM> employeesM = employeesMMapper.selectByExample(employeesMExample);
        List<EmployeeInformationBean> employeeBeans = new ArrayList<>();
        if (employeesM != null) {
            for (EmployeesM emp : employeesM) {
                EmployeeInformationBean bean = employeeTransformer.transformBack(emp);
                employeeBeans.add(bean);
            }
        }
        return employeeBeans;
    }

    /**
     * @return
     */
    @Override
    public List<EmployeeInformationBean> getAllSecurityCommitteeMembers() {
        employeesMExample.clear();
        employeesMExample.createCriteria().andCommCodeEqualTo(Const.securityCommittee);
        List<EmployeesM> employeesM = employeesMMapper.selectByExample(employeesMExample);
        List<EmployeeInformationBean> employeeBeans = new ArrayList<>();
        if (employeesM != null) {
            for (EmployeesM emp : employeesM) {
                EmployeeInformationBean bean = employeeTransformer.transformBack(emp);
                employeeBeans.add(bean);
            }
        }
        return employeeBeans;
    }
}
