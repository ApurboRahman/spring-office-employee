package sp.co.soe.emp.app.bean;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@Setter
public class EmployeeInformationBean {

    @CsvBindByPosition(position = 0)
    private String employeeId;

    @CsvBindByPosition(position = 1)
    private String firstName;

    @CsvBindByPosition(position = 2)
    private String lastName;

    @CsvBindByPosition(position = 3)
    private String gradeCode;

    @CsvBindByPosition(position = 4)
    private String postCode;

    @CsvBindByPosition(position = 5)
    private String sex;

    @CsvBindByPosition(position = 6)
    private String deptCode;

    @CsvBindByPosition(position = 7)
    private String unionName;

    @CsvBindByPosition(position = 8)
    private String joiningDate;

    @CsvBindByPosition(position = 9)
    private String retireDate;

    @CsvBindByPosition(position = 10)
    private String deleteFlg;

    @CsvBindByPosition(position = 11)
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
