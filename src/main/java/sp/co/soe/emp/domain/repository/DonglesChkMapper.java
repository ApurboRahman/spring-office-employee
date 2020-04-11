package sp.co.soe.emp.domain.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;
import sp.co.soe.emp.domain.entity.DonglesChk;
import sp.co.soe.emp.domain.entity.DonglesChkExample;

@Component
@Mapper
public interface DonglesChkMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(DonglesChkExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(DonglesChkExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("periodMonth") Date periodMonth, @Param("employeeId") String employeeId, @Param("manageNum") String manageNum);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(DonglesChk record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(DonglesChk record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<DonglesChk> selectByExample(DonglesChkExample example, RowBounds rowBounds);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<DonglesChk> selectByExampleWithLock(DonglesChkExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<DonglesChk> selectByExample(DonglesChkExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    DonglesChk selectByPrimaryKeyWithLock(@Param("periodMonth") Date periodMonth, @Param("employeeId") String employeeId, @Param("manageNum") String manageNum);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    DonglesChk selectByPrimaryKey(@Param("periodMonth") Date periodMonth, @Param("employeeId") String employeeId, @Param("manageNum") String manageNum);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") DonglesChk record, @Param("example") DonglesChkExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") DonglesChk record, @Param("example") DonglesChkExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(DonglesChk record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(DonglesChk record);
}