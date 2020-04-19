package sp.co.soe.emp.app.helper;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeInventoryChkHelper {

    private String employeeId;

    private String firstName;

    private String lastName;

    private String gradeCode;

    private String postCode;

    private String sex;

    private String deptCode;

    private String unionName;

    private String joiningDate;

    private String retireDate;

    private String deleteFlg;

    private String mailAddress;

    private Boolean commCode;

    private String manageFlg;

    private String createUser;

    private Date createDate;

    private String createPgid;

    private String updateUser;

    private Date updateDate;

    private String updatePgid;
}
