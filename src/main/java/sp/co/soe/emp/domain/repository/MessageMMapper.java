package sp.co.soe.emp.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import sp.co.soe.emp.domain.entity.MessageM;
import sp.co.soe.emp.domain.entity.MessageMExample;

@Component
@Mapper
public interface MessageMMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(MessageMExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(MessageMExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Integer messageId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(MessageM record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(MessageM record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<MessageM> selectByExample(MessageMExample example, RowBounds rowBounds);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<MessageM> selectByExampleWithLock(MessageMExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<MessageM> selectByExample(MessageMExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    MessageM selectByPrimaryKeyWithLock(Integer messageId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    MessageM selectByPrimaryKey(Integer messageId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") MessageM record, @Param("example") MessageMExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") MessageM record, @Param("example") MessageMExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(MessageM record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(MessageM record);
}