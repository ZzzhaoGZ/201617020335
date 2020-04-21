package com.am.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TRouteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRouteExample() {
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

        public Criteria andRoutenameIsNull() {
            addCriterion("routeName is null");
            return (Criteria) this;
        }

        public Criteria andRoutenameIsNotNull() {
            addCriterion("routeName is not null");
            return (Criteria) this;
        }

        public Criteria andRoutenameEqualTo(String value) {
            addCriterion("routeName =", value, "routename");
            return (Criteria) this;
        }

        public Criteria andRoutenameNotEqualTo(String value) {
            addCriterion("routeName <>", value, "routename");
            return (Criteria) this;
        }

        public Criteria andRoutenameGreaterThan(String value) {
            addCriterion("routeName >", value, "routename");
            return (Criteria) this;
        }

        public Criteria andRoutenameGreaterThanOrEqualTo(String value) {
            addCriterion("routeName >=", value, "routename");
            return (Criteria) this;
        }

        public Criteria andRoutenameLessThan(String value) {
            addCriterion("routeName <", value, "routename");
            return (Criteria) this;
        }

        public Criteria andRoutenameLessThanOrEqualTo(String value) {
            addCriterion("routeName <=", value, "routename");
            return (Criteria) this;
        }

        public Criteria andRoutenameLike(String value) {
            addCriterion("routeName like", value, "routename");
            return (Criteria) this;
        }

        public Criteria andRoutenameNotLike(String value) {
            addCriterion("routeName not like", value, "routename");
            return (Criteria) this;
        }

        public Criteria andRoutenameIn(List<String> values) {
            addCriterion("routeName in", values, "routename");
            return (Criteria) this;
        }

        public Criteria andRoutenameNotIn(List<String> values) {
            addCriterion("routeName not in", values, "routename");
            return (Criteria) this;
        }

        public Criteria andRoutenameBetween(String value1, String value2) {
            addCriterion("routeName between", value1, value2, "routename");
            return (Criteria) this;
        }

        public Criteria andRoutenameNotBetween(String value1, String value2) {
            addCriterion("routeName not between", value1, value2, "routename");
            return (Criteria) this;
        }

        public Criteria andRoutedescIsNull() {
            addCriterion("routeDesc is null");
            return (Criteria) this;
        }

        public Criteria andRoutedescIsNotNull() {
            addCriterion("routeDesc is not null");
            return (Criteria) this;
        }

        public Criteria andRoutedescEqualTo(String value) {
            addCriterion("routeDesc =", value, "routedesc");
            return (Criteria) this;
        }

        public Criteria andRoutedescNotEqualTo(String value) {
            addCriterion("routeDesc <>", value, "routedesc");
            return (Criteria) this;
        }

        public Criteria andRoutedescGreaterThan(String value) {
            addCriterion("routeDesc >", value, "routedesc");
            return (Criteria) this;
        }

        public Criteria andRoutedescGreaterThanOrEqualTo(String value) {
            addCriterion("routeDesc >=", value, "routedesc");
            return (Criteria) this;
        }

        public Criteria andRoutedescLessThan(String value) {
            addCriterion("routeDesc <", value, "routedesc");
            return (Criteria) this;
        }

        public Criteria andRoutedescLessThanOrEqualTo(String value) {
            addCriterion("routeDesc <=", value, "routedesc");
            return (Criteria) this;
        }

        public Criteria andRoutedescLike(String value) {
            addCriterion("routeDesc like", value, "routedesc");
            return (Criteria) this;
        }

        public Criteria andRoutedescNotLike(String value) {
            addCriterion("routeDesc not like", value, "routedesc");
            return (Criteria) this;
        }

        public Criteria andRoutedescIn(List<String> values) {
            addCriterion("routeDesc in", values, "routedesc");
            return (Criteria) this;
        }

        public Criteria andRoutedescNotIn(List<String> values) {
            addCriterion("routeDesc not in", values, "routedesc");
            return (Criteria) this;
        }

        public Criteria andRoutedescBetween(String value1, String value2) {
            addCriterion("routeDesc between", value1, value2, "routedesc");
            return (Criteria) this;
        }

        public Criteria andRoutedescNotBetween(String value1, String value2) {
            addCriterion("routeDesc not between", value1, value2, "routedesc");
            return (Criteria) this;
        }

        public Criteria andRoutecreateIsNull() {
            addCriterion("routeCreate is null");
            return (Criteria) this;
        }

        public Criteria andRoutecreateIsNotNull() {
            addCriterion("routeCreate is not null");
            return (Criteria) this;
        }

        public Criteria andRoutecreateEqualTo(Date value) {
            addCriterion("routeCreate =", value, "routecreate");
            return (Criteria) this;
        }

        public Criteria andRoutecreateNotEqualTo(Date value) {
            addCriterion("routeCreate <>", value, "routecreate");
            return (Criteria) this;
        }

        public Criteria andRoutecreateGreaterThan(Date value) {
            addCriterion("routeCreate >", value, "routecreate");
            return (Criteria) this;
        }

        public Criteria andRoutecreateGreaterThanOrEqualTo(Date value) {
            addCriterion("routeCreate >=", value, "routecreate");
            return (Criteria) this;
        }

        public Criteria andRoutecreateLessThan(Date value) {
            addCriterion("routeCreate <", value, "routecreate");
            return (Criteria) this;
        }

        public Criteria andRoutecreateLessThanOrEqualTo(Date value) {
            addCriterion("routeCreate <=", value, "routecreate");
            return (Criteria) this;
        }

        public Criteria andRoutecreateIn(List<Date> values) {
            addCriterion("routeCreate in", values, "routecreate");
            return (Criteria) this;
        }

        public Criteria andRoutecreateNotIn(List<Date> values) {
            addCriterion("routeCreate not in", values, "routecreate");
            return (Criteria) this;
        }

        public Criteria andRoutecreateBetween(Date value1, Date value2) {
            addCriterion("routeCreate between", value1, value2, "routecreate");
            return (Criteria) this;
        }

        public Criteria andRoutecreateNotBetween(Date value1, Date value2) {
            addCriterion("routeCreate not between", value1, value2, "routecreate");
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