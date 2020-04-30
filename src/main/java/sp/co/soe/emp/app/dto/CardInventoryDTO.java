package sp.co.soe.emp.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CardInventoryDTO {
    private String periodMonth;
    private String employeeId;
    private String firstName;
    private String lastName;
    private String deptCode;
    private String deptName;
    private String empcardOwner;
    private String card1Nm;
    private String card2Nm;
    private String card3Nm;
    private String card4Nm;
    private String workName;
    private String placeName;
    private String empcardFlg;
    private String card1Flg;
    private String card2Flg;
    private String card3Flg;
    private String card4Flg;
    private String chkUserId;
    private String chkUserName;
    private Date chkDate;
    private String approvalUserId;
    private String approvalUserName;
    private Date approvalDate;
    private String notes;
    private String chkFlg;
    private String approvalFlg;
}
