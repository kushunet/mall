package cn.dnaizn.mall.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DeliveryOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeliveryOrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdIsNull() {
            addCriterion("delivery_id is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdIsNotNull() {
            addCriterion("delivery_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdEqualTo(String value) {
            addCriterion("delivery_id =", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdNotEqualTo(String value) {
            addCriterion("delivery_id <>", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdGreaterThan(String value) {
            addCriterion("delivery_id >", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_id >=", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdLessThan(String value) {
            addCriterion("delivery_id <", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdLessThanOrEqualTo(String value) {
            addCriterion("delivery_id <=", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdLike(String value) {
            addCriterion("delivery_id like", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdNotLike(String value) {
            addCriterion("delivery_id not like", value, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdIn(List<String> values) {
            addCriterion("delivery_id in", values, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdNotIn(List<String> values) {
            addCriterion("delivery_id not in", values, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdBetween(String value1, String value2) {
            addCriterion("delivery_id between", value1, value2, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andDeliveryIdNotBetween(String value1, String value2) {
            addCriterion("delivery_id not between", value1, value2, "deliveryId");
            return (Criteria) this;
        }

        public Criteria andThirdDeliveryIdIsNull() {
            addCriterion("third_delivery_id is null");
            return (Criteria) this;
        }

        public Criteria andThirdDeliveryIdIsNotNull() {
            addCriterion("third_delivery_id is not null");
            return (Criteria) this;
        }

        public Criteria andThirdDeliveryIdEqualTo(String value) {
            addCriterion("third_delivery_id =", value, "thirdDeliveryId");
            return (Criteria) this;
        }

        public Criteria andThirdDeliveryIdNotEqualTo(String value) {
            addCriterion("third_delivery_id <>", value, "thirdDeliveryId");
            return (Criteria) this;
        }

        public Criteria andThirdDeliveryIdGreaterThan(String value) {
            addCriterion("third_delivery_id >", value, "thirdDeliveryId");
            return (Criteria) this;
        }

        public Criteria andThirdDeliveryIdGreaterThanOrEqualTo(String value) {
            addCriterion("third_delivery_id >=", value, "thirdDeliveryId");
            return (Criteria) this;
        }

        public Criteria andThirdDeliveryIdLessThan(String value) {
            addCriterion("third_delivery_id <", value, "thirdDeliveryId");
            return (Criteria) this;
        }

        public Criteria andThirdDeliveryIdLessThanOrEqualTo(String value) {
            addCriterion("third_delivery_id <=", value, "thirdDeliveryId");
            return (Criteria) this;
        }

        public Criteria andThirdDeliveryIdLike(String value) {
            addCriterion("third_delivery_id like", value, "thirdDeliveryId");
            return (Criteria) this;
        }

        public Criteria andThirdDeliveryIdNotLike(String value) {
            addCriterion("third_delivery_id not like", value, "thirdDeliveryId");
            return (Criteria) this;
        }

        public Criteria andThirdDeliveryIdIn(List<String> values) {
            addCriterion("third_delivery_id in", values, "thirdDeliveryId");
            return (Criteria) this;
        }

        public Criteria andThirdDeliveryIdNotIn(List<String> values) {
            addCriterion("third_delivery_id not in", values, "thirdDeliveryId");
            return (Criteria) this;
        }

        public Criteria andThirdDeliveryIdBetween(String value1, String value2) {
            addCriterion("third_delivery_id between", value1, value2, "thirdDeliveryId");
            return (Criteria) this;
        }

        public Criteria andThirdDeliveryIdNotBetween(String value1, String value2) {
            addCriterion("third_delivery_id not between", value1, value2, "thirdDeliveryId");
            return (Criteria) this;
        }

        public Criteria andAdcodeIsNull() {
            addCriterion("adcode is null");
            return (Criteria) this;
        }

        public Criteria andAdcodeIsNotNull() {
            addCriterion("adcode is not null");
            return (Criteria) this;
        }

        public Criteria andAdcodeEqualTo(Integer value) {
            addCriterion("adcode =", value, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeNotEqualTo(Integer value) {
            addCriterion("adcode <>", value, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeGreaterThan(Integer value) {
            addCriterion("adcode >", value, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("adcode >=", value, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeLessThan(Integer value) {
            addCriterion("adcode <", value, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeLessThanOrEqualTo(Integer value) {
            addCriterion("adcode <=", value, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeIn(List<Integer> values) {
            addCriterion("adcode in", values, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeNotIn(List<Integer> values) {
            addCriterion("adcode not in", values, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeBetween(Integer value1, Integer value2) {
            addCriterion("adcode between", value1, value2, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("adcode not between", value1, value2, "adcode");
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

        public Criteria andCityNameIsNull() {
            addCriterion("city_name is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("city_name is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("city_name =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("city_name <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("city_name >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("city_name >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("city_name <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("city_name <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("city_name like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("city_name not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("city_name in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("city_name not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("city_name between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("city_name not between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andStartAddressIsNull() {
            addCriterion("start_address is null");
            return (Criteria) this;
        }

        public Criteria andStartAddressIsNotNull() {
            addCriterion("start_address is not null");
            return (Criteria) this;
        }

        public Criteria andStartAddressEqualTo(String value) {
            addCriterion("start_address =", value, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressNotEqualTo(String value) {
            addCriterion("start_address <>", value, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressGreaterThan(String value) {
            addCriterion("start_address >", value, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressGreaterThanOrEqualTo(String value) {
            addCriterion("start_address >=", value, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressLessThan(String value) {
            addCriterion("start_address <", value, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressLessThanOrEqualTo(String value) {
            addCriterion("start_address <=", value, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressLike(String value) {
            addCriterion("start_address like", value, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressNotLike(String value) {
            addCriterion("start_address not like", value, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressIn(List<String> values) {
            addCriterion("start_address in", values, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressNotIn(List<String> values) {
            addCriterion("start_address not in", values, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressBetween(String value1, String value2) {
            addCriterion("start_address between", value1, value2, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartAddressNotBetween(String value1, String value2) {
            addCriterion("start_address not between", value1, value2, "startAddress");
            return (Criteria) this;
        }

        public Criteria andStartPointIsNull() {
            addCriterion("start_point is null");
            return (Criteria) this;
        }

        public Criteria andStartPointIsNotNull() {
            addCriterion("start_point is not null");
            return (Criteria) this;
        }

        public Criteria andStartPointEqualTo(String value) {
            addCriterion("start_point =", value, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointNotEqualTo(String value) {
            addCriterion("start_point <>", value, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointGreaterThan(String value) {
            addCriterion("start_point >", value, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointGreaterThanOrEqualTo(String value) {
            addCriterion("start_point >=", value, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointLessThan(String value) {
            addCriterion("start_point <", value, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointLessThanOrEqualTo(String value) {
            addCriterion("start_point <=", value, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointLike(String value) {
            addCriterion("start_point like", value, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointNotLike(String value) {
            addCriterion("start_point not like", value, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointIn(List<String> values) {
            addCriterion("start_point in", values, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointNotIn(List<String> values) {
            addCriterion("start_point not in", values, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointBetween(String value1, String value2) {
            addCriterion("start_point between", value1, value2, "startPoint");
            return (Criteria) this;
        }

        public Criteria andStartPointNotBetween(String value1, String value2) {
            addCriterion("start_point not between", value1, value2, "startPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduStartPointIsNull() {
            addCriterion("baidu_start_point is null");
            return (Criteria) this;
        }

        public Criteria andBaiduStartPointIsNotNull() {
            addCriterion("baidu_start_point is not null");
            return (Criteria) this;
        }

        public Criteria andBaiduStartPointEqualTo(String value) {
            addCriterion("baidu_start_point =", value, "baiduStartPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduStartPointNotEqualTo(String value) {
            addCriterion("baidu_start_point <>", value, "baiduStartPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduStartPointGreaterThan(String value) {
            addCriterion("baidu_start_point >", value, "baiduStartPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduStartPointGreaterThanOrEqualTo(String value) {
            addCriterion("baidu_start_point >=", value, "baiduStartPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduStartPointLessThan(String value) {
            addCriterion("baidu_start_point <", value, "baiduStartPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduStartPointLessThanOrEqualTo(String value) {
            addCriterion("baidu_start_point <=", value, "baiduStartPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduStartPointLike(String value) {
            addCriterion("baidu_start_point like", value, "baiduStartPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduStartPointNotLike(String value) {
            addCriterion("baidu_start_point not like", value, "baiduStartPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduStartPointIn(List<String> values) {
            addCriterion("baidu_start_point in", values, "baiduStartPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduStartPointNotIn(List<String> values) {
            addCriterion("baidu_start_point not in", values, "baiduStartPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduStartPointBetween(String value1, String value2) {
            addCriterion("baidu_start_point between", value1, value2, "baiduStartPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduStartPointNotBetween(String value1, String value2) {
            addCriterion("baidu_start_point not between", value1, value2, "baiduStartPoint");
            return (Criteria) this;
        }

        public Criteria andEndAddressIsNull() {
            addCriterion("end_address is null");
            return (Criteria) this;
        }

        public Criteria andEndAddressIsNotNull() {
            addCriterion("end_address is not null");
            return (Criteria) this;
        }

        public Criteria andEndAddressEqualTo(String value) {
            addCriterion("end_address =", value, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressNotEqualTo(String value) {
            addCriterion("end_address <>", value, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressGreaterThan(String value) {
            addCriterion("end_address >", value, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressGreaterThanOrEqualTo(String value) {
            addCriterion("end_address >=", value, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressLessThan(String value) {
            addCriterion("end_address <", value, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressLessThanOrEqualTo(String value) {
            addCriterion("end_address <=", value, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressLike(String value) {
            addCriterion("end_address like", value, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressNotLike(String value) {
            addCriterion("end_address not like", value, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressIn(List<String> values) {
            addCriterion("end_address in", values, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressNotIn(List<String> values) {
            addCriterion("end_address not in", values, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressBetween(String value1, String value2) {
            addCriterion("end_address between", value1, value2, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndAddressNotBetween(String value1, String value2) {
            addCriterion("end_address not between", value1, value2, "endAddress");
            return (Criteria) this;
        }

        public Criteria andEndPointIsNull() {
            addCriterion("end_point is null");
            return (Criteria) this;
        }

        public Criteria andEndPointIsNotNull() {
            addCriterion("end_point is not null");
            return (Criteria) this;
        }

        public Criteria andEndPointEqualTo(String value) {
            addCriterion("end_point =", value, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointNotEqualTo(String value) {
            addCriterion("end_point <>", value, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointGreaterThan(String value) {
            addCriterion("end_point >", value, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointGreaterThanOrEqualTo(String value) {
            addCriterion("end_point >=", value, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointLessThan(String value) {
            addCriterion("end_point <", value, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointLessThanOrEqualTo(String value) {
            addCriterion("end_point <=", value, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointLike(String value) {
            addCriterion("end_point like", value, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointNotLike(String value) {
            addCriterion("end_point not like", value, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointIn(List<String> values) {
            addCriterion("end_point in", values, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointNotIn(List<String> values) {
            addCriterion("end_point not in", values, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointBetween(String value1, String value2) {
            addCriterion("end_point between", value1, value2, "endPoint");
            return (Criteria) this;
        }

        public Criteria andEndPointNotBetween(String value1, String value2) {
            addCriterion("end_point not between", value1, value2, "endPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduEndPointIsNull() {
            addCriterion("baidu_end_point is null");
            return (Criteria) this;
        }

        public Criteria andBaiduEndPointIsNotNull() {
            addCriterion("baidu_end_point is not null");
            return (Criteria) this;
        }

        public Criteria andBaiduEndPointEqualTo(String value) {
            addCriterion("baidu_end_point =", value, "baiduEndPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduEndPointNotEqualTo(String value) {
            addCriterion("baidu_end_point <>", value, "baiduEndPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduEndPointGreaterThan(String value) {
            addCriterion("baidu_end_point >", value, "baiduEndPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduEndPointGreaterThanOrEqualTo(String value) {
            addCriterion("baidu_end_point >=", value, "baiduEndPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduEndPointLessThan(String value) {
            addCriterion("baidu_end_point <", value, "baiduEndPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduEndPointLessThanOrEqualTo(String value) {
            addCriterion("baidu_end_point <=", value, "baiduEndPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduEndPointLike(String value) {
            addCriterion("baidu_end_point like", value, "baiduEndPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduEndPointNotLike(String value) {
            addCriterion("baidu_end_point not like", value, "baiduEndPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduEndPointIn(List<String> values) {
            addCriterion("baidu_end_point in", values, "baiduEndPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduEndPointNotIn(List<String> values) {
            addCriterion("baidu_end_point not in", values, "baiduEndPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduEndPointBetween(String value1, String value2) {
            addCriterion("baidu_end_point between", value1, value2, "baiduEndPoint");
            return (Criteria) this;
        }

        public Criteria andBaiduEndPointNotBetween(String value1, String value2) {
            addCriterion("baidu_end_point not between", value1, value2, "baiduEndPoint");
            return (Criteria) this;
        }

        public Criteria andSellerNameIsNull() {
            addCriterion("seller_name is null");
            return (Criteria) this;
        }

        public Criteria andSellerNameIsNotNull() {
            addCriterion("seller_name is not null");
            return (Criteria) this;
        }

        public Criteria andSellerNameEqualTo(String value) {
            addCriterion("seller_name =", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameNotEqualTo(String value) {
            addCriterion("seller_name <>", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameGreaterThan(String value) {
            addCriterion("seller_name >", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameGreaterThanOrEqualTo(String value) {
            addCriterion("seller_name >=", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameLessThan(String value) {
            addCriterion("seller_name <", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameLessThanOrEqualTo(String value) {
            addCriterion("seller_name <=", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameLike(String value) {
            addCriterion("seller_name like", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameNotLike(String value) {
            addCriterion("seller_name not like", value, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameIn(List<String> values) {
            addCriterion("seller_name in", values, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameNotIn(List<String> values) {
            addCriterion("seller_name not in", values, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameBetween(String value1, String value2) {
            addCriterion("seller_name between", value1, value2, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerNameNotBetween(String value1, String value2) {
            addCriterion("seller_name not between", value1, value2, "sellerName");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneIsNull() {
            addCriterion("seller_phone is null");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneIsNotNull() {
            addCriterion("seller_phone is not null");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneEqualTo(String value) {
            addCriterion("seller_phone =", value, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneNotEqualTo(String value) {
            addCriterion("seller_phone <>", value, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneGreaterThan(String value) {
            addCriterion("seller_phone >", value, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("seller_phone >=", value, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneLessThan(String value) {
            addCriterion("seller_phone <", value, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneLessThanOrEqualTo(String value) {
            addCriterion("seller_phone <=", value, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneLike(String value) {
            addCriterion("seller_phone like", value, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneNotLike(String value) {
            addCriterion("seller_phone not like", value, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneIn(List<String> values) {
            addCriterion("seller_phone in", values, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneNotIn(List<String> values) {
            addCriterion("seller_phone not in", values, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneBetween(String value1, String value2) {
            addCriterion("seller_phone between", value1, value2, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andSellerPhoneNotBetween(String value1, String value2) {
            addCriterion("seller_phone not between", value1, value2, "sellerPhone");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andDeliverInfoIsNull() {
            addCriterion("deliver_info is null");
            return (Criteria) this;
        }

        public Criteria andDeliverInfoIsNotNull() {
            addCriterion("deliver_info is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverInfoEqualTo(Object value) {
            addCriterion("deliver_info =", value, "deliverInfo");
            return (Criteria) this;
        }

        public Criteria andDeliverInfoNotEqualTo(Object value) {
            addCriterion("deliver_info <>", value, "deliverInfo");
            return (Criteria) this;
        }

        public Criteria andDeliverInfoGreaterThan(Object value) {
            addCriterion("deliver_info >", value, "deliverInfo");
            return (Criteria) this;
        }

        public Criteria andDeliverInfoGreaterThanOrEqualTo(Object value) {
            addCriterion("deliver_info >=", value, "deliverInfo");
            return (Criteria) this;
        }

        public Criteria andDeliverInfoLessThan(Object value) {
            addCriterion("deliver_info <", value, "deliverInfo");
            return (Criteria) this;
        }

        public Criteria andDeliverInfoLessThanOrEqualTo(Object value) {
            addCriterion("deliver_info <=", value, "deliverInfo");
            return (Criteria) this;
        }

        public Criteria andDeliverInfoIn(List<Object> values) {
            addCriterion("deliver_info in", values, "deliverInfo");
            return (Criteria) this;
        }

        public Criteria andDeliverInfoNotIn(List<Object> values) {
            addCriterion("deliver_info not in", values, "deliverInfo");
            return (Criteria) this;
        }

        public Criteria andDeliverInfoBetween(Object value1, Object value2) {
            addCriterion("deliver_info between", value1, value2, "deliverInfo");
            return (Criteria) this;
        }

        public Criteria andDeliverInfoNotBetween(Object value1, Object value2) {
            addCriterion("deliver_info not between", value1, value2, "deliverInfo");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andDeliverFeeIsNull() {
            addCriterion("deliver_fee is null");
            return (Criteria) this;
        }

        public Criteria andDeliverFeeIsNotNull() {
            addCriterion("deliver_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverFeeEqualTo(BigDecimal value) {
            addCriterion("deliver_fee =", value, "deliverFee");
            return (Criteria) this;
        }

        public Criteria andDeliverFeeNotEqualTo(BigDecimal value) {
            addCriterion("deliver_fee <>", value, "deliverFee");
            return (Criteria) this;
        }

        public Criteria andDeliverFeeGreaterThan(BigDecimal value) {
            addCriterion("deliver_fee >", value, "deliverFee");
            return (Criteria) this;
        }

        public Criteria andDeliverFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deliver_fee >=", value, "deliverFee");
            return (Criteria) this;
        }

        public Criteria andDeliverFeeLessThan(BigDecimal value) {
            addCriterion("deliver_fee <", value, "deliverFee");
            return (Criteria) this;
        }

        public Criteria andDeliverFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deliver_fee <=", value, "deliverFee");
            return (Criteria) this;
        }

        public Criteria andDeliverFeeIn(List<BigDecimal> values) {
            addCriterion("deliver_fee in", values, "deliverFee");
            return (Criteria) this;
        }

        public Criteria andDeliverFeeNotIn(List<BigDecimal> values) {
            addCriterion("deliver_fee not in", values, "deliverFee");
            return (Criteria) this;
        }

        public Criteria andDeliverFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deliver_fee between", value1, value2, "deliverFee");
            return (Criteria) this;
        }

        public Criteria andDeliverFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deliver_fee not between", value1, value2, "deliverFee");
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