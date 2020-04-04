package sp.co.soe.emp.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import sp.co.soe.emp.domain.entity.SystemParams;
import sp.co.soe.emp.domain.entity.SystemParamsExample;

@Component
@Mapper
public interface SystemParamsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_params
     *
     * @mbg.generated Mon Mar 30 00:37:11 JST 2020
     */
    long countByExample(SystemParamsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_params
     *
     * @mbg.generated Mon Mar 30 00:37:11 JST 2020
     */
    int deleteByExample(SystemParamsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_params
     *
     * @mbg.generated Mon Mar 30 00:37:11 JST 2020
     */
    int deleteByPrimaryKey(String paramId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_params
     *
     * @mbg.generated Mon Mar 30 00:37:11 JST 2020
     */
    int insert(SystemParams record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_params
     *
     * @mbg.generated Mon Mar 30 00:37:11 JST 2020
     */
    int insertSelective(SystemParams record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_params
     *
     * @mbg.generated Mon Mar 30 00:37:11 JST 2020
     */
    List<SystemParams> selectByExample(SystemParamsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_params
     *
     * @mbg.generated Mon Mar 30 00:37:11 JST 2020
     */
    SystemParams selectByPrimaryKey(String paramId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_params
     *
     * @mbg.generated Mon Mar 30 00:37:11 JST 2020
     */
    int updateByExampleSelective(@Param("record") SystemParams record, @Param("example") SystemParamsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_params
     *
     * @mbg.generated Mon Mar 30 00:37:11 JST 2020
     */
    int updateByExample(@Param("record") SystemParams record, @Param("example") SystemParamsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_params
     *
     * @mbg.generated Mon Mar 30 00:37:11 JST 2020
     */
    int updateByPrimaryKeySelective(SystemParams record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_params
     *
     * @mbg.generated Mon Mar 30 00:37:11 JST 2020
     */
    int updateByPrimaryKey(SystemParams record);
}