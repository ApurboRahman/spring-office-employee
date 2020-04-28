package sp.co.soe.emp.domain.repository.jpaRepository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.core.support.RepositoryFactoryInformation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import sp.co.soe.emp.domain.entity.Departments;
import sp.co.soe.emp.domain.entity.DepartmentsExample;

import java.util.List;


@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, String> {

}