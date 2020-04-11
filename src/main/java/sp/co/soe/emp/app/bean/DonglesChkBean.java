package sp.co.soe.emp.app.bean;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@Setter
public class DonglesChkBean {
    /**
     * Column: period_month
     */
    private Date periodMonth;

    /**
     * Column: employee_id
     */
    @CsvBindByPosition(position = 0)
    private String employeeId;

    /**
     * Column: manage_num
     */
    @CsvBindByPosition(position = 1)
    private String manageNum;

    /**
     * Column: effective_date
     */
    @CsvBindByPosition(position = 2)
    private String effectiveDate;

    /**
     * Column: return_date
     */
    @CsvBindByPosition(position = 3)
    private String returnDate;

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