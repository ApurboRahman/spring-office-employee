package sp.co.soe.emp.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmployeeInfoExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table employee_info
	 * @mbg.generated  Tue Mar 24 22:41:21 JST 2020
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table employee_info
	 * @mbg.generated  Tue Mar 24 22:41:21 JST 2020
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table employee_info
	 * @mbg.generated  Tue Mar 24 22:41:21 JST 2020
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_info
	 * @mbg.generated  Tue Mar 24 22:41:21 JST 2020
	 */
	public EmployeeInfoExample() {
		oredCriteria = new ArrayList<>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_info
	 * @mbg.generated  Tue Mar 24 22:41:21 JST 2020
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_info
	 * @mbg.generated  Tue Mar 24 22:41:21 JST 2020
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_info
	 * @mbg.generated  Tue Mar 24 22:41:21 JST 2020
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_info
	 * @mbg.generated  Tue Mar 24 22:41:21 JST 2020
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_info
	 * @mbg.generated  Tue Mar 24 22:41:21 JST 2020
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_info
	 * @mbg.generated  Tue Mar 24 22:41:21 JST 2020
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_info
	 * @mbg.generated  Tue Mar 24 22:41:21 JST 2020
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_info
	 * @mbg.generated  Tue Mar 24 22:41:21 JST 2020
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_info
	 * @mbg.generated  Tue Mar 24 22:41:21 JST 2020
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_info
	 * @mbg.generated  Tue Mar 24 22:41:21 JST 2020
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table employee_info
	 * @mbg.generated  Tue Mar 24 22:41:21 JST 2020
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andMannoIsNull() {
			addCriterion("manno is null");
			return (Criteria) this;
		}

		public Criteria andMannoIsNotNull() {
			addCriterion("manno is not null");
			return (Criteria) this;
		}

		public Criteria andMannoEqualTo(Integer value) {
			addCriterion("manno =", value, "manno");
			return (Criteria) this;
		}

		public Criteria andMannoNotEqualTo(Integer value) {
			addCriterion("manno <>", value, "manno");
			return (Criteria) this;
		}

		public Criteria andMannoGreaterThan(Integer value) {
			addCriterion("manno >", value, "manno");
			return (Criteria) this;
		}

		public Criteria andMannoGreaterThanOrEqualTo(Integer value) {
			addCriterion("manno >=", value, "manno");
			return (Criteria) this;
		}

		public Criteria andMannoLessThan(Integer value) {
			addCriterion("manno <", value, "manno");
			return (Criteria) this;
		}

		public Criteria andMannoLessThanOrEqualTo(Integer value) {
			addCriterion("manno <=", value, "manno");
			return (Criteria) this;
		}

		public Criteria andMannoIn(List<Integer> values) {
			addCriterion("manno in", values, "manno");
			return (Criteria) this;
		}

		public Criteria andMannoNotIn(List<Integer> values) {
			addCriterion("manno not in", values, "manno");
			return (Criteria) this;
		}

		public Criteria andMannoBetween(Integer value1, Integer value2) {
			addCriterion("manno between", value1, value2, "manno");
			return (Criteria) this;
		}

		public Criteria andMannoNotBetween(Integer value1, Integer value2) {
			addCriterion("manno not between", value1, value2, "manno");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andJoinDateIsNull() {
			addCriterion("join_date is null");
			return (Criteria) this;
		}

		public Criteria andJoinDateIsNotNull() {
			addCriterion("join_date is not null");
			return (Criteria) this;
		}

		public Criteria andJoinDateEqualTo(Date value) {
			addCriterionForJDBCDate("join_date =", value, "joinDate");
			return (Criteria) this;
		}

		public Criteria andJoinDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("join_date <>", value, "joinDate");
			return (Criteria) this;
		}

		public Criteria andJoinDateGreaterThan(Date value) {
			addCriterionForJDBCDate("join_date >", value, "joinDate");
			return (Criteria) this;
		}

		public Criteria andJoinDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("join_date >=", value, "joinDate");
			return (Criteria) this;
		}

		public Criteria andJoinDateLessThan(Date value) {
			addCriterionForJDBCDate("join_date <", value, "joinDate");
			return (Criteria) this;
		}

		public Criteria andJoinDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("join_date <=", value, "joinDate");
			return (Criteria) this;
		}

		public Criteria andJoinDateIn(List<Date> values) {
			addCriterionForJDBCDate("join_date in", values, "joinDate");
			return (Criteria) this;
		}

		public Criteria andJoinDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("join_date not in", values, "joinDate");
			return (Criteria) this;
		}

		public Criteria andJoinDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("join_date between", value1, value2, "joinDate");
			return (Criteria) this;
		}

		public Criteria andJoinDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("join_date not between", value1, value2, "joinDate");
			return (Criteria) this;
		}

		public Criteria andSexIsNull() {
			addCriterion("sex is null");
			return (Criteria) this;
		}

		public Criteria andSexIsNotNull() {
			addCriterion("sex is not null");
			return (Criteria) this;
		}

		public Criteria andSexEqualTo(String value) {
			addCriterion("sex =", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotEqualTo(String value) {
			addCriterion("sex <>", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThan(String value) {
			addCriterion("sex >", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThanOrEqualTo(String value) {
			addCriterion("sex >=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThan(String value) {
			addCriterion("sex <", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThanOrEqualTo(String value) {
			addCriterion("sex <=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLike(String value) {
			addCriterion("sex like", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotLike(String value) {
			addCriterion("sex not like", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexIn(List<String> values) {
			addCriterion("sex in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotIn(List<String> values) {
			addCriterion("sex not in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexBetween(String value1, String value2) {
			addCriterion("sex between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotBetween(String value1, String value2) {
			addCriterion("sex not between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andEnrollmentTypeIsNull() {
			addCriterion("enrollment_type is null");
			return (Criteria) this;
		}

		public Criteria andEnrollmentTypeIsNotNull() {
			addCriterion("enrollment_type is not null");
			return (Criteria) this;
		}

		public Criteria andEnrollmentTypeEqualTo(String value) {
			addCriterion("enrollment_type =", value, "enrollmentType");
			return (Criteria) this;
		}

		public Criteria andEnrollmentTypeNotEqualTo(String value) {
			addCriterion("enrollment_type <>", value, "enrollmentType");
			return (Criteria) this;
		}

		public Criteria andEnrollmentTypeGreaterThan(String value) {
			addCriterion("enrollment_type >", value, "enrollmentType");
			return (Criteria) this;
		}

		public Criteria andEnrollmentTypeGreaterThanOrEqualTo(String value) {
			addCriterion("enrollment_type >=", value, "enrollmentType");
			return (Criteria) this;
		}

		public Criteria andEnrollmentTypeLessThan(String value) {
			addCriterion("enrollment_type <", value, "enrollmentType");
			return (Criteria) this;
		}

		public Criteria andEnrollmentTypeLessThanOrEqualTo(String value) {
			addCriterion("enrollment_type <=", value, "enrollmentType");
			return (Criteria) this;
		}

		public Criteria andEnrollmentTypeLike(String value) {
			addCriterion("enrollment_type like", value, "enrollmentType");
			return (Criteria) this;
		}

		public Criteria andEnrollmentTypeNotLike(String value) {
			addCriterion("enrollment_type not like", value, "enrollmentType");
			return (Criteria) this;
		}

		public Criteria andEnrollmentTypeIn(List<String> values) {
			addCriterion("enrollment_type in", values, "enrollmentType");
			return (Criteria) this;
		}

		public Criteria andEnrollmentTypeNotIn(List<String> values) {
			addCriterion("enrollment_type not in", values, "enrollmentType");
			return (Criteria) this;
		}

		public Criteria andEnrollmentTypeBetween(String value1, String value2) {
			addCriterion("enrollment_type between", value1, value2, "enrollmentType");
			return (Criteria) this;
		}

		public Criteria andEnrollmentTypeNotBetween(String value1, String value2) {
			addCriterion("enrollment_type not between", value1, value2, "enrollmentType");
			return (Criteria) this;
		}

		public Criteria andTimeSavingIsNull() {
			addCriterion("time_saving is null");
			return (Criteria) this;
		}

		public Criteria andTimeSavingIsNotNull() {
			addCriterion("time_saving is not null");
			return (Criteria) this;
		}

		public Criteria andTimeSavingEqualTo(Boolean value) {
			addCriterion("time_saving =", value, "timeSaving");
			return (Criteria) this;
		}

		public Criteria andTimeSavingNotEqualTo(Boolean value) {
			addCriterion("time_saving <>", value, "timeSaving");
			return (Criteria) this;
		}

		public Criteria andTimeSavingGreaterThan(Boolean value) {
			addCriterion("time_saving >", value, "timeSaving");
			return (Criteria) this;
		}

		public Criteria andTimeSavingGreaterThanOrEqualTo(Boolean value) {
			addCriterion("time_saving >=", value, "timeSaving");
			return (Criteria) this;
		}

		public Criteria andTimeSavingLessThan(Boolean value) {
			addCriterion("time_saving <", value, "timeSaving");
			return (Criteria) this;
		}

		public Criteria andTimeSavingLessThanOrEqualTo(Boolean value) {
			addCriterion("time_saving <=", value, "timeSaving");
			return (Criteria) this;
		}

		public Criteria andTimeSavingIn(List<Boolean> values) {
			addCriterion("time_saving in", values, "timeSaving");
			return (Criteria) this;
		}

		public Criteria andTimeSavingNotIn(List<Boolean> values) {
			addCriterion("time_saving not in", values, "timeSaving");
			return (Criteria) this;
		}

		public Criteria andTimeSavingBetween(Boolean value1, Boolean value2) {
			addCriterion("time_saving between", value1, value2, "timeSaving");
			return (Criteria) this;
		}

		public Criteria andTimeSavingNotBetween(Boolean value1, Boolean value2) {
			addCriterion("time_saving not between", value1, value2, "timeSaving");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table employee_info
	 * @mbg.generated  Tue Mar 24 22:41:21 JST 2020
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table employee_info
     *
     * @mbg.generated do_not_delete_during_merge Tue Jan 14 11:04:46 JST 2020
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}