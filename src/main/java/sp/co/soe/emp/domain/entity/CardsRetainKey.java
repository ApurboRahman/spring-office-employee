package sp.co.soe.emp.domain.entity;

import java.util.Date;

public class CardsRetainKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cards_retain.period_month
	 * @mbg.generated  Thu Apr 09 11:15:08 JST 2020
	 */
	private Date periodMonth;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column cards_retain.employee_id
	 * @mbg.generated  Thu Apr 09 11:15:08 JST 2020
	 */
	private String employeeId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cards_retain.period_month
	 * @return  the value of cards_retain.period_month
	 * @mbg.generated  Thu Apr 09 11:15:08 JST 2020
	 */
	public Date getPeriodMonth() {
		return periodMonth;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cards_retain.period_month
	 * @param periodMonth  the value for cards_retain.period_month
	 * @mbg.generated  Thu Apr 09 11:15:08 JST 2020
	 */
	public void setPeriodMonth(Date periodMonth) {
		this.periodMonth = periodMonth;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column cards_retain.employee_id
	 * @return  the value of cards_retain.employee_id
	 * @mbg.generated  Thu Apr 09 11:15:08 JST 2020
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column cards_retain.employee_id
	 * @param employeeId  the value for cards_retain.employee_id
	 * @mbg.generated  Thu Apr 09 11:15:08 JST 2020
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId == null ? null : employeeId.trim();
	}
}