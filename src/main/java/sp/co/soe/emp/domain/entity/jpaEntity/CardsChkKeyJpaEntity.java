package sp.co.soe.emp.domain.entity.jpaEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * Table: cards_chk
 */
@Getter
@Setter
@Embeddable
public class CardsChkKeyJpaEntity implements Serializable {
    /**
     * Column: period_month
     */
    private Date periodMonth;

    /**
     * Column: employee_id
     */
    private String employeeId;

}