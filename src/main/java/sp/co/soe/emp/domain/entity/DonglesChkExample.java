package sp.co.soe.emp.domain.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class DonglesChkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public DonglesChkExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
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

        public Criteria andPeriodMonthIsNull() {
            addCriterion("period_month is null");
            return (Criteria) this;
        }

        public Criteria andPeriodMonthIsNotNull() {
            addCriterion("period_month is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodMonthEqualTo(Date value) {
            addCriterionForJDBCDate("period_month =", value, "periodMonth");
            return (Criteria) this;
        }

        public Criteria andPeriodMonthNotEqualTo(Date value) {
            addCriterionForJDBCDate("period_month <>", value, "periodMonth");
            return (Criteria) this;
        }

        public Criteria andPeriodMonthGreaterThan(Date value) {
            addCriterionForJDBCDate("period_month >", value, "periodMonth");
            return (Criteria) this;
        }

        public Criteria andPeriodMonthGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("period_month >=", value, "periodMonth");
            return (Criteria) this;
        }

        public Criteria andPeriodMonthLessThan(Date value) {
            addCriterionForJDBCDate("period_month <", value, "periodMonth");
            return (Criteria) this;
        }

        public Criteria andPeriodMonthLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("period_month <=", value, "periodMonth");
            return (Criteria) this;
        }

        public Criteria andPeriodMonthIn(List<Date> values) {
            addCriterionForJDBCDate("period_month in", values, "periodMonth");
            return (Criteria) this;
        }

        public Criteria andPeriodMonthNotIn(List<Date> values) {
            addCriterionForJDBCDate("period_month not in", values, "periodMonth");
            return (Criteria) this;
        }

        public Criteria andPeriodMonthBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("period_month between", value1, value2, "periodMonth");
            return (Criteria) this;
        }

        public Criteria andPeriodMonthNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("period_month not between", value1, value2, "periodMonth");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNull() {
            addCriterion("employee_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNotNull() {
            addCriterion("employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdEqualTo(String value) {
            addCriterion("employee_id =", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotEqualTo(String value) {
            addCriterion("employee_id <>", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThan(String value) {
            addCriterion("employee_id >", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("employee_id >=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThan(String value) {
            addCriterion("employee_id <", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("employee_id <=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLike(String value) {
            addCriterion("employee_id like", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotLike(String value) {
            addCriterion("employee_id not like", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIn(List<String> values) {
            addCriterion("employee_id in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotIn(List<String> values) {
            addCriterion("employee_id not in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdBetween(String value1, String value2) {
            addCriterion("employee_id between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("employee_id not between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andManageNumIsNull() {
            addCriterion("manage_num is null");
            return (Criteria) this;
        }

        public Criteria andManageNumIsNotNull() {
            addCriterion("manage_num is not null");
            return (Criteria) this;
        }

        public Criteria andManageNumEqualTo(String value) {
            addCriterion("manage_num =", value, "manageNum");
            return (Criteria) this;
        }

        public Criteria andManageNumNotEqualTo(String value) {
            addCriterion("manage_num <>", value, "manageNum");
            return (Criteria) this;
        }

        public Criteria andManageNumGreaterThan(String value) {
            addCriterion("manage_num >", value, "manageNum");
            return (Criteria) this;
        }

        public Criteria andManageNumGreaterThanOrEqualTo(String value) {
            addCriterion("manage_num >=", value, "manageNum");
            return (Criteria) this;
        }

        public Criteria andManageNumLessThan(String value) {
            addCriterion("manage_num <", value, "manageNum");
            return (Criteria) this;
        }

        public Criteria andManageNumLessThanOrEqualTo(String value) {
            addCriterion("manage_num <=", value, "manageNum");
            return (Criteria) this;
        }

        public Criteria andManageNumLike(String value) {
            addCriterion("manage_num like", value, "manageNum");
            return (Criteria) this;
        }

        public Criteria andManageNumNotLike(String value) {
            addCriterion("manage_num not like", value, "manageNum");
            return (Criteria) this;
        }

        public Criteria andManageNumIn(List<String> values) {
            addCriterion("manage_num in", values, "manageNum");
            return (Criteria) this;
        }

        public Criteria andManageNumNotIn(List<String> values) {
            addCriterion("manage_num not in", values, "manageNum");
            return (Criteria) this;
        }

        public Criteria andManageNumBetween(String value1, String value2) {
            addCriterion("manage_num between", value1, value2, "manageNum");
            return (Criteria) this;
        }

        public Criteria andManageNumNotBetween(String value1, String value2) {
            addCriterion("manage_num not between", value1, value2, "manageNum");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateIsNull() {
            addCriterion("effective_date is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateIsNotNull() {
            addCriterion("effective_date is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateEqualTo(Date value) {
            addCriterion("effective_date =", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateNotEqualTo(Date value) {
            addCriterion("effective_date <>", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateGreaterThan(Date value) {
            addCriterion("effective_date >", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateGreaterThanOrEqualTo(Date value) {
            addCriterion("effective_date >=", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateLessThan(Date value) {
            addCriterion("effective_date <", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateLessThanOrEqualTo(Date value) {
            addCriterion("effective_date <=", value, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateIn(List<Date> values) {
            addCriterion("effective_date in", values, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateNotIn(List<Date> values) {
            addCriterion("effective_date not in", values, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateBetween(Date value1, Date value2) {
            addCriterion("effective_date between", value1, value2, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andEffectiveDateNotBetween(Date value1, Date value2) {
            addCriterion("effective_date not between", value1, value2, "effectiveDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateIsNull() {
            addCriterion("return_date is null");
            return (Criteria) this;
        }

        public Criteria andReturnDateIsNotNull() {
            addCriterion("return_date is not null");
            return (Criteria) this;
        }

        public Criteria andReturnDateEqualTo(Date value) {
            addCriterion("return_date =", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotEqualTo(Date value) {
            addCriterion("return_date <>", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateGreaterThan(Date value) {
            addCriterion("return_date >", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateGreaterThanOrEqualTo(Date value) {
            addCriterion("return_date >=", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateLessThan(Date value) {
            addCriterion("return_date <", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateLessThanOrEqualTo(Date value) {
            addCriterion("return_date <=", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateIn(List<Date> values) {
            addCriterion("return_date in", values, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotIn(List<Date> values) {
            addCriterion("return_date not in", values, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateBetween(Date value1, Date value2) {
            addCriterion("return_date between", value1, value2, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotBetween(Date value1, Date value2) {
            addCriterion("return_date not between", value1, value2, "returnDate");
            return (Criteria) this;
        }

        public Criteria andChkUserIsNull() {
            addCriterion("chk_user is null");
            return (Criteria) this;
        }

        public Criteria andChkUserIsNotNull() {
            addCriterion("chk_user is not null");
            return (Criteria) this;
        }

        public Criteria andChkUserEqualTo(String value) {
            addCriterion("chk_user =", value, "chkUser");
            return (Criteria) this;
        }

        public Criteria andChkUserNotEqualTo(String value) {
            addCriterion("chk_user <>", value, "chkUser");
            return (Criteria) this;
        }

        public Criteria andChkUserGreaterThan(String value) {
            addCriterion("chk_user >", value, "chkUser");
            return (Criteria) this;
        }

        public Criteria andChkUserGreaterThanOrEqualTo(String value) {
            addCriterion("chk_user >=", value, "chkUser");
            return (Criteria) this;
        }

        public Criteria andChkUserLessThan(String value) {
            addCriterion("chk_user <", value, "chkUser");
            return (Criteria) this;
        }

        public Criteria andChkUserLessThanOrEqualTo(String value) {
            addCriterion("chk_user <=", value, "chkUser");
            return (Criteria) this;
        }

        public Criteria andChkUserLike(String value) {
            addCriterion("chk_user like", value, "chkUser");
            return (Criteria) this;
        }

        public Criteria andChkUserNotLike(String value) {
            addCriterion("chk_user not like", value, "chkUser");
            return (Criteria) this;
        }

        public Criteria andChkUserIn(List<String> values) {
            addCriterion("chk_user in", values, "chkUser");
            return (Criteria) this;
        }

        public Criteria andChkUserNotIn(List<String> values) {
            addCriterion("chk_user not in", values, "chkUser");
            return (Criteria) this;
        }

        public Criteria andChkUserBetween(String value1, String value2) {
            addCriterion("chk_user between", value1, value2, "chkUser");
            return (Criteria) this;
        }

        public Criteria andChkUserNotBetween(String value1, String value2) {
            addCriterion("chk_user not between", value1, value2, "chkUser");
            return (Criteria) this;
        }

        public Criteria andChkDateIsNull() {
            addCriterion("chk_date is null");
            return (Criteria) this;
        }

        public Criteria andChkDateIsNotNull() {
            addCriterion("chk_date is not null");
            return (Criteria) this;
        }

        public Criteria andChkDateEqualTo(Date value) {
            addCriterion("chk_date =", value, "chkDate");
            return (Criteria) this;
        }

        public Criteria andChkDateNotEqualTo(Date value) {
            addCriterion("chk_date <>", value, "chkDate");
            return (Criteria) this;
        }

        public Criteria andChkDateGreaterThan(Date value) {
            addCriterion("chk_date >", value, "chkDate");
            return (Criteria) this;
        }

        public Criteria andChkDateGreaterThanOrEqualTo(Date value) {
            addCriterion("chk_date >=", value, "chkDate");
            return (Criteria) this;
        }

        public Criteria andChkDateLessThan(Date value) {
            addCriterion("chk_date <", value, "chkDate");
            return (Criteria) this;
        }

        public Criteria andChkDateLessThanOrEqualTo(Date value) {
            addCriterion("chk_date <=", value, "chkDate");
            return (Criteria) this;
        }

        public Criteria andChkDateIn(List<Date> values) {
            addCriterion("chk_date in", values, "chkDate");
            return (Criteria) this;
        }

        public Criteria andChkDateNotIn(List<Date> values) {
            addCriterion("chk_date not in", values, "chkDate");
            return (Criteria) this;
        }

        public Criteria andChkDateBetween(Date value1, Date value2) {
            addCriterion("chk_date between", value1, value2, "chkDate");
            return (Criteria) this;
        }

        public Criteria andChkDateNotBetween(Date value1, Date value2) {
            addCriterion("chk_date not between", value1, value2, "chkDate");
            return (Criteria) this;
        }

        public Criteria andApprovalUserIsNull() {
            addCriterion("approval_user is null");
            return (Criteria) this;
        }

        public Criteria andApprovalUserIsNotNull() {
            addCriterion("approval_user is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalUserEqualTo(String value) {
            addCriterion("approval_user =", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNotEqualTo(String value) {
            addCriterion("approval_user <>", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserGreaterThan(String value) {
            addCriterion("approval_user >", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserGreaterThanOrEqualTo(String value) {
            addCriterion("approval_user >=", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserLessThan(String value) {
            addCriterion("approval_user <", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserLessThanOrEqualTo(String value) {
            addCriterion("approval_user <=", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserLike(String value) {
            addCriterion("approval_user like", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNotLike(String value) {
            addCriterion("approval_user not like", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserIn(List<String> values) {
            addCriterion("approval_user in", values, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNotIn(List<String> values) {
            addCriterion("approval_user not in", values, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserBetween(String value1, String value2) {
            addCriterion("approval_user between", value1, value2, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNotBetween(String value1, String value2) {
            addCriterion("approval_user not between", value1, value2, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalDateIsNull() {
            addCriterion("approval_date is null");
            return (Criteria) this;
        }

        public Criteria andApprovalDateIsNotNull() {
            addCriterion("approval_date is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalDateEqualTo(Date value) {
            addCriterion("approval_date =", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateNotEqualTo(Date value) {
            addCriterion("approval_date <>", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateGreaterThan(Date value) {
            addCriterion("approval_date >", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateGreaterThanOrEqualTo(Date value) {
            addCriterion("approval_date >=", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateLessThan(Date value) {
            addCriterion("approval_date <", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateLessThanOrEqualTo(Date value) {
            addCriterion("approval_date <=", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateIn(List<Date> values) {
            addCriterion("approval_date in", values, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateNotIn(List<Date> values) {
            addCriterion("approval_date not in", values, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateBetween(Date value1, Date value2) {
            addCriterion("approval_date between", value1, value2, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateNotBetween(Date value1, Date value2) {
            addCriterion("approval_date not between", value1, value2, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andNotesIsNull() {
            addCriterion("notes is null");
            return (Criteria) this;
        }

        public Criteria andNotesIsNotNull() {
            addCriterion("notes is not null");
            return (Criteria) this;
        }

        public Criteria andNotesEqualTo(String value) {
            addCriterion("notes =", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotEqualTo(String value) {
            addCriterion("notes <>", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThan(String value) {
            addCriterion("notes >", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThanOrEqualTo(String value) {
            addCriterion("notes >=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThan(String value) {
            addCriterion("notes <", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThanOrEqualTo(String value) {
            addCriterion("notes <=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLike(String value) {
            addCriterion("notes like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotLike(String value) {
            addCriterion("notes not like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesIn(List<String> values) {
            addCriterion("notes in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotIn(List<String> values) {
            addCriterion("notes not in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesBetween(String value1, String value2) {
            addCriterion("notes between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotBetween(String value1, String value2) {
            addCriterion("notes not between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andChkFlgIsNull() {
            addCriterion("chk_flg is null");
            return (Criteria) this;
        }

        public Criteria andChkFlgIsNotNull() {
            addCriterion("chk_flg is not null");
            return (Criteria) this;
        }

        public Criteria andChkFlgEqualTo(String value) {
            addCriterion("chk_flg =", value, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgNotEqualTo(String value) {
            addCriterion("chk_flg <>", value, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgGreaterThan(String value) {
            addCriterion("chk_flg >", value, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgGreaterThanOrEqualTo(String value) {
            addCriterion("chk_flg >=", value, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgLessThan(String value) {
            addCriterion("chk_flg <", value, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgLessThanOrEqualTo(String value) {
            addCriterion("chk_flg <=", value, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgLike(String value) {
            addCriterion("chk_flg like", value, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgNotLike(String value) {
            addCriterion("chk_flg not like", value, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgIn(List<String> values) {
            addCriterion("chk_flg in", values, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgNotIn(List<String> values) {
            addCriterion("chk_flg not in", values, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgBetween(String value1, String value2) {
            addCriterion("chk_flg between", value1, value2, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andChkFlgNotBetween(String value1, String value2) {
            addCriterion("chk_flg not between", value1, value2, "chkFlg");
            return (Criteria) this;
        }

        public Criteria andApprovalFlgIsNull() {
            addCriterion("approval_flg is null");
            return (Criteria) this;
        }

        public Criteria andApprovalFlgIsNotNull() {
            addCriterion("approval_flg is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalFlgEqualTo(String value) {
            addCriterion("approval_flg =", value, "approvalFlg");
            return (Criteria) this;
        }

        public Criteria andApprovalFlgNotEqualTo(String value) {
            addCriterion("approval_flg <>", value, "approvalFlg");
            return (Criteria) this;
        }

        public Criteria andApprovalFlgGreaterThan(String value) {
            addCriterion("approval_flg >", value, "approvalFlg");
            return (Criteria) this;
        }

        public Criteria andApprovalFlgGreaterThanOrEqualTo(String value) {
            addCriterion("approval_flg >=", value, "approvalFlg");
            return (Criteria) this;
        }

        public Criteria andApprovalFlgLessThan(String value) {
            addCriterion("approval_flg <", value, "approvalFlg");
            return (Criteria) this;
        }

        public Criteria andApprovalFlgLessThanOrEqualTo(String value) {
            addCriterion("approval_flg <=", value, "approvalFlg");
            return (Criteria) this;
        }

        public Criteria andApprovalFlgLike(String value) {
            addCriterion("approval_flg like", value, "approvalFlg");
            return (Criteria) this;
        }

        public Criteria andApprovalFlgNotLike(String value) {
            addCriterion("approval_flg not like", value, "approvalFlg");
            return (Criteria) this;
        }

        public Criteria andApprovalFlgIn(List<String> values) {
            addCriterion("approval_flg in", values, "approvalFlg");
            return (Criteria) this;
        }

        public Criteria andApprovalFlgNotIn(List<String> values) {
            addCriterion("approval_flg not in", values, "approvalFlg");
            return (Criteria) this;
        }

        public Criteria andApprovalFlgBetween(String value1, String value2) {
            addCriterion("approval_flg between", value1, value2, "approvalFlg");
            return (Criteria) this;
        }

        public Criteria andApprovalFlgNotBetween(String value1, String value2) {
            addCriterion("approval_flg not between", value1, value2, "approvalFlg");
            return (Criteria) this;
        }

        public Criteria andEditFlgIsNull() {
            addCriterion("edit_flg is null");
            return (Criteria) this;
        }

        public Criteria andEditFlgIsNotNull() {
            addCriterion("edit_flg is not null");
            return (Criteria) this;
        }

        public Criteria andEditFlgEqualTo(String value) {
            addCriterion("edit_flg =", value, "editFlg");
            return (Criteria) this;
        }

        public Criteria andEditFlgNotEqualTo(String value) {
            addCriterion("edit_flg <>", value, "editFlg");
            return (Criteria) this;
        }

        public Criteria andEditFlgGreaterThan(String value) {
            addCriterion("edit_flg >", value, "editFlg");
            return (Criteria) this;
        }

        public Criteria andEditFlgGreaterThanOrEqualTo(String value) {
            addCriterion("edit_flg >=", value, "editFlg");
            return (Criteria) this;
        }

        public Criteria andEditFlgLessThan(String value) {
            addCriterion("edit_flg <", value, "editFlg");
            return (Criteria) this;
        }

        public Criteria andEditFlgLessThanOrEqualTo(String value) {
            addCriterion("edit_flg <=", value, "editFlg");
            return (Criteria) this;
        }

        public Criteria andEditFlgLike(String value) {
            addCriterion("edit_flg like", value, "editFlg");
            return (Criteria) this;
        }

        public Criteria andEditFlgNotLike(String value) {
            addCriterion("edit_flg not like", value, "editFlg");
            return (Criteria) this;
        }

        public Criteria andEditFlgIn(List<String> values) {
            addCriterion("edit_flg in", values, "editFlg");
            return (Criteria) this;
        }

        public Criteria andEditFlgNotIn(List<String> values) {
            addCriterion("edit_flg not in", values, "editFlg");
            return (Criteria) this;
        }

        public Criteria andEditFlgBetween(String value1, String value2) {
            addCriterion("edit_flg between", value1, value2, "editFlg");
            return (Criteria) this;
        }

        public Criteria andEditFlgNotBetween(String value1, String value2) {
            addCriterion("edit_flg not between", value1, value2, "editFlg");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreatePgidIsNull() {
            addCriterion("create_pgid is null");
            return (Criteria) this;
        }

        public Criteria andCreatePgidIsNotNull() {
            addCriterion("create_pgid is not null");
            return (Criteria) this;
        }

        public Criteria andCreatePgidEqualTo(String value) {
            addCriterion("create_pgid =", value, "createPgid");
            return (Criteria) this;
        }

        public Criteria andCreatePgidNotEqualTo(String value) {
            addCriterion("create_pgid <>", value, "createPgid");
            return (Criteria) this;
        }

        public Criteria andCreatePgidGreaterThan(String value) {
            addCriterion("create_pgid >", value, "createPgid");
            return (Criteria) this;
        }

        public Criteria andCreatePgidGreaterThanOrEqualTo(String value) {
            addCriterion("create_pgid >=", value, "createPgid");
            return (Criteria) this;
        }

        public Criteria andCreatePgidLessThan(String value) {
            addCriterion("create_pgid <", value, "createPgid");
            return (Criteria) this;
        }

        public Criteria andCreatePgidLessThanOrEqualTo(String value) {
            addCriterion("create_pgid <=", value, "createPgid");
            return (Criteria) this;
        }

        public Criteria andCreatePgidLike(String value) {
            addCriterion("create_pgid like", value, "createPgid");
            return (Criteria) this;
        }

        public Criteria andCreatePgidNotLike(String value) {
            addCriterion("create_pgid not like", value, "createPgid");
            return (Criteria) this;
        }

        public Criteria andCreatePgidIn(List<String> values) {
            addCriterion("create_pgid in", values, "createPgid");
            return (Criteria) this;
        }

        public Criteria andCreatePgidNotIn(List<String> values) {
            addCriterion("create_pgid not in", values, "createPgid");
            return (Criteria) this;
        }

        public Criteria andCreatePgidBetween(String value1, String value2) {
            addCriterion("create_pgid between", value1, value2, "createPgid");
            return (Criteria) this;
        }

        public Criteria andCreatePgidNotBetween(String value1, String value2) {
            addCriterion("create_pgid not between", value1, value2, "createPgid");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdatePgidIsNull() {
            addCriterion("update_pgid is null");
            return (Criteria) this;
        }

        public Criteria andUpdatePgidIsNotNull() {
            addCriterion("update_pgid is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatePgidEqualTo(String value) {
            addCriterion("update_pgid =", value, "updatePgid");
            return (Criteria) this;
        }

        public Criteria andUpdatePgidNotEqualTo(String value) {
            addCriterion("update_pgid <>", value, "updatePgid");
            return (Criteria) this;
        }

        public Criteria andUpdatePgidGreaterThan(String value) {
            addCriterion("update_pgid >", value, "updatePgid");
            return (Criteria) this;
        }

        public Criteria andUpdatePgidGreaterThanOrEqualTo(String value) {
            addCriterion("update_pgid >=", value, "updatePgid");
            return (Criteria) this;
        }

        public Criteria andUpdatePgidLessThan(String value) {
            addCriterion("update_pgid <", value, "updatePgid");
            return (Criteria) this;
        }

        public Criteria andUpdatePgidLessThanOrEqualTo(String value) {
            addCriterion("update_pgid <=", value, "updatePgid");
            return (Criteria) this;
        }

        public Criteria andUpdatePgidLike(String value) {
            addCriterion("update_pgid like", value, "updatePgid");
            return (Criteria) this;
        }

        public Criteria andUpdatePgidNotLike(String value) {
            addCriterion("update_pgid not like", value, "updatePgid");
            return (Criteria) this;
        }

        public Criteria andUpdatePgidIn(List<String> values) {
            addCriterion("update_pgid in", values, "updatePgid");
            return (Criteria) this;
        }

        public Criteria andUpdatePgidNotIn(List<String> values) {
            addCriterion("update_pgid not in", values, "updatePgid");
            return (Criteria) this;
        }

        public Criteria andUpdatePgidBetween(String value1, String value2) {
            addCriterion("update_pgid between", value1, value2, "updatePgid");
            return (Criteria) this;
        }

        public Criteria andUpdatePgidNotBetween(String value1, String value2) {
            addCriterion("update_pgid not between", value1, value2, "updatePgid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
}