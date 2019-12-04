package cn.dnaizn.mall.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SellerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SellerExample() {
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

        public Criteria andSellerIdIsNull() {
            addCriterion("seller_id is null");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNotNull() {
            addCriterion("seller_id is not null");
            return (Criteria) this;
        }

        public Criteria andSellerIdEqualTo(String value) {
            addCriterion("seller_id =", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotEqualTo(String value) {
            addCriterion("seller_id <>", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThan(String value) {
            addCriterion("seller_id >", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThanOrEqualTo(String value) {
            addCriterion("seller_id >=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThan(String value) {
            addCriterion("seller_id <", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThanOrEqualTo(String value) {
            addCriterion("seller_id <=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLike(String value) {
            addCriterion("seller_id like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotLike(String value) {
            addCriterion("seller_id not like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdIn(List<String> values) {
            addCriterion("seller_id in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotIn(List<String> values) {
            addCriterion("seller_id not in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdBetween(String value1, String value2) {
            addCriterion("seller_id between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotBetween(String value1, String value2) {
            addCriterion("seller_id not between", value1, value2, "sellerId");
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

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<BigDecimal> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<BigDecimal> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andTBalanceIsNull() {
            addCriterion("t_balance is null");
            return (Criteria) this;
        }

        public Criteria andTBalanceIsNotNull() {
            addCriterion("t_balance is not null");
            return (Criteria) this;
        }

        public Criteria andTBalanceEqualTo(BigDecimal value) {
            addCriterion("t_balance =", value, "tBalance");
            return (Criteria) this;
        }

        public Criteria andTBalanceNotEqualTo(BigDecimal value) {
            addCriterion("t_balance <>", value, "tBalance");
            return (Criteria) this;
        }

        public Criteria andTBalanceGreaterThan(BigDecimal value) {
            addCriterion("t_balance >", value, "tBalance");
            return (Criteria) this;
        }

        public Criteria andTBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("t_balance >=", value, "tBalance");
            return (Criteria) this;
        }

        public Criteria andTBalanceLessThan(BigDecimal value) {
            addCriterion("t_balance <", value, "tBalance");
            return (Criteria) this;
        }

        public Criteria andTBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("t_balance <=", value, "tBalance");
            return (Criteria) this;
        }

        public Criteria andTBalanceIn(List<BigDecimal> values) {
            addCriterion("t_balance in", values, "tBalance");
            return (Criteria) this;
        }

        public Criteria andTBalanceNotIn(List<BigDecimal> values) {
            addCriterion("t_balance not in", values, "tBalance");
            return (Criteria) this;
        }

        public Criteria andTBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("t_balance between", value1, value2, "tBalance");
            return (Criteria) this;
        }

        public Criteria andTBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("t_balance not between", value1, value2, "tBalance");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusIsNull() {
            addCriterion("delivery_status is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusIsNotNull() {
            addCriterion("delivery_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusEqualTo(Integer value) {
            addCriterion("delivery_status =", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusNotEqualTo(Integer value) {
            addCriterion("delivery_status <>", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusGreaterThan(Integer value) {
            addCriterion("delivery_status >", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_status >=", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusLessThan(Integer value) {
            addCriterion("delivery_status <", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_status <=", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusIn(List<Integer> values) {
            addCriterion("delivery_status in", values, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusNotIn(List<Integer> values) {
            addCriterion("delivery_status not in", values, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusBetween(Integer value1, Integer value2) {
            addCriterion("delivery_status between", value1, value2, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_status not between", value1, value2, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andAddressDetailIsNull() {
            addCriterion("address_detail is null");
            return (Criteria) this;
        }

        public Criteria andAddressDetailIsNotNull() {
            addCriterion("address_detail is not null");
            return (Criteria) this;
        }

        public Criteria andAddressDetailEqualTo(String value) {
            addCriterion("address_detail =", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailNotEqualTo(String value) {
            addCriterion("address_detail <>", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailGreaterThan(String value) {
            addCriterion("address_detail >", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailGreaterThanOrEqualTo(String value) {
            addCriterion("address_detail >=", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailLessThan(String value) {
            addCriterion("address_detail <", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailLessThanOrEqualTo(String value) {
            addCriterion("address_detail <=", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailLike(String value) {
            addCriterion("address_detail like", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailNotLike(String value) {
            addCriterion("address_detail not like", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailIn(List<String> values) {
            addCriterion("address_detail in", values, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailNotIn(List<String> values) {
            addCriterion("address_detail not in", values, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailBetween(String value1, String value2) {
            addCriterion("address_detail between", value1, value2, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailNotBetween(String value1, String value2) {
            addCriterion("address_detail not between", value1, value2, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameIsNull() {
            addCriterion("linkman_name is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameIsNotNull() {
            addCriterion("linkman_name is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameEqualTo(String value) {
            addCriterion("linkman_name =", value, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameNotEqualTo(String value) {
            addCriterion("linkman_name <>", value, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameGreaterThan(String value) {
            addCriterion("linkman_name >", value, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameGreaterThanOrEqualTo(String value) {
            addCriterion("linkman_name >=", value, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameLessThan(String value) {
            addCriterion("linkman_name <", value, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameLessThanOrEqualTo(String value) {
            addCriterion("linkman_name <=", value, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameLike(String value) {
            addCriterion("linkman_name like", value, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameNotLike(String value) {
            addCriterion("linkman_name not like", value, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameIn(List<String> values) {
            addCriterion("linkman_name in", values, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameNotIn(List<String> values) {
            addCriterion("linkman_name not in", values, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameBetween(String value1, String value2) {
            addCriterion("linkman_name between", value1, value2, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanNameNotBetween(String value1, String value2) {
            addCriterion("linkman_name not between", value1, value2, "linkmanName");
            return (Criteria) this;
        }

        public Criteria andLinkmanQqIsNull() {
            addCriterion("linkman_qq is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanQqIsNotNull() {
            addCriterion("linkman_qq is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanQqEqualTo(String value) {
            addCriterion("linkman_qq =", value, "linkmanQq");
            return (Criteria) this;
        }

        public Criteria andLinkmanQqNotEqualTo(String value) {
            addCriterion("linkman_qq <>", value, "linkmanQq");
            return (Criteria) this;
        }

        public Criteria andLinkmanQqGreaterThan(String value) {
            addCriterion("linkman_qq >", value, "linkmanQq");
            return (Criteria) this;
        }

        public Criteria andLinkmanQqGreaterThanOrEqualTo(String value) {
            addCriterion("linkman_qq >=", value, "linkmanQq");
            return (Criteria) this;
        }

        public Criteria andLinkmanQqLessThan(String value) {
            addCriterion("linkman_qq <", value, "linkmanQq");
            return (Criteria) this;
        }

        public Criteria andLinkmanQqLessThanOrEqualTo(String value) {
            addCriterion("linkman_qq <=", value, "linkmanQq");
            return (Criteria) this;
        }

        public Criteria andLinkmanQqLike(String value) {
            addCriterion("linkman_qq like", value, "linkmanQq");
            return (Criteria) this;
        }

        public Criteria andLinkmanQqNotLike(String value) {
            addCriterion("linkman_qq not like", value, "linkmanQq");
            return (Criteria) this;
        }

        public Criteria andLinkmanQqIn(List<String> values) {
            addCriterion("linkman_qq in", values, "linkmanQq");
            return (Criteria) this;
        }

        public Criteria andLinkmanQqNotIn(List<String> values) {
            addCriterion("linkman_qq not in", values, "linkmanQq");
            return (Criteria) this;
        }

        public Criteria andLinkmanQqBetween(String value1, String value2) {
            addCriterion("linkman_qq between", value1, value2, "linkmanQq");
            return (Criteria) this;
        }

        public Criteria andLinkmanQqNotBetween(String value1, String value2) {
            addCriterion("linkman_qq not between", value1, value2, "linkmanQq");
            return (Criteria) this;
        }

        public Criteria andLinkmanMobileIsNull() {
            addCriterion("linkman_mobile is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanMobileIsNotNull() {
            addCriterion("linkman_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanMobileEqualTo(String value) {
            addCriterion("linkman_mobile =", value, "linkmanMobile");
            return (Criteria) this;
        }

        public Criteria andLinkmanMobileNotEqualTo(String value) {
            addCriterion("linkman_mobile <>", value, "linkmanMobile");
            return (Criteria) this;
        }

        public Criteria andLinkmanMobileGreaterThan(String value) {
            addCriterion("linkman_mobile >", value, "linkmanMobile");
            return (Criteria) this;
        }

        public Criteria andLinkmanMobileGreaterThanOrEqualTo(String value) {
            addCriterion("linkman_mobile >=", value, "linkmanMobile");
            return (Criteria) this;
        }

        public Criteria andLinkmanMobileLessThan(String value) {
            addCriterion("linkman_mobile <", value, "linkmanMobile");
            return (Criteria) this;
        }

        public Criteria andLinkmanMobileLessThanOrEqualTo(String value) {
            addCriterion("linkman_mobile <=", value, "linkmanMobile");
            return (Criteria) this;
        }

        public Criteria andLinkmanMobileLike(String value) {
            addCriterion("linkman_mobile like", value, "linkmanMobile");
            return (Criteria) this;
        }

        public Criteria andLinkmanMobileNotLike(String value) {
            addCriterion("linkman_mobile not like", value, "linkmanMobile");
            return (Criteria) this;
        }

        public Criteria andLinkmanMobileIn(List<String> values) {
            addCriterion("linkman_mobile in", values, "linkmanMobile");
            return (Criteria) this;
        }

        public Criteria andLinkmanMobileNotIn(List<String> values) {
            addCriterion("linkman_mobile not in", values, "linkmanMobile");
            return (Criteria) this;
        }

        public Criteria andLinkmanMobileBetween(String value1, String value2) {
            addCriterion("linkman_mobile between", value1, value2, "linkmanMobile");
            return (Criteria) this;
        }

        public Criteria andLinkmanMobileNotBetween(String value1, String value2) {
            addCriterion("linkman_mobile not between", value1, value2, "linkmanMobile");
            return (Criteria) this;
        }

        public Criteria andLinkmanEmailIsNull() {
            addCriterion("linkman_email is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEmailIsNotNull() {
            addCriterion("linkman_email is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEmailEqualTo(String value) {
            addCriterion("linkman_email =", value, "linkmanEmail");
            return (Criteria) this;
        }

        public Criteria andLinkmanEmailNotEqualTo(String value) {
            addCriterion("linkman_email <>", value, "linkmanEmail");
            return (Criteria) this;
        }

        public Criteria andLinkmanEmailGreaterThan(String value) {
            addCriterion("linkman_email >", value, "linkmanEmail");
            return (Criteria) this;
        }

        public Criteria andLinkmanEmailGreaterThanOrEqualTo(String value) {
            addCriterion("linkman_email >=", value, "linkmanEmail");
            return (Criteria) this;
        }

        public Criteria andLinkmanEmailLessThan(String value) {
            addCriterion("linkman_email <", value, "linkmanEmail");
            return (Criteria) this;
        }

        public Criteria andLinkmanEmailLessThanOrEqualTo(String value) {
            addCriterion("linkman_email <=", value, "linkmanEmail");
            return (Criteria) this;
        }

        public Criteria andLinkmanEmailLike(String value) {
            addCriterion("linkman_email like", value, "linkmanEmail");
            return (Criteria) this;
        }

        public Criteria andLinkmanEmailNotLike(String value) {
            addCriterion("linkman_email not like", value, "linkmanEmail");
            return (Criteria) this;
        }

        public Criteria andLinkmanEmailIn(List<String> values) {
            addCriterion("linkman_email in", values, "linkmanEmail");
            return (Criteria) this;
        }

        public Criteria andLinkmanEmailNotIn(List<String> values) {
            addCriterion("linkman_email not in", values, "linkmanEmail");
            return (Criteria) this;
        }

        public Criteria andLinkmanEmailBetween(String value1, String value2) {
            addCriterion("linkman_email between", value1, value2, "linkmanEmail");
            return (Criteria) this;
        }

        public Criteria andLinkmanEmailNotBetween(String value1, String value2) {
            addCriterion("linkman_email not between", value1, value2, "linkmanEmail");
            return (Criteria) this;
        }

        public Criteria andLicenseIsNull() {
            addCriterion("license is null");
            return (Criteria) this;
        }

        public Criteria andLicenseIsNotNull() {
            addCriterion("license is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseEqualTo(String value) {
            addCriterion("license =", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseNotEqualTo(String value) {
            addCriterion("license <>", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseGreaterThan(String value) {
            addCriterion("license >", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("license >=", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseLessThan(String value) {
            addCriterion("license <", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseLessThanOrEqualTo(String value) {
            addCriterion("license <=", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseLike(String value) {
            addCriterion("license like", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseNotLike(String value) {
            addCriterion("license not like", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseIn(List<String> values) {
            addCriterion("license in", values, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseNotIn(List<String> values) {
            addCriterion("license not in", values, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseBetween(String value1, String value2) {
            addCriterion("license between", value1, value2, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseNotBetween(String value1, String value2) {
            addCriterion("license not between", value1, value2, "license");
            return (Criteria) this;
        }

        public Criteria andPapersIsNull() {
            addCriterion("papers is null");
            return (Criteria) this;
        }

        public Criteria andPapersIsNotNull() {
            addCriterion("papers is not null");
            return (Criteria) this;
        }

        public Criteria andPapersEqualTo(String value) {
            addCriterion("papers =", value, "papers");
            return (Criteria) this;
        }

        public Criteria andPapersNotEqualTo(String value) {
            addCriterion("papers <>", value, "papers");
            return (Criteria) this;
        }

        public Criteria andPapersGreaterThan(String value) {
            addCriterion("papers >", value, "papers");
            return (Criteria) this;
        }

        public Criteria andPapersGreaterThanOrEqualTo(String value) {
            addCriterion("papers >=", value, "papers");
            return (Criteria) this;
        }

        public Criteria andPapersLessThan(String value) {
            addCriterion("papers <", value, "papers");
            return (Criteria) this;
        }

        public Criteria andPapersLessThanOrEqualTo(String value) {
            addCriterion("papers <=", value, "papers");
            return (Criteria) this;
        }

        public Criteria andPapersLike(String value) {
            addCriterion("papers like", value, "papers");
            return (Criteria) this;
        }

        public Criteria andPapersNotLike(String value) {
            addCriterion("papers not like", value, "papers");
            return (Criteria) this;
        }

        public Criteria andPapersIn(List<String> values) {
            addCriterion("papers in", values, "papers");
            return (Criteria) this;
        }

        public Criteria andPapersNotIn(List<String> values) {
            addCriterion("papers not in", values, "papers");
            return (Criteria) this;
        }

        public Criteria andPapersBetween(String value1, String value2) {
            addCriterion("papers between", value1, value2, "papers");
            return (Criteria) this;
        }

        public Criteria andPapersNotBetween(String value1, String value2) {
            addCriterion("papers not between", value1, value2, "papers");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(Long value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(Long value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(Long value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(Long value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(Long value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(Long value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<Long> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<Long> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(Long value1, Long value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(Long value1, Long value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andLogoPicIsNull() {
            addCriterion("logo_pic is null");
            return (Criteria) this;
        }

        public Criteria andLogoPicIsNotNull() {
            addCriterion("logo_pic is not null");
            return (Criteria) this;
        }

        public Criteria andLogoPicEqualTo(String value) {
            addCriterion("logo_pic =", value, "logoPic");
            return (Criteria) this;
        }

        public Criteria andLogoPicNotEqualTo(String value) {
            addCriterion("logo_pic <>", value, "logoPic");
            return (Criteria) this;
        }

        public Criteria andLogoPicGreaterThan(String value) {
            addCriterion("logo_pic >", value, "logoPic");
            return (Criteria) this;
        }

        public Criteria andLogoPicGreaterThanOrEqualTo(String value) {
            addCriterion("logo_pic >=", value, "logoPic");
            return (Criteria) this;
        }

        public Criteria andLogoPicLessThan(String value) {
            addCriterion("logo_pic <", value, "logoPic");
            return (Criteria) this;
        }

        public Criteria andLogoPicLessThanOrEqualTo(String value) {
            addCriterion("logo_pic <=", value, "logoPic");
            return (Criteria) this;
        }

        public Criteria andLogoPicLike(String value) {
            addCriterion("logo_pic like", value, "logoPic");
            return (Criteria) this;
        }

        public Criteria andLogoPicNotLike(String value) {
            addCriterion("logo_pic not like", value, "logoPic");
            return (Criteria) this;
        }

        public Criteria andLogoPicIn(List<String> values) {
            addCriterion("logo_pic in", values, "logoPic");
            return (Criteria) this;
        }

        public Criteria andLogoPicNotIn(List<String> values) {
            addCriterion("logo_pic not in", values, "logoPic");
            return (Criteria) this;
        }

        public Criteria andLogoPicBetween(String value1, String value2) {
            addCriterion("logo_pic between", value1, value2, "logoPic");
            return (Criteria) this;
        }

        public Criteria andLogoPicNotBetween(String value1, String value2) {
            addCriterion("logo_pic not between", value1, value2, "logoPic");
            return (Criteria) this;
        }

        public Criteria andBriefIsNull() {
            addCriterion("brief is null");
            return (Criteria) this;
        }

        public Criteria andBriefIsNotNull() {
            addCriterion("brief is not null");
            return (Criteria) this;
        }

        public Criteria andBriefEqualTo(String value) {
            addCriterion("brief =", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotEqualTo(String value) {
            addCriterion("brief <>", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThan(String value) {
            addCriterion("brief >", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThanOrEqualTo(String value) {
            addCriterion("brief >=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThan(String value) {
            addCriterion("brief <", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThanOrEqualTo(String value) {
            addCriterion("brief <=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLike(String value) {
            addCriterion("brief like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotLike(String value) {
            addCriterion("brief not like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefIn(List<String> values) {
            addCriterion("brief in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotIn(List<String> values) {
            addCriterion("brief not in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefBetween(String value1, String value2) {
            addCriterion("brief between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotBetween(String value1, String value2) {
            addCriterion("brief not between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNull() {
            addCriterion("legal_person is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNotNull() {
            addCriterion("legal_person is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonEqualTo(String value) {
            addCriterion("legal_person =", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotEqualTo(String value) {
            addCriterion("legal_person <>", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThan(String value) {
            addCriterion("legal_person >", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person >=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThan(String value) {
            addCriterion("legal_person <", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThanOrEqualTo(String value) {
            addCriterion("legal_person <=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLike(String value) {
            addCriterion("legal_person like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotLike(String value) {
            addCriterion("legal_person not like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIn(List<String> values) {
            addCriterion("legal_person in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotIn(List<String> values) {
            addCriterion("legal_person not in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonBetween(String value1, String value2) {
            addCriterion("legal_person between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotBetween(String value1, String value2) {
            addCriterion("legal_person not between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardIdIsNull() {
            addCriterion("legal_person_card_id is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardIdIsNotNull() {
            addCriterion("legal_person_card_id is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardIdEqualTo(String value) {
            addCriterion("legal_person_card_id =", value, "legalPersonCardId");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardIdNotEqualTo(String value) {
            addCriterion("legal_person_card_id <>", value, "legalPersonCardId");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardIdGreaterThan(String value) {
            addCriterion("legal_person_card_id >", value, "legalPersonCardId");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person_card_id >=", value, "legalPersonCardId");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardIdLessThan(String value) {
            addCriterion("legal_person_card_id <", value, "legalPersonCardId");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardIdLessThanOrEqualTo(String value) {
            addCriterion("legal_person_card_id <=", value, "legalPersonCardId");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardIdLike(String value) {
            addCriterion("legal_person_card_id like", value, "legalPersonCardId");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardIdNotLike(String value) {
            addCriterion("legal_person_card_id not like", value, "legalPersonCardId");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardIdIn(List<String> values) {
            addCriterion("legal_person_card_id in", values, "legalPersonCardId");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardIdNotIn(List<String> values) {
            addCriterion("legal_person_card_id not in", values, "legalPersonCardId");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardIdBetween(String value1, String value2) {
            addCriterion("legal_person_card_id between", value1, value2, "legalPersonCardId");
            return (Criteria) this;
        }

        public Criteria andLegalPersonCardIdNotBetween(String value1, String value2) {
            addCriterion("legal_person_card_id not between", value1, value2, "legalPersonCardId");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPicIsNull() {
            addCriterion("legal_person_pic is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPicIsNotNull() {
            addCriterion("legal_person_pic is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPicEqualTo(String value) {
            addCriterion("legal_person_pic =", value, "legalPersonPic");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPicNotEqualTo(String value) {
            addCriterion("legal_person_pic <>", value, "legalPersonPic");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPicGreaterThan(String value) {
            addCriterion("legal_person_pic >", value, "legalPersonPic");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPicGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person_pic >=", value, "legalPersonPic");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPicLessThan(String value) {
            addCriterion("legal_person_pic <", value, "legalPersonPic");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPicLessThanOrEqualTo(String value) {
            addCriterion("legal_person_pic <=", value, "legalPersonPic");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPicLike(String value) {
            addCriterion("legal_person_pic like", value, "legalPersonPic");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPicNotLike(String value) {
            addCriterion("legal_person_pic not like", value, "legalPersonPic");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPicIn(List<String> values) {
            addCriterion("legal_person_pic in", values, "legalPersonPic");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPicNotIn(List<String> values) {
            addCriterion("legal_person_pic not in", values, "legalPersonPic");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPicBetween(String value1, String value2) {
            addCriterion("legal_person_pic between", value1, value2, "legalPersonPic");
            return (Criteria) this;
        }

        public Criteria andLegalPersonPicNotBetween(String value1, String value2) {
            addCriterion("legal_person_pic not between", value1, value2, "legalPersonPic");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankUserIsNull() {
            addCriterion("bank_user is null");
            return (Criteria) this;
        }

        public Criteria andBankUserIsNotNull() {
            addCriterion("bank_user is not null");
            return (Criteria) this;
        }

        public Criteria andBankUserEqualTo(String value) {
            addCriterion("bank_user =", value, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserNotEqualTo(String value) {
            addCriterion("bank_user <>", value, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserGreaterThan(String value) {
            addCriterion("bank_user >", value, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserGreaterThanOrEqualTo(String value) {
            addCriterion("bank_user >=", value, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserLessThan(String value) {
            addCriterion("bank_user <", value, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserLessThanOrEqualTo(String value) {
            addCriterion("bank_user <=", value, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserLike(String value) {
            addCriterion("bank_user like", value, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserNotLike(String value) {
            addCriterion("bank_user not like", value, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserIn(List<String> values) {
            addCriterion("bank_user in", values, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserNotIn(List<String> values) {
            addCriterion("bank_user not in", values, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserBetween(String value1, String value2) {
            addCriterion("bank_user between", value1, value2, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserNotBetween(String value1, String value2) {
            addCriterion("bank_user not between", value1, value2, "bankUser");
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