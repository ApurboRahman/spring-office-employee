package sp.co.soe.emp.domain.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sp.co.soe.emp.domain.entity.RoleMenuPermissions;
import sp.co.soe.emp.domain.entity.RoleMenuPermissionsExample;

public interface RoleMenuPermissionsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu_permissions
     *
     * @mbg.generated Sat Apr 04 16:25:29 JST 2020
     */
    long countByExample(RoleMenuPermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu_permissions
     *
     * @mbg.generated Sat Apr 04 16:25:29 JST 2020
     */
    int deleteByExample(RoleMenuPermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu_permissions
     *
     * @mbg.generated Sat Apr 04 16:25:29 JST 2020
     */
    int insert(RoleMenuPermissions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu_permissions
     *
     * @mbg.generated Sat Apr 04 16:25:29 JST 2020
     */
    int insertSelective(RoleMenuPermissions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu_permissions
     *
     * @mbg.generated Sat Apr 04 16:25:29 JST 2020
     */
    List<RoleMenuPermissions> selectByExample(RoleMenuPermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu_permissions
     *
     * @mbg.generated Sat Apr 04 16:25:29 JST 2020
     */
    int updateByExampleSelective(@Param("record") RoleMenuPermissions record, @Param("example") RoleMenuPermissionsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu_permissions
     *
     * @mbg.generated Sat Apr 04 16:25:29 JST 2020
     */
    int updateByExample(@Param("record") RoleMenuPermissions record, @Param("example") RoleMenuPermissionsExample example);
}