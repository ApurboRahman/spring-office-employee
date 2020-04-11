package sp.co.soe.emp.domain.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;
import sp.co.soe.emp.domain.entity.CardsChk;
import sp.co.soe.emp.domain.entity.CardsChkExample;

@Component
@Mapper
public interface CardsChkMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(CardsChkExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(CardsChkExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("periodMonth") Date periodMonth, @Param("employeeId") String employeeId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(CardsChk record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(CardsChk record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<CardsChk> selectByExample(CardsChkExample example, RowBounds rowBounds);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<CardsChk> selectByExampleWithLock(CardsChkExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<CardsChk> selectByExample(CardsChkExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    CardsChk selectByPrimaryKeyWithLock(@Param("periodMonth") Date periodMonth, @Param("employeeId") String employeeId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    CardsChk selectByPrimaryKey(@Param("periodMonth") Date periodMonth, @Param("employeeId") String employeeId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") CardsChk record, @Param("example") CardsChkExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") CardsChk record, @Param("example") CardsChkExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(CardsChk record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(CardsChk record);
}