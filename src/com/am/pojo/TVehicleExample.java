package com.am.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TVehicleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TVehicleExample() {
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

        public Criteria andVehicleowernameIsNull() {
            addCriterion("vehicleOwerName is null");
            return (Criteria) this;
        }

        public Criteria andVehicleowernameIsNotNull() {
            addCriterion("vehicleOwerName is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleowernameEqualTo(String value) {
            addCriterion("vehicleOwerName =", value, "vehicleowername");
            return (Criteria) this;
        }

        public Criteria andVehicleowernameNotEqualTo(String value) {
            addCriterion("vehicleOwerName <>", value, "vehicleowername");
            return (Criteria) this;
        }

        public Criteria andVehicleowernameGreaterThan(String value) {
            addCriterion("vehicleOwerName >", value, "vehicleowername");
            return (Criteria) this;
        }

        public Criteria andVehicleowernameGreaterThanOrEqualTo(String value) {
            addCriterion("vehicleOwerName >=", value, "vehicleowername");
            return (Criteria) this;
        }

        public Criteria andVehicleowernameLessThan(String value) {
            addCriterion("vehicleOwerName <", value, "vehicleowername");
            return (Criteria) this;
        }

        public Criteria andVehicleowernameLessThanOrEqualTo(String value) {
            addCriterion("vehicleOwerName <=", value, "vehicleowername");
            return (Criteria) this;
        }

        public Criteria andVehicleowernameLike(String value) {
            addCriterion("vehicleOwerName like", value, "vehicleowername");
            return (Criteria) this;
        }

        public Criteria andVehicleowernameNotLike(String value) {
            addCriterion("vehicleOwerName not like", value, "vehicleowername");
            return (Criteria) this;
        }

        public Criteria andVehicleowernameIn(List<String> values) {
            addCriterion("vehicleOwerName in", values, "vehicleowername");
            return (Criteria) this;
        }

        public Criteria andVehicleowernameNotIn(List<String> values) {
            addCriterion("vehicleOwerName not in", values, "vehicleowername");
            return (Criteria) this;
        }

        public Criteria andVehicleowernameBetween(String value1, String value2) {
            addCriterion("vehicleOwerName between", value1, value2, "vehicleowername");
            return (Criteria) this;
        }

        public Criteria andVehicleowernameNotBetween(String value1, String value2) {
            addCriterion("vehicleOwerName not between", value1, value2, "vehicleowername");
            return (Criteria) this;
        }

        public Criteria andVehiclenumIsNull() {
            addCriterion("vehicleNum is null");
            return (Criteria) this;
        }

        public Criteria andVehiclenumIsNotNull() {
            addCriterion("vehicleNum is not null");
            return (Criteria) this;
        }

        public Criteria andVehiclenumEqualTo(String value) {
            addCriterion("vehicleNum =", value, "vehiclenum");
            return (Criteria) this;
        }

        public Criteria andVehiclenumNotEqualTo(String value) {
            addCriterion("vehicleNum <>", value, "vehiclenum");
            return (Criteria) this;
        }

        public Criteria andVehiclenumGreaterThan(String value) {
            addCriterion("vehicleNum >", value, "vehiclenum");
            return (Criteria) this;
        }

        public Criteria andVehiclenumGreaterThanOrEqualTo(String value) {
            addCriterion("vehicleNum >=", value, "vehiclenum");
            return (Criteria) this;
        }

        public Criteria andVehiclenumLessThan(String value) {
            addCriterion("vehicleNum <", value, "vehiclenum");
            return (Criteria) this;
        }

        public Criteria andVehiclenumLessThanOrEqualTo(String value) {
            addCriterion("vehicleNum <=", value, "vehiclenum");
            return (Criteria) this;
        }

        public Criteria andVehiclenumLike(String value) {
            addCriterion("vehicleNum like", value, "vehiclenum");
            return (Criteria) this;
        }

        public Criteria andVehiclenumNotLike(String value) {
            addCriterion("vehicleNum not like", value, "vehiclenum");
            return (Criteria) this;
        }

        public Criteria andVehiclenumIn(List<String> values) {
            addCriterion("vehicleNum in", values, "vehiclenum");
            return (Criteria) this;
        }

        public Criteria andVehiclenumNotIn(List<String> values) {
            addCriterion("vehicleNum not in", values, "vehiclenum");
            return (Criteria) this;
        }

        public Criteria andVehiclenumBetween(String value1, String value2) {
            addCriterion("vehicleNum between", value1, value2, "vehiclenum");
            return (Criteria) this;
        }

        public Criteria andVehiclenumNotBetween(String value1, String value2) {
            addCriterion("vehicleNum not between", value1, value2, "vehiclenum");
            return (Criteria) this;
        }

        public Criteria andVehicleowercontactIsNull() {
            addCriterion("vehicleOwerContact is null");
            return (Criteria) this;
        }

        public Criteria andVehicleowercontactIsNotNull() {
            addCriterion("vehicleOwerContact is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleowercontactEqualTo(String value) {
            addCriterion("vehicleOwerContact =", value, "vehicleowercontact");
            return (Criteria) this;
        }

        public Criteria andVehicleowercontactNotEqualTo(String value) {
            addCriterion("vehicleOwerContact <>", value, "vehicleowercontact");
            return (Criteria) this;
        }

        public Criteria andVehicleowercontactGreaterThan(String value) {
            addCriterion("vehicleOwerContact >", value, "vehicleowercontact");
            return (Criteria) this;
        }

        public Criteria andVehicleowercontactGreaterThanOrEqualTo(String value) {
            addCriterion("vehicleOwerContact >=", value, "vehicleowercontact");
            return (Criteria) this;
        }

        public Criteria andVehicleowercontactLessThan(String value) {
            addCriterion("vehicleOwerContact <", value, "vehicleowercontact");
            return (Criteria) this;
        }

        public Criteria andVehicleowercontactLessThanOrEqualTo(String value) {
            addCriterion("vehicleOwerContact <=", value, "vehicleowercontact");
            return (Criteria) this;
        }

        public Criteria andVehicleowercontactLike(String value) {
            addCriterion("vehicleOwerContact like", value, "vehicleowercontact");
            return (Criteria) this;
        }

        public Criteria andVehicleowercontactNotLike(String value) {
            addCriterion("vehicleOwerContact not like", value, "vehicleowercontact");
            return (Criteria) this;
        }

        public Criteria andVehicleowercontactIn(List<String> values) {
            addCriterion("vehicleOwerContact in", values, "vehicleowercontact");
            return (Criteria) this;
        }

        public Criteria andVehicleowercontactNotIn(List<String> values) {
            addCriterion("vehicleOwerContact not in", values, "vehicleowercontact");
            return (Criteria) this;
        }

        public Criteria andVehicleowercontactBetween(String value1, String value2) {
            addCriterion("vehicleOwerContact between", value1, value2, "vehicleowercontact");
            return (Criteria) this;
        }

        public Criteria andVehicleowercontactNotBetween(String value1, String value2) {
            addCriterion("vehicleOwerContact not between", value1, value2, "vehicleowercontact");
            return (Criteria) this;
        }

        public Criteria andVehicleoweridIsNull() {
            addCriterion("vehicleOwerID is null");
            return (Criteria) this;
        }

        public Criteria andVehicleoweridIsNotNull() {
            addCriterion("vehicleOwerID is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleoweridEqualTo(String value) {
            addCriterion("vehicleOwerID =", value, "vehicleowerid");
            return (Criteria) this;
        }

        public Criteria andVehicleoweridNotEqualTo(String value) {
            addCriterion("vehicleOwerID <>", value, "vehicleowerid");
            return (Criteria) this;
        }

        public Criteria andVehicleoweridGreaterThan(String value) {
            addCriterion("vehicleOwerID >", value, "vehicleowerid");
            return (Criteria) this;
        }

        public Criteria andVehicleoweridGreaterThanOrEqualTo(String value) {
            addCriterion("vehicleOwerID >=", value, "vehicleowerid");
            return (Criteria) this;
        }

        public Criteria andVehicleoweridLessThan(String value) {
            addCriterion("vehicleOwerID <", value, "vehicleowerid");
            return (Criteria) this;
        }

        public Criteria andVehicleoweridLessThanOrEqualTo(String value) {
            addCriterion("vehicleOwerID <=", value, "vehicleowerid");
            return (Criteria) this;
        }

        public Criteria andVehicleoweridLike(String value) {
            addCriterion("vehicleOwerID like", value, "vehicleowerid");
            return (Criteria) this;
        }

        public Criteria andVehicleoweridNotLike(String value) {
            addCriterion("vehicleOwerID not like", value, "vehicleowerid");
            return (Criteria) this;
        }

        public Criteria andVehicleoweridIn(List<String> values) {
            addCriterion("vehicleOwerID in", values, "vehicleowerid");
            return (Criteria) this;
        }

        public Criteria andVehicleoweridNotIn(List<String> values) {
            addCriterion("vehicleOwerID not in", values, "vehicleowerid");
            return (Criteria) this;
        }

        public Criteria andVehicleoweridBetween(String value1, String value2) {
            addCriterion("vehicleOwerID between", value1, value2, "vehicleowerid");
            return (Criteria) this;
        }

        public Criteria andVehicleoweridNotBetween(String value1, String value2) {
            addCriterion("vehicleOwerID not between", value1, value2, "vehicleowerid");
            return (Criteria) this;
        }

        public Criteria andVehicledrivernameIsNull() {
            addCriterion("vehicleDriverName is null");
            return (Criteria) this;
        }

        public Criteria andVehicledrivernameIsNotNull() {
            addCriterion("vehicleDriverName is not null");
            return (Criteria) this;
        }

        public Criteria andVehicledrivernameEqualTo(String value) {
            addCriterion("vehicleDriverName =", value, "vehicledrivername");
            return (Criteria) this;
        }

        public Criteria andVehicledrivernameNotEqualTo(String value) {
            addCriterion("vehicleDriverName <>", value, "vehicledrivername");
            return (Criteria) this;
        }

        public Criteria andVehicledrivernameGreaterThan(String value) {
            addCriterion("vehicleDriverName >", value, "vehicledrivername");
            return (Criteria) this;
        }

        public Criteria andVehicledrivernameGreaterThanOrEqualTo(String value) {
            addCriterion("vehicleDriverName >=", value, "vehicledrivername");
            return (Criteria) this;
        }

        public Criteria andVehicledrivernameLessThan(String value) {
            addCriterion("vehicleDriverName <", value, "vehicledrivername");
            return (Criteria) this;
        }

        public Criteria andVehicledrivernameLessThanOrEqualTo(String value) {
            addCriterion("vehicleDriverName <=", value, "vehicledrivername");
            return (Criteria) this;
        }

        public Criteria andVehicledrivernameLike(String value) {
            addCriterion("vehicleDriverName like", value, "vehicledrivername");
            return (Criteria) this;
        }

        public Criteria andVehicledrivernameNotLike(String value) {
            addCriterion("vehicleDriverName not like", value, "vehicledrivername");
            return (Criteria) this;
        }

        public Criteria andVehicledrivernameIn(List<String> values) {
            addCriterion("vehicleDriverName in", values, "vehicledrivername");
            return (Criteria) this;
        }

        public Criteria andVehicledrivernameNotIn(List<String> values) {
            addCriterion("vehicleDriverName not in", values, "vehicledrivername");
            return (Criteria) this;
        }

        public Criteria andVehicledrivernameBetween(String value1, String value2) {
            addCriterion("vehicleDriverName between", value1, value2, "vehicledrivername");
            return (Criteria) this;
        }

        public Criteria andVehicledrivernameNotBetween(String value1, String value2) {
            addCriterion("vehicleDriverName not between", value1, value2, "vehicledrivername");
            return (Criteria) this;
        }

        public Criteria andVehicledriveridIsNull() {
            addCriterion("vehicleDriverID is null");
            return (Criteria) this;
        }

        public Criteria andVehicledriveridIsNotNull() {
            addCriterion("vehicleDriverID is not null");
            return (Criteria) this;
        }

        public Criteria andVehicledriveridEqualTo(String value) {
            addCriterion("vehicleDriverID =", value, "vehicledriverid");
            return (Criteria) this;
        }

        public Criteria andVehicledriveridNotEqualTo(String value) {
            addCriterion("vehicleDriverID <>", value, "vehicledriverid");
            return (Criteria) this;
        }

        public Criteria andVehicledriveridGreaterThan(String value) {
            addCriterion("vehicleDriverID >", value, "vehicledriverid");
            return (Criteria) this;
        }

        public Criteria andVehicledriveridGreaterThanOrEqualTo(String value) {
            addCriterion("vehicleDriverID >=", value, "vehicledriverid");
            return (Criteria) this;
        }

        public Criteria andVehicledriveridLessThan(String value) {
            addCriterion("vehicleDriverID <", value, "vehicledriverid");
            return (Criteria) this;
        }

        public Criteria andVehicledriveridLessThanOrEqualTo(String value) {
            addCriterion("vehicleDriverID <=", value, "vehicledriverid");
            return (Criteria) this;
        }

        public Criteria andVehicledriveridLike(String value) {
            addCriterion("vehicleDriverID like", value, "vehicledriverid");
            return (Criteria) this;
        }

        public Criteria andVehicledriveridNotLike(String value) {
            addCriterion("vehicleDriverID not like", value, "vehicledriverid");
            return (Criteria) this;
        }

        public Criteria andVehicledriveridIn(List<String> values) {
            addCriterion("vehicleDriverID in", values, "vehicledriverid");
            return (Criteria) this;
        }

        public Criteria andVehicledriveridNotIn(List<String> values) {
            addCriterion("vehicleDriverID not in", values, "vehicledriverid");
            return (Criteria) this;
        }

        public Criteria andVehicledriveridBetween(String value1, String value2) {
            addCriterion("vehicleDriverID between", value1, value2, "vehicledriverid");
            return (Criteria) this;
        }

        public Criteria andVehicledriveridNotBetween(String value1, String value2) {
            addCriterion("vehicleDriverID not between", value1, value2, "vehicledriverid");
            return (Criteria) this;
        }

        public Criteria andVehicletypeidIsNull() {
            addCriterion("vehicleTypeId is null");
            return (Criteria) this;
        }

        public Criteria andVehicletypeidIsNotNull() {
            addCriterion("vehicleTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andVehicletypeidEqualTo(Integer value) {
            addCriterion("vehicleTypeId =", value, "vehicletypeid");
            return (Criteria) this;
        }

        public Criteria andVehicletypeidNotEqualTo(Integer value) {
            addCriterion("vehicleTypeId <>", value, "vehicletypeid");
            return (Criteria) this;
        }

        public Criteria andVehicletypeidGreaterThan(Integer value) {
            addCriterion("vehicleTypeId >", value, "vehicletypeid");
            return (Criteria) this;
        }

        public Criteria andVehicletypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("vehicleTypeId >=", value, "vehicletypeid");
            return (Criteria) this;
        }

        public Criteria andVehicletypeidLessThan(Integer value) {
            addCriterion("vehicleTypeId <", value, "vehicletypeid");
            return (Criteria) this;
        }

        public Criteria andVehicletypeidLessThanOrEqualTo(Integer value) {
            addCriterion("vehicleTypeId <=", value, "vehicletypeid");
            return (Criteria) this;
        }

        public Criteria andVehicletypeidIn(List<Integer> values) {
            addCriterion("vehicleTypeId in", values, "vehicletypeid");
            return (Criteria) this;
        }

        public Criteria andVehicletypeidNotIn(List<Integer> values) {
            addCriterion("vehicleTypeId not in", values, "vehicletypeid");
            return (Criteria) this;
        }

        public Criteria andVehicletypeidBetween(Integer value1, Integer value2) {
            addCriterion("vehicleTypeId between", value1, value2, "vehicletypeid");
            return (Criteria) this;
        }

        public Criteria andVehicletypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("vehicleTypeId not between", value1, value2, "vehicletypeid");
            return (Criteria) this;
        }

        public Criteria andVehicleloadIsNull() {
            addCriterion("vehicleLoad is null");
            return (Criteria) this;
        }

        public Criteria andVehicleloadIsNotNull() {
            addCriterion("vehicleLoad is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleloadEqualTo(BigDecimal value) {
            addCriterion("vehicleLoad =", value, "vehicleload");
            return (Criteria) this;
        }

        public Criteria andVehicleloadNotEqualTo(BigDecimal value) {
            addCriterion("vehicleLoad <>", value, "vehicleload");
            return (Criteria) this;
        }

        public Criteria andVehicleloadGreaterThan(BigDecimal value) {
            addCriterion("vehicleLoad >", value, "vehicleload");
            return (Criteria) this;
        }

        public Criteria andVehicleloadGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vehicleLoad >=", value, "vehicleload");
            return (Criteria) this;
        }

        public Criteria andVehicleloadLessThan(BigDecimal value) {
            addCriterion("vehicleLoad <", value, "vehicleload");
            return (Criteria) this;
        }

        public Criteria andVehicleloadLessThanOrEqualTo(BigDecimal value) {
            addCriterion("vehicleLoad <=", value, "vehicleload");
            return (Criteria) this;
        }

        public Criteria andVehicleloadIn(List<BigDecimal> values) {
            addCriterion("vehicleLoad in", values, "vehicleload");
            return (Criteria) this;
        }

        public Criteria andVehicleloadNotIn(List<BigDecimal> values) {
            addCriterion("vehicleLoad not in", values, "vehicleload");
            return (Criteria) this;
        }

        public Criteria andVehicleloadBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vehicleLoad between", value1, value2, "vehicleload");
            return (Criteria) this;
        }

        public Criteria andVehicleloadNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vehicleLoad not between", value1, value2, "vehicleload");
            return (Criteria) this;
        }

        public Criteria andVehiclestatusIsNull() {
            addCriterion("vehicleStatus is null");
            return (Criteria) this;
        }

        public Criteria andVehiclestatusIsNotNull() {
            addCriterion("vehicleStatus is not null");
            return (Criteria) this;
        }

        public Criteria andVehiclestatusEqualTo(String value) {
            addCriterion("vehicleStatus =", value, "vehiclestatus");
            return (Criteria) this;
        }

        public Criteria andVehiclestatusNotEqualTo(String value) {
            addCriterion("vehicleStatus <>", value, "vehiclestatus");
            return (Criteria) this;
        }

        public Criteria andVehiclestatusGreaterThan(String value) {
            addCriterion("vehicleStatus >", value, "vehiclestatus");
            return (Criteria) this;
        }

        public Criteria andVehiclestatusGreaterThanOrEqualTo(String value) {
            addCriterion("vehicleStatus >=", value, "vehiclestatus");
            return (Criteria) this;
        }

        public Criteria andVehiclestatusLessThan(String value) {
            addCriterion("vehicleStatus <", value, "vehiclestatus");
            return (Criteria) this;
        }

        public Criteria andVehiclestatusLessThanOrEqualTo(String value) {
            addCriterion("vehicleStatus <=", value, "vehiclestatus");
            return (Criteria) this;
        }

        public Criteria andVehiclestatusLike(String value) {
            addCriterion("vehicleStatus like", value, "vehiclestatus");
            return (Criteria) this;
        }

        public Criteria andVehiclestatusNotLike(String value) {
            addCriterion("vehicleStatus not like", value, "vehiclestatus");
            return (Criteria) this;
        }

        public Criteria andVehiclestatusIn(List<String> values) {
            addCriterion("vehicleStatus in", values, "vehiclestatus");
            return (Criteria) this;
        }

        public Criteria andVehiclestatusNotIn(List<String> values) {
            addCriterion("vehicleStatus not in", values, "vehiclestatus");
            return (Criteria) this;
        }

        public Criteria andVehiclestatusBetween(String value1, String value2) {
            addCriterion("vehicleStatus between", value1, value2, "vehiclestatus");
            return (Criteria) this;
        }

        public Criteria andVehiclestatusNotBetween(String value1, String value2) {
            addCriterion("vehicleStatus not between", value1, value2, "vehiclestatus");
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