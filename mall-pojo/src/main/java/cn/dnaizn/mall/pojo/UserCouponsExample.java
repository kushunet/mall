package cn.dnaizn.mall.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserCouponsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserCouponsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdIsNull() {
            addCriterion("discount_id is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIdIsNotNull() {
            addCriterion("discount_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountIdEqualTo(String value) {
            addCriterion("discount_id =", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdNotEqualTo(String value) {
            addCriterion("discount_id <>", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdGreaterThan(String value) {
            addCriterion("discount_id >", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdGreaterThanOrEqualTo(String value) {
            addCriterion("discount_id >=", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdLessThan(String value) {
            addCriterion("discount_id <", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdLessThanOrEqualTo(String value) {
            addCriterion("discount_id <=", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdLike(String value) {
            addCriterion("discount_id like", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdNotLike(String value) {
            addCriterion("discount_id not like", value, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdIn(List<String> values) {
            addCriterion("discount_id in", values, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdNotIn(List<String> values) {
            addCriterion("discount_id not in", values, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdBetween(String value1, String value2) {
            addCriterion("discount_id between", value1, value2, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountIdNotBetween(String value1, String value2) {
            addCriterion("discount_id not between", value1, value2, "discountId");
            return (Criteria) this;
        }

        public Criteria andDiscountUuidIsNull() {
            addCriterion("discount_uuid is null");
            return (Criteria) this;
        }

        public Criteria andDiscountUuidIsNotNull() {
            addCriterion("discount_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountUuidEqualTo(String value) {
            addCriterion("discount_uuid =", value, "discountUuid");
            return (Criteria) this;
        }

        public Criteria andDiscountUuidNotEqualTo(String value) {
            addCriterion("discount_uuid <>", value, "discountUuid");
            return (Criteria) this;
        }

        public Criteria andDiscountUuidGreaterThan(String value) {
            addCriterion("discount_uuid >", value, "discountUuid");
            return (Criteria) this;
        }

        public Criteria andDiscountUuidGreaterThanOrEqualTo(String value) {
            addCriterion("discount_uuid >=", value, "discountUuid");
            return (Criteria) this;
        }

        public Criteria andDiscountUuidLessThan(String value) {
            addCriterion("discount_uuid <", value, "discountUuid");
            return (Criteria) this;
        }

        public Criteria andDiscountUuidLessThanOrEqualTo(String value) {
            addCriterion("discount_uuid <=", value, "discountUuid");
            return (Criteria) this;
        }

        public Criteria andDiscountUuidLike(String value) {
            addCriterion("discount_uuid like", value, "discountUuid");
            return (Criteria) this;
        }

        public Criteria andDiscountUuidNotLike(String value) {
            addCriterion("discount_uuid not like", value, "discountUuid");
            return (Criteria) this;
        }

        public Criteria andDiscountUuidIn(List<String> values) {
            addCriterion("discount_uuid in", values, "discountUuid");
            return (Criteria) this;
        }

        public Criteria andDiscountUuidNotIn(List<String> values) {
            addCriterion("discount_uuid not in", values, "discountUuid");
            return (Criteria) this;
        }

        public Criteria andDiscountUuidBetween(String value1, String value2) {
            addCriterion("discount_uuid between", value1, value2, "discountUuid");
            return (Criteria) this;
        }

        public Criteria andDiscountUuidNotBetween(String value1, String value2) {
            addCriterion("discount_uuid not between", value1, value2, "discountUuid");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Object value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Object value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Object value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Object value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Object value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Object value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Object> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Object> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Object value1, Object value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Object value1, Object value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andCTimeIsNull() {
            addCriterion("c_time is null");
            return (Criteria) this;
        }

        public Criteria andCTimeIsNotNull() {
            addCriterion("c_time is not null");
            return (Criteria) this;
        }

        public Criteria andCTimeEqualTo(Integer value) {
            addCriterion("c_time =", value, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeNotEqualTo(Integer value) {
            addCriterion("c_time <>", value, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeGreaterThan(Integer value) {
            addCriterion("c_time >", value, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_time >=", value, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeLessThan(Integer value) {
            addCriterion("c_time <", value, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeLessThanOrEqualTo(Integer value) {
            addCriterion("c_time <=", value, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeIn(List<Integer> values) {
            addCriterion("c_time in", values, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeNotIn(List<Integer> values) {
            addCriterion("c_time not in", values, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeBetween(Integer value1, Integer value2) {
            addCriterion("c_time between", value1, value2, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("c_time not between", value1, value2, "cTime");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andExpireIsNull() {
            addCriterion("expire is null");
            return (Criteria) this;
        }

        public Criteria andExpireIsNotNull() {
            addCriterion("expire is not null");
            return (Criteria) this;
        }

        public Criteria andExpireEqualTo(Integer value) {
            addCriterion("expire =", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireNotEqualTo(Integer value) {
            addCriterion("expire <>", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireGreaterThan(Integer value) {
            addCriterion("expire >", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireGreaterThanOrEqualTo(Integer value) {
            addCriterion("expire >=", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireLessThan(Integer value) {
            addCriterion("expire <", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireLessThanOrEqualTo(Integer value) {
            addCriterion("expire <=", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireIn(List<Integer> values) {
            addCriterion("expire in", values, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireNotIn(List<Integer> values) {
            addCriterion("expire not in", values, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireBetween(Integer value1, Integer value2) {
            addCriterion("expire between", value1, value2, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireNotBetween(Integer value1, Integer value2) {
            addCriterion("expire not between", value1, value2, "expire");
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