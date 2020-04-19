package sp.co.soe.emp.domain.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import sp.co.soe.emp.app.helper.EmployeeInventoryChkHelper;

import java.util.Date;
import java.util.List;

@Component
@Mapper
public interface EmployeeInventoryChkMapper {

    /**
     * @param inventoryMonth
     * @param checkFlag
     * @return
     */
    List<EmployeeInventoryChkHelper> selectEmployeesForInventoryRequest(@Param("inventoryMonth") Date inventoryMonth,
                                                                        @Param("checkFlag") Character checkFlag);

}
