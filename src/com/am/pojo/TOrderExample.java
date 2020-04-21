package com.am.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOrderExample() {
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

        public Criteria andOrderidIsNull() {
            addCriterion("orderId is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Integer value) {
            addCriterion("orderId =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Integer value) {
            addCriterion("orderId <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Integer value) {
            addCriterion("orderId >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderId >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Integer value) {
            addCriterion("orderId <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Integer value) {
            addCriterion("orderId <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Integer> values) {
            addCriterion("orderId in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Integer> values) {
            addCriterion("orderId not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Integer value1, Integer value2) {
            addCriterion("orderId between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderId not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNull() {
            addCriterion("orderNum is null");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNotNull() {
            addCriterion("orderNum is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernumEqualTo(String value) {
            addCriterion("orderNum =", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotEqualTo(String value) {
            addCriterion("orderNum <>", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThan(String value) {
            addCriterion("orderNum >", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThanOrEqualTo(String value) {
            addCriterion("orderNum >=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThan(String value) {
            addCriterion("orderNum <", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThanOrEqualTo(String value) {
            addCriterion("orderNum <=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLike(String value) {
            addCriterion("orderNum like", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotLike(String value) {
            addCriterion("orderNum not like", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumIn(List<String> values) {
            addCriterion("orderNum in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotIn(List<String> values) {
            addCriterion("orderNum not in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumBetween(String value1, String value2) {
            addCriterion("orderNum between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotBetween(String value1, String value2) {
            addCriterion("orderNum not between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrderowerIsNull() {
            addCriterion("orderOwer is null");
            return (Criteria) this;
        }

        public Criteria andOrderowerIsNotNull() {
            addCriterion("orderOwer is not null");
            return (Criteria) this;
        }

        public Criteria andOrderowerEqualTo(String value) {
            addCriterion("orderOwer =", value, "orderower");
            return (Criteria) this;
        }

        public Criteria andOrderowerNotEqualTo(String value) {
            addCriterion("orderOwer <>", value, "orderower");
            return (Criteria) this;
        }

        public Criteria andOrderowerGreaterThan(String value) {
            addCriterion("orderOwer >", value, "orderower");
            return (Criteria) this;
        }

        public Criteria andOrderowerGreaterThanOrEqualTo(String value) {
            addCriterion("orderOwer >=", value, "orderower");
            return (Criteria) this;
        }

        public Criteria andOrderowerLessThan(String value) {
            addCriterion("orderOwer <", value, "orderower");
            return (Criteria) this;
        }

        public Criteria andOrderowerLessThanOrEqualTo(String value) {
            addCriterion("orderOwer <=", value, "orderower");
            return (Criteria) this;
        }

        public Criteria andOrderowerLike(String value) {
            addCriterion("orderOwer like", value, "orderower");
            return (Criteria) this;
        }

        public Criteria andOrderowerNotLike(String value) {
            addCriterion("orderOwer not like", value, "orderower");
            return (Criteria) this;
        }

        public Criteria andOrderowerIn(List<String> values) {
            addCriterion("orderOwer in", values, "orderower");
            return (Criteria) this;
        }

        public Criteria andOrderowerNotIn(List<String> values) {
            addCriterion("orderOwer not in", values, "orderower");
            return (Criteria) this;
        }

        public Criteria andOrderowerBetween(String value1, String value2) {
            addCriterion("orderOwer between", value1, value2, "orderower");
            return (Criteria) this;
        }

        public Criteria andOrderowerNotBetween(String value1, String value2) {
            addCriterion("orderOwer not between", value1, value2, "orderower");
            return (Criteria) this;
        }

        public Criteria andOrerowercontactIsNull() {
            addCriterion("orerOwerContact is null");
            return (Criteria) this;
        }

        public Criteria andOrerowercontactIsNotNull() {
            addCriterion("orerOwerContact is not null");
            return (Criteria) this;
        }

        public Criteria andOrerowercontactEqualTo(String value) {
            addCriterion("orerOwerContact =", value, "orerowercontact");
            return (Criteria) this;
        }

        public Criteria andOrerowercontactNotEqualTo(String value) {
            addCriterion("orerOwerContact <>", value, "orerowercontact");
            return (Criteria) this;
        }

        public Criteria andOrerowercontactGreaterThan(String value) {
            addCriterion("orerOwerContact >", value, "orerowercontact");
            return (Criteria) this;
        }

        public Criteria andOrerowercontactGreaterThanOrEqualTo(String value) {
            addCriterion("orerOwerContact >=", value, "orerowercontact");
            return (Criteria) this;
        }

        public Criteria andOrerowercontactLessThan(String value) {
            addCriterion("orerOwerContact <", value, "orerowercontact");
            return (Criteria) this;
        }

        public Criteria andOrerowercontactLessThanOrEqualTo(String value) {
            addCriterion("orerOwerContact <=", value, "orerowercontact");
            return (Criteria) this;
        }

        public Criteria andOrerowercontactLike(String value) {
            addCriterion("orerOwerContact like", value, "orerowercontact");
            return (Criteria) this;
        }

        public Criteria andOrerowercontactNotLike(String value) {
            addCriterion("orerOwerContact not like", value, "orerowercontact");
            return (Criteria) this;
        }

        public Criteria andOrerowercontactIn(List<String> values) {
            addCriterion("orerOwerContact in", values, "orerowercontact");
            return (Criteria) this;
        }

        public Criteria andOrerowercontactNotIn(List<String> values) {
            addCriterion("orerOwerContact not in", values, "orerowercontact");
            return (Criteria) this;
        }

        public Criteria andOrerowercontactBetween(String value1, String value2) {
            addCriterion("orerOwerContact between", value1, value2, "orerowercontact");
            return (Criteria) this;
        }

        public Criteria andOrerowercontactNotBetween(String value1, String value2) {
            addCriterion("orerOwerContact not between", value1, value2, "orerowercontact");
            return (Criteria) this;
        }

        public Criteria andOrderoweraddressIsNull() {
            addCriterion("orderOwerAddress is null");
            return (Criteria) this;
        }

        public Criteria andOrderoweraddressIsNotNull() {
            addCriterion("orderOwerAddress is not null");
            return (Criteria) this;
        }

        public Criteria andOrderoweraddressEqualTo(String value) {
            addCriterion("orderOwerAddress =", value, "orderoweraddress");
            return (Criteria) this;
        }

        public Criteria andOrderoweraddressNotEqualTo(String value) {
            addCriterion("orderOwerAddress <>", value, "orderoweraddress");
            return (Criteria) this;
        }

        public Criteria andOrderoweraddressGreaterThan(String value) {
            addCriterion("orderOwerAddress >", value, "orderoweraddress");
            return (Criteria) this;
        }

        public Criteria andOrderoweraddressGreaterThanOrEqualTo(String value) {
            addCriterion("orderOwerAddress >=", value, "orderoweraddress");
            return (Criteria) this;
        }

        public Criteria andOrderoweraddressLessThan(String value) {
            addCriterion("orderOwerAddress <", value, "orderoweraddress");
            return (Criteria) this;
        }

        public Criteria andOrderoweraddressLessThanOrEqualTo(String value) {
            addCriterion("orderOwerAddress <=", value, "orderoweraddress");
            return (Criteria) this;
        }

        public Criteria andOrderoweraddressLike(String value) {
            addCriterion("orderOwerAddress like", value, "orderoweraddress");
            return (Criteria) this;
        }

        public Criteria andOrderoweraddressNotLike(String value) {
            addCriterion("orderOwerAddress not like", value, "orderoweraddress");
            return (Criteria) this;
        }

        public Criteria andOrderoweraddressIn(List<String> values) {
            addCriterion("orderOwerAddress in", values, "orderoweraddress");
            return (Criteria) this;
        }

        public Criteria andOrderoweraddressNotIn(List<String> values) {
            addCriterion("orderOwerAddress not in", values, "orderoweraddress");
            return (Criteria) this;
        }

        public Criteria andOrderoweraddressBetween(String value1, String value2) {
            addCriterion("orderOwerAddress between", value1, value2, "orderoweraddress");
            return (Criteria) this;
        }

        public Criteria andOrderoweraddressNotBetween(String value1, String value2) {
            addCriterion("orderOwerAddress not between", value1, value2, "orderoweraddress");
            return (Criteria) this;
        }

        public Criteria andOrderweightIsNull() {
            addCriterion("orderWeight is null");
            return (Criteria) this;
        }

        public Criteria andOrderweightIsNotNull() {
            addCriterion("orderWeight is not null");
            return (Criteria) this;
        }

        public Criteria andOrderweightEqualTo(BigDecimal value) {
            addCriterion("orderWeight =", value, "orderweight");
            return (Criteria) this;
        }

        public Criteria andOrderweightNotEqualTo(BigDecimal value) {
            addCriterion("orderWeight <>", value, "orderweight");
            return (Criteria) this;
        }

        public Criteria andOrderweightGreaterThan(BigDecimal value) {
            addCriterion("orderWeight >", value, "orderweight");
            return (Criteria) this;
        }

        public Criteria andOrderweightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("orderWeight >=", value, "orderweight");
            return (Criteria) this;
        }

        public Criteria andOrderweightLessThan(BigDecimal value) {
            addCriterion("orderWeight <", value, "orderweight");
            return (Criteria) this;
        }

        public Criteria andOrderweightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("orderWeight <=", value, "orderweight");
            return (Criteria) this;
        }

        public Criteria andOrderweightIn(List<BigDecimal> values) {
            addCriterion("orderWeight in", values, "orderweight");
            return (Criteria) this;
        }

        public Criteria andOrderweightNotIn(List<BigDecimal> values) {
            addCriterion("orderWeight not in", values, "orderweight");
            return (Criteria) this;
        }

        public Criteria andOrderweightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("orderWeight between", value1, value2, "orderweight");
            return (Criteria) this;
        }

        public Criteria andOrderweightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("orderWeight not between", value1, value2, "orderweight");
            return (Criteria) this;
        }

        public Criteria andOrdercurrencyIsNull() {
            addCriterion("orderCurrency is null");
            return (Criteria) this;
        }

        public Criteria andOrdercurrencyIsNotNull() {
            addCriterion("orderCurrency is not null");
            return (Criteria) this;
        }

        public Criteria andOrdercurrencyEqualTo(BigDecimal value) {
            addCriterion("orderCurrency =", value, "ordercurrency");
            return (Criteria) this;
        }

        public Criteria andOrdercurrencyNotEqualTo(BigDecimal value) {
            addCriterion("orderCurrency <>", value, "ordercurrency");
            return (Criteria) this;
        }

        public Criteria andOrdercurrencyGreaterThan(BigDecimal value) {
            addCriterion("orderCurrency >", value, "ordercurrency");
            return (Criteria) this;
        }

        public Criteria andOrdercurrencyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("orderCurrency >=", value, "ordercurrency");
            return (Criteria) this;
        }

        public Criteria andOrdercurrencyLessThan(BigDecimal value) {
            addCriterion("orderCurrency <", value, "ordercurrency");
            return (Criteria) this;
        }

        public Criteria andOrdercurrencyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("orderCurrency <=", value, "ordercurrency");
            return (Criteria) this;
        }

        public Criteria andOrdercurrencyIn(List<BigDecimal> values) {
            addCriterion("orderCurrency in", values, "ordercurrency");
            return (Criteria) this;
        }

        public Criteria andOrdercurrencyNotIn(List<BigDecimal> values) {
            addCriterion("orderCurrency not in", values, "ordercurrency");
            return (Criteria) this;
        }

        public Criteria andOrdercurrencyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("orderCurrency between", value1, value2, "ordercurrency");
            return (Criteria) this;
        }

        public Criteria andOrdercurrencyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("orderCurrency not between", value1, value2, "ordercurrency");
            return (Criteria) this;
        }

        public Criteria andOrdercreateIsNull() {
            addCriterion("orderCreate is null");
            return (Criteria) this;
        }

        public Criteria andOrdercreateIsNotNull() {
            addCriterion("orderCreate is not null");
            return (Criteria) this;
        }

        public Criteria andOrdercreateEqualTo(Date value) {
            addCriterion("orderCreate =", value, "ordercreate");
            return (Criteria) this;
        }

        public Criteria andOrdercreateNotEqualTo(Date value) {
            addCriterion("orderCreate <>", value, "ordercreate");
            return (Criteria) this;
        }

        public Criteria andOrdercreateGreaterThan(Date value) {
            addCriterion("orderCreate >", value, "ordercreate");
            return (Criteria) this;
        }

        public Criteria andOrdercreateGreaterThanOrEqualTo(Date value) {
            addCriterion("orderCreate >=", value, "ordercreate");
            return (Criteria) this;
        }

        public Criteria andOrdercreateLessThan(Date value) {
            addCriterion("orderCreate <", value, "ordercreate");
            return (Criteria) this;
        }

        public Criteria andOrdercreateLessThanOrEqualTo(Date value) {
            addCriterion("orderCreate <=", value, "ordercreate");
            return (Criteria) this;
        }

        public Criteria andOrdercreateIn(List<Date> values) {
            addCriterion("orderCreate in", values, "ordercreate");
            return (Criteria) this;
        }

        public Criteria andOrdercreateNotIn(List<Date> values) {
            addCriterion("orderCreate not in", values, "ordercreate");
            return (Criteria) this;
        }

        public Criteria andOrdercreateBetween(Date value1, Date value2) {
            addCriterion("orderCreate between", value1, value2, "ordercreate");
            return (Criteria) this;
        }

        public Criteria andOrdercreateNotBetween(Date value1, Date value2) {
            addCriterion("orderCreate not between", value1, value2, "ordercreate");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNull() {
            addCriterion("orderStatus is null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNotNull() {
            addCriterion("orderStatus is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusEqualTo(String value) {
            addCriterion("orderStatus =", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotEqualTo(String value) {
            addCriterion("orderStatus <>", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThan(String value) {
            addCriterion("orderStatus >", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThanOrEqualTo(String value) {
            addCriterion("orderStatus >=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThan(String value) {
            addCriterion("orderStatus <", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThanOrEqualTo(String value) {
            addCriterion("orderStatus <=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLike(String value) {
            addCriterion("orderStatus like", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotLike(String value) {
            addCriterion("orderStatus not like", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIn(List<String> values) {
            addCriterion("orderStatus in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotIn(List<String> values) {
            addCriterion("orderStatus not in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusBetween(String value1, String value2) {
            addCriterion("orderStatus between", value1, value2, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotBetween(String value1, String value2) {
            addCriterion("orderStatus not between", value1, value2, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andVehicleidIsNull() {
            addCriterion("vehicleId is null");
            return (Criteria) this;
        }

        public Criteria andVehicleidIsNotNull() {
            addCriterion("vehicleId is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleidEqualTo(Integer value) {
            addCriterion("vehicleId =", value, "vehicleid");
            return (Criteria) this;
        }

        public Criteria andVehicleidNotEqualTo(Integer value) {
            addCriterion("vehicleId <>", value, "vehicleid");
            return (Criteria) this;
        }

        public Criteria andVehicleidGreaterThan(Integer value) {
            addCriterion("vehicleId >", value, "vehicleid");
            return (Criteria) this;
        }

        public Criteria andVehicleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("vehicleId >=", value, "vehicleid");
            return (Criteria) this;
        }

        public Criteria andVehicleidLessThan(Integer value) {
            addCriterion("vehicleId <", value, "vehicleid");
            return (Criteria) this;
        }

        public Criteria andVehicleidLessThanOrEqualTo(Integer value) {
            addCriterion("vehicleId <=", value, "vehicleid");
            return (Criteria) this;
        }

        public Criteria andVehicleidIn(List<Integer> values) {
            addCriterion("vehicleId in", values, "vehicleid");
            return (Criteria) this;
        }

        public Criteria andVehicleidNotIn(List<Integer> values) {
            addCriterion("vehicleId not in", values, "vehicleid");
            return (Criteria) this;
        }

        public Criteria andVehicleidBetween(Integer value1, Integer value2) {
            addCriterion("vehicleId between", value1, value2, "vehicleid");
            return (Criteria) this;
        }

        public Criteria andVehicleidNotBetween(Integer value1, Integer value2) {
            addCriterion("vehicleId not between", value1, value2, "vehicleid");
            return (Criteria) this;
        }

        public Criteria andRouteidIsNull() {
            addCriterion("routeId is null");
            return (Criteria) this;
        }

        public Criteria andRouteidIsNotNull() {
            addCriterion("routeId is not null");
            return (Criteria) this;
        }

        public Criteria andRouteidEqualTo(Integer value) {
            addCriterion("routeId =", value, "routeid");
            return (Criteria) this;
        }

        public Criteria andRouteidNotEqualTo(Integer value) {
            addCriterion("routeId <>", value, "routeid");
            return (Criteria) this;
        }

        public Criteria andRouteidGreaterThan(Integer value) {
            addCriterion("routeId >", value, "routeid");
            return (Criteria) this;
        }

        public Criteria andRouteidGreaterThanOrEqualTo(Integer value) {
            addCriterion("routeId >=", value, "routeid");
            return (Criteria) this;
        }

        public Criteria andRouteidLessThan(Integer value) {
            addCriterion("routeId <", value, "routeid");
            return (Criteria) this;
        }

        public Criteria andRouteidLessThanOrEqualTo(Integer value) {
            addCriterion("routeId <=", value, "routeid");
            return (Criteria) this;
        }

        public Criteria andRouteidIn(List<Integer> values) {
            addCriterion("routeId in", values, "routeid");
            return (Criteria) this;
        }

        public Criteria andRouteidNotIn(List<Integer> values) {
            addCriterion("routeId not in", values, "routeid");
            return (Criteria) this;
        }

        public Criteria andRouteidBetween(Integer value1, Integer value2) {
            addCriterion("routeId between", value1, value2, "routeid");
            return (Criteria) this;
        }

        public Criteria andRouteidNotBetween(Integer value1, Integer value2) {
            addCriterion("routeId not between", value1, value2, "routeid");
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