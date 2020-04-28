package sp.co.soe.emp.domain.repository.jpaRepository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import sp.co.soe.emp.domain.entity.CardsChk;
import sp.co.soe.emp.domain.entity.CardsChkExample;
import sp.co.soe.emp.domain.entity.jpaEntity.CardsChkJpaEntity;
import sp.co.soe.emp.domain.entity.jpaEntity.CardsChkKeyJpaEntity;

import javax.persistence.NamedNativeQuery;
import java.util.Date;
import java.util.List;

@Repository
public interface CardsChkRepository extends PagingAndSortingRepository<CardsChkJpaEntity, CardsChkKeyJpaEntity> {

    @Query(value = "select distinct a.cardsChkKeyJpaEntity.periodMonth from CardsChkJpaEntity a order by a.cardsChkKeyJpaEntity.periodMonth")
    List<Date> selectDistinctPeriodMonth();
}