package sp.co.soe.emp.app.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@Setter
public class CloseStatusBean {
    /**
     * Column: close_date
     */
    private Date closeDate;

    /**
     * Column: close_flag
     */
    private Integer closeFlag;

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
