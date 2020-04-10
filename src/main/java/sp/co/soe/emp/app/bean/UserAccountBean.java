package sp.co.soe.emp.app.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@Setter
public class UserAccountBean {

    private String userName;

    private String password;

    private Date pwdChangeDate;

    private Date validateStartDate;

    private Date validateEndDate;

    private Boolean active;

    private Boolean delete;

    private String createUser;

    private Date createDate;

    private String createPgid;

    private String updateUser;

    private Date updateDate;

    private String updatePgid;
}
