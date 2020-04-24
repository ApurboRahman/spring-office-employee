package sp.co.soe.emp.domain.service.impl;

import org.springframework.stereotype.Service;
import sp.co.soe.emp.domain.entity.DepartmentsExample;
import sp.co.soe.emp.domain.repository.DepartmentsMapper;
import sp.co.soe.emp.domain.repository.jpaRepository.DepartmentsRepository;
import sp.co.soe.emp.domain.service.DepartmentService;

import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    private  final DepartmentsRepository departmentsRepository;

    public DepartmentServiceImpl( DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    @Override
    public List getDepartmentList() {
        return departmentsRepository.getDepartmentList();
    }
}
