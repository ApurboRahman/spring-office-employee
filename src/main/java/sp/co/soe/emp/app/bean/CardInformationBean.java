package sp.co.soe.emp.app.bean;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@Setter
public class CardInformationBean {
    private Date periodMonth;

    @CsvBindByPosition(position = 0)
    private String employeeId;

    @CsvBindByPosition(position = 1)
    private String empcardOwner;

    @CsvBindByPosition(position = 2)
    private String card1Nm;

    @CsvBindByPosition(position = 3)
    private String card2Nm;

    @CsvBindByPosition(position = 4)
    private String card3Nm;

    @CsvBindByPosition(position = 5)
    private String card4Nm;

    @CsvBindByPosition(position = 6)
    private String card5Nm;

    @CsvBindByPosition(position = 7)
    private String card6Nm;

    @CsvBindByPosition(position = 8)
    private String card7Nm;

    private String createUser;

    private Date createDate;

    private String createPgid;

    private String updateUser;

    private Date updateDate;

    private String updatePgid;
}
