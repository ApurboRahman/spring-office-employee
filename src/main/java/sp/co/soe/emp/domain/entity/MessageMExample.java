package sp.co.soe.emp.domain.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class MessageMExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public MessageMExample() {
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

        public Criteria andMessageIdIsNull() {
            addCriterion("message_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNotNull() {
            addCriterion("message_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageIdEqualTo(Integer value) {
            addCriterion("message_id =", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotEqualTo(Integer value) {
            addCriterion("message_id <>", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThan(Integer value) {
            addCriterion("message_id >", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_id >=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThan(Integer value) {
            addCriterion("message_id <", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThanOrEqualTo(Integer value) {
            addCriterion("message_id <=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIn(List<Integer> values) {
            addCriterion("message_id in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotIn(List<Integer> values) {
            addCriterion("message_id not in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdBetween(Integer value1, Integer value2) {
            addCriterion("message_id between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("message_id not between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageNmIsNull() {
            addCriterion("message_nm is null");
            return (Criteria) this;
        }

        public Criteria andMessageNmIsNotNull() {
            addCriterion("message_nm is not null");
            return (Criteria) this;
        }

        public Criteria andMessageNmEqualTo(String value) {
            addCriterion("message_nm =", value, "messageNm");
            return (Criteria) this;
        }

        public Criteria andMessageNmNotEqualTo(String value) {
            addCriterion("message_nm <>", value, "messageNm");
            return (Criteria) this;
        }

        public Criteria andMessageNmGreaterThan(String value) {
            addCriterion("message_nm >", value, "messageNm");
            return (Criteria) this;
        }

        public Criteria andMessageNmGreaterThanOrEqualTo(String value) {
            addCriterion("message_nm >=", value, "messageNm");
            return (Criteria) this;
        }

        public Criteria andMessageNmLessThan(String value) {
            addCriterion("message_nm <", value, "messageNm");
            return (Criteria) this;
        }

        public Criteria andMessageNmLessThanOrEqualTo(String value) {
            addCriterion("message_nm <=", value, "messageNm");
            return (Criteria) this;
        }

        public Criteria andMessageNmLike(String value) {
            addCriterion("message_nm like", value, "messageNm");
            return (Criteria) this;
        }

        public Criteria andMessageNmNotLike(String value) {
            addCriterion("message_nm not like", value, "messageNm");
            return (Criteria) this;
        }

        public Criteria andMessageNmIn(List<String> values) {
            addCriterion("message_nm in", values, "messageNm");
            return (Criteria) this;
        }

        public Criteria andMessageNmNotIn(List<String> values) {
            addCriterion("message_nm not in", values, "messageNm");
            return (Criteria) this;
        }

        public Criteria andMessageNmBetween(String value1, String value2) {
            addCriterion("message_nm between", value1, value2, "messageNm");
            return (Criteria) this;
        }

        public Criteria andMessageNmNotBetween(String value1, String value2) {
            addCriterion("message_nm not between", value1, value2, "messageNm");
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