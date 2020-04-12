package sp.co.soe.emp.domain.service.impl;

import org.springframework.stereotype.Service;
import sp.co.soe.emp.domain.repository.EmployeesMMapper;
import sp.co.soe.emp.domain.service.EmployeeMasterService;

import java.util.List;

@Service
public class EmployeeMasterServiceImpl implements EmployeeMasterService {
   private final EmployeesMMapper employeesMMapper;

    public EmployeeMasterServiceImpl(EmployeesMMapper employeesMMapper) {
        this.employeesMMapper = employeesMMapper;
    }

    @Override
    public List<String> getAllEmployeesId() {
        return employeesMMapper.getAllEmployeesId();
    }
}
