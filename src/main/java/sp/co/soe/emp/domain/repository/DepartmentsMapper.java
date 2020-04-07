package sp.co.soe.emp.domain.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import sp.co.soe.emp.domain.entity.Departments;
import sp.co.soe.emp.domain.entity.DepartmentsExample;

public interface DepartmentsMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table departments
	 * @mbg.generated  Sat Apr 04 17:59:08 JST 2020
	 */
	long countByExample(DepartmentsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table departments
	 * @mbg.generated  Sat Apr 04 17:59:08 JST 2020
	 */
	int deleteByExample(DepartmentsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table departments
	 * @mbg.generated  Sat Apr 04 17:59:08 JST 2020
	 */
	int deleteByPrimaryKey(String deptCode);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table departments
	 * @mbg.generated  Sat Apr 04 17:59:08 JST 2020
	 */
	int insert(Departments record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table departments
	 * @mbg.generated  Sat Apr 04 17:59:08 JST 2020
	 */
	int insertSelective(Departments record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table departments
	 * @mbg.generated  Sat Apr 04 17:59:08 JST 2020
	 */
	List<Departments> selectByExample(DepartmentsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table departments
	 * @mbg.generated  Sat Apr 04 17:59:08 JST 2020
	 */
	Departments selectByPrimaryKey(String deptCode);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table departments
	 * @mbg.generated  Sat Apr 04 17:59:08 JST 2020
	 */
	int updateByExampleSelective(@Param("record") Departments record, @Param("example") DepartmentsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table departments
	 * @mbg.generated  Sat Apr 04 17:59:08 JST 2020
	 */
	int updateByExample(@Param("record") Departments record, @Param("example") DepartmentsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table departments
	 * @mbg.generated  Sat Apr 04 17:59:08 JST 2020
	 */
	int updateByPrimaryKeySelective(Departments record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table departments
	 * @mbg.generated  Sat Apr 04 17:59:08 JST 2020
	 */
	int updateByPrimaryKey(Departments record);
}