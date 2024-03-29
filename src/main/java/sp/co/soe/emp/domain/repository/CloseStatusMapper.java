package sp.co.soe.emp.domain.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import sp.co.soe.emp.domain.entity.CloseStatus;
import sp.co.soe.emp.domain.entity.CloseStatusExample;

@Component
@Mapper
public interface CloseStatusMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table close_status
     *
     * @mbg.generated Fri Apr 10 22:17:57 JST 2020
     */
    long countByExample(CloseStatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table close_status
     *
     * @mbg.generated Fri Apr 10 22:17:57 JST 2020
     */
    int deleteByExample(CloseStatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table close_status
     *
     * @mbg.generated Fri Apr 10 22:17:57 JST 2020
     */
    int deleteByPrimaryKey(Date closeDate);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table close_status
     *
     * @mbg.generated Fri Apr 10 22:17:57 JST 2020
     */
    int insert(CloseStatus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table close_status
     *
     * @mbg.generated Fri Apr 10 22:17:57 JST 2020
     */
    int insertSelective(CloseStatus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table close_status
     *
     * @mbg.generated Fri Apr 10 22:17:57 JST 2020
     */
    List<CloseStatus> selectByExample(CloseStatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table close_status
     *
     * @mbg.generated Fri Apr 10 22:17:57 JST 2020
     */
    CloseStatus selectByPrimaryKey(Date closeDate);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table close_status
     *
     * @mbg.generated Fri Apr 10 22:17:57 JST 2020
     */
    int updateByExampleSelective(@Param("record") CloseStatus record, @Param("example") CloseStatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table close_status
     *
     * @mbg.generated Fri Apr 10 22:17:57 JST 2020
     */
    int updateByExample(@Param("record") CloseStatus record, @Param("example") CloseStatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table close_status
     *
     * @mbg.generated Fri Apr 10 22:17:57 JST 2020
     */
    int updateByPrimaryKeySelective(CloseStatus record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table close_status
     *
     * @mbg.generated Fri Apr 10 22:17:57 JST 2020
     */
    int updateByPrimaryKey(CloseStatus record);
}