package sp.co.soe.emp.domain.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import sp.co.soe.emp.app.dto.CardInventoryDTO;

import java.util.Date;
import java.util.List;

@Component
@Mapper
public interface CardInventoryMapper {
    List<CardInventoryDTO> getCardInventory(@Param("currentDate") Date currentDate, @Param("department")String department);

    @Select("SELECT chk.period_month as periodMonth\n" +
            "            ,emp.employee_id as employeeId\n" +
            "            ,emp.first_name as firstName\n" +
            "            ,emp.last_name  as  lastName\n" +
            "            ,dep.dept_code  as  deptCode\n" +
            "            ,dep.dept_name  as  deptName\n" +
            "            ,chk.work_nm  as   workName\n" +
            "            ,chk.place_nm  as  placeName\n" +
            "            ,crd.empcard_owner  as  empcardOwner\n" +
            "            ,crd.card1_nm  as  card1Nm\n" +
            "            ,crd.card2_nm  as  card2Nm\n" +
            "            ,crd.card3_nm  as  card3Nm\n" +
            "            ,crd.card4_nm  as  card4Nm\n" +
            "            ,chk.empcard_flg  as empcardFlg \n" +
            "            ,chk.card1_flg  as  card1Flg\n" +
            "            ,chk.card2_flg  as  card2Flg\n" +
            "            ,chk.card3_flg  as  card3Flg\n" +
            "            ,chk.card4_flg  as  card4Flg\n" +
            "            ,chk.chk_user  as  chkUser\n" +
            "            ,chk.chk_date  as  chkDate\n" +
            "            ,chk.approval_user  as  approvalUser\n" +
            "            ,chk.approval_date  as  approvalDate\n" +
            "            ,chk.notes  as  notes\n" +
            "            ,chk.chk_flg  as  chkFlg\n" +
            "            ,chk.approval_flg  as  approvalFlg\n" +
            "    FROM EMPLOYEES_M emp\n" +
            "         ,DEPARTMENTS     dep\n" +
            "         ,CARDS_RETAIN    crd\n" +
            "         ,CARDS_CHK       chk\n" +
            "    WHERE emp.dept_code =#{department,jdbcType=VARCHAR}\n" +
            "    AND chk.period_month =#{currentDate,jdbcType=DATE}" +
            "    AND emp.dept_code = dep.dept_code\n" +
            "    AND emp.employee_id = crd.employee_id\n" +
            "    AND emp.employee_id = chk.employee_id" +
            "    ORDER BY emp.employee_id")
    List<CardInventoryDTO> cardInventory(Date currentDate, String department);
}
