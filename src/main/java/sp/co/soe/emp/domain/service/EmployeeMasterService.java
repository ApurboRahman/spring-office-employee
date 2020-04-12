package sp.co.soe.emp.domain.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeMasterService {
    List<String> getAllEmployeesId();
}
