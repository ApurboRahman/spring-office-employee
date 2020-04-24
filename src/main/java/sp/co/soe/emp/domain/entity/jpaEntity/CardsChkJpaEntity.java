package sp.co.soe.emp.domain.entity.jpaEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Table: cards_chk
 */

@Getter
@Setter
@Entity
@Table(name = "cards_chk")
public class CardsChkJpaEntity {
    @EmbeddedId
    private CardsChkKeyJpaEntity cardsChkKeyJpaEntity;
    /**
     * Column: work_nm
     */
    private String workNm;

    /**
     * Column: place_nm
     */
    private String placeNm;

    /**
     * Column: empcard_flg
     */
    private String empcardFlg;

    /**
     * Column: card1_flg
     */
    private String card1Flg;

    /**
     * Column: card2_flg
     */
    private String card2Flg;

    /**
     * Column: card3_flg
     */
    private String card3Flg;

    /**
     * Column: card4_flg
     */
    private String card4Flg;

    /**
     * Column: card5_flg
     */
    private String card5Flg;

    /**
     * Column: card6_flg
     */
    private String card6Flg;

    /**
     * Column: card7_flg
     */
    private String card7Flg;

    /**
     * Column: chk_user
     */
    private String chkUser;

    /**
     * Column: chk_date
     */
    private Date chkDate;

    /**
     * Column: approval_user
     */
    private String approvalUser;

    /**
     * Column: approval_date
     */
    private Date approvalDate;

    /**
     * Column: notes
     */
    private String notes;

    /**
     * Column: chk_flg
     */
    private String chkFlg;

    /**
     * Column: approval_flg
     */
    private String approvalFlg;

    /**
     * Column: edit_flg
     */
    private String editFlg;

    /**
     * Column: create_user
     */
    private String createUser;

    /**
     * Column: create_date
     */
    private Date createDate;

    /**
     * Column: create_pgid
     */
    private String createPgid;

    /**
     * Column: update_user
     */
    private String updateUser;

    /**
     * Column: update_date
     */
    private Date updateDate;

    /**
     * Column: update_pgid
     */
    private String updatePgid;
}