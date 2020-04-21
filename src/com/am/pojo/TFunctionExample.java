package com.am.pojo;

import java.util.ArrayList;
import java.util.List;

public class TFunctionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TFunctionExample() {
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

        public Criteria andFunctionidIsNull() {
            addCriterion("functionId is null");
            return (Criteria) this;
        }

        public Criteria andFunctionidIsNotNull() {
            addCriterion("functionId is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionidEqualTo(Integer value) {
            addCriterion("functionId =", value, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidNotEqualTo(Integer value) {
            addCriterion("functionId <>", value, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidGreaterThan(Integer value) {
            addCriterion("functionId >", value, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("functionId >=", value, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidLessThan(Integer value) {
            addCriterion("functionId <", value, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidLessThanOrEqualTo(Integer value) {
            addCriterion("functionId <=", value, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidIn(List<Integer> values) {
            addCriterion("functionId in", values, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidNotIn(List<Integer> values) {
            addCriterion("functionId not in", values, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidBetween(Integer value1, Integer value2) {
            addCriterion("functionId between", value1, value2, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionidNotBetween(Integer value1, Integer value2) {
            addCriterion("functionId not between", value1, value2, "functionid");
            return (Criteria) this;
        }

        public Criteria andFunctionparentidIsNull() {
            addCriterion("functionParentId is null");
            return (Criteria) this;
        }

        public Criteria andFunctionparentidIsNotNull() {
            addCriterion("functionParentId is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionparentidEqualTo(Integer value) {
            addCriterion("functionParentId =", value, "functionparentid");
            return (Criteria) this;
        }

        public Criteria andFunctionparentidNotEqualTo(Integer value) {
            addCriterion("functionParentId <>", value, "functionparentid");
            return (Criteria) this;
        }

        public Criteria andFunctionparentidGreaterThan(Integer value) {
            addCriterion("functionParentId >", value, "functionparentid");
            return (Criteria) this;
        }

        public Criteria andFunctionparentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("functionParentId >=", value, "functionparentid");
            return (Criteria) this;
        }

        public Criteria andFunctionparentidLessThan(Integer value) {
            addCriterion("functionParentId <", value, "functionparentid");
            return (Criteria) this;
        }

        public Criteria andFunctionparentidLessThanOrEqualTo(Integer value) {
            addCriterion("functionParentId <=", value, "functionparentid");
            return (Criteria) this;
        }

        public Criteria andFunctionparentidIn(List<Integer> values) {
            addCriterion("functionParentId in", values, "functionparentid");
            return (Criteria) this;
        }

        public Criteria andFunctionparentidNotIn(List<Integer> values) {
            addCriterion("functionParentId not in", values, "functionparentid");
            return (Criteria) this;
        }

        public Criteria andFunctionparentidBetween(Integer value1, Integer value2) {
            addCriterion("functionParentId between", value1, value2, "functionparentid");
            return (Criteria) this;
        }

        public Criteria andFunctionparentidNotBetween(Integer value1, Integer value2) {
            addCriterion("functionParentId not between", value1, value2, "functionparentid");
            return (Criteria) this;
        }

        public Criteria andFunctionnameIsNull() {
            addCriterion("functionName is null");
            return (Criteria) this;
        }

        public Criteria andFunctionnameIsNotNull() {
            addCriterion("functionName is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionnameEqualTo(String value) {
            addCriterion("functionName =", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameNotEqualTo(String value) {
            addCriterion("functionName <>", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameGreaterThan(String value) {
            addCriterion("functionName >", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameGreaterThanOrEqualTo(String value) {
            addCriterion("functionName >=", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameLessThan(String value) {
            addCriterion("functionName <", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameLessThanOrEqualTo(String value) {
            addCriterion("functionName <=", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameLike(String value) {
            addCriterion("functionName like", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameNotLike(String value) {
            addCriterion("functionName not like", value, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameIn(List<String> values) {
            addCriterion("functionName in", values, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameNotIn(List<String> values) {
            addCriterion("functionName not in", values, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameBetween(String value1, String value2) {
            addCriterion("functionName between", value1, value2, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionnameNotBetween(String value1, String value2) {
            addCriterion("functionName not between", value1, value2, "functionname");
            return (Criteria) this;
        }

        public Criteria andFunctionurlIsNull() {
            addCriterion("functionUrl is null");
            return (Criteria) this;
        }

        public Criteria andFunctionurlIsNotNull() {
            addCriterion("functionUrl is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionurlEqualTo(String value) {
            addCriterion("functionUrl =", value, "functionurl");
            return (Criteria) this;
        }

        public Criteria andFunctionurlNotEqualTo(String value) {
            addCriterion("functionUrl <>", value, "functionurl");
            return (Criteria) this;
        }

        public Criteria andFunctionurlGreaterThan(String value) {
            addCriterion("functionUrl >", value, "functionurl");
            return (Criteria) this;
        }

        public Criteria andFunctionurlGreaterThanOrEqualTo(String value) {
            addCriterion("functionUrl >=", value, "functionurl");
            return (Criteria) this;
        }

        public Criteria andFunctionurlLessThan(String value) {
            addCriterion("functionUrl <", value, "functionurl");
            return (Criteria) this;
        }

        public Criteria andFunctionurlLessThanOrEqualTo(String value) {
            addCriterion("functionUrl <=", value, "functionurl");
            return (Criteria) this;
        }

        public Criteria andFunctionurlLike(String value) {
            addCriterion("functionUrl like", value, "functionurl");
            return (Criteria) this;
        }

        public Criteria andFunctionurlNotLike(String value) {
            addCriterion("functionUrl not like", value, "functionurl");
            return (Criteria) this;
        }

        public Criteria andFunctionurlIn(List<String> values) {
            addCriterion("functionUrl in", values, "functionurl");
            return (Criteria) this;
        }

        public Criteria andFunctionurlNotIn(List<String> values) {
            addCriterion("functionUrl not in", values, "functionurl");
            return (Criteria) this;
        }

        public Criteria andFunctionurlBetween(String value1, String value2) {
            addCriterion("functionUrl between", value1, value2, "functionurl");
            return (Criteria) this;
        }

        public Criteria andFunctionurlNotBetween(String value1, String value2) {
            addCriterion("functionUrl not between", value1, value2, "functionurl");
            return (Criteria) this;
        }

        public Criteria andFunctionisparentIsNull() {
            addCriterion("functionIsParent is null");
            return (Criteria) this;
        }

        public Criteria andFunctionisparentIsNotNull() {
            addCriterion("functionIsParent is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionisparentEqualTo(Boolean value) {
            addCriterion("functionIsParent =", value, "functionisparent");
            return (Criteria) this;
        }

        public Criteria andFunctionisparentNotEqualTo(Boolean value) {
            addCriterion("functionIsParent <>", value, "functionisparent");
            return (Criteria) this;
        }

        public Criteria andFunctionisparentGreaterThan(Boolean value) {
            addCriterion("functionIsParent >", value, "functionisparent");
            return (Criteria) this;
        }

        public Criteria andFunctionisparentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("functionIsParent >=", value, "functionisparent");
            return (Criteria) this;
        }

        public Criteria andFunctionisparentLessThan(Boolean value) {
            addCriterion("functionIsParent <", value, "functionisparent");
            return (Criteria) this;
        }

        public Criteria andFunctionisparentLessThanOrEqualTo(Boolean value) {
            addCriterion("functionIsParent <=", value, "functionisparent");
            return (Criteria) this;
        }

        public Criteria andFunctionisparentIn(List<Boolean> values) {
            addCriterion("functionIsParent in", values, "functionisparent");
            return (Criteria) this;
        }

        public Criteria andFunctionisparentNotIn(List<Boolean> values) {
            addCriterion("functionIsParent not in", values, "functionisparent");
            return (Criteria) this;
        }

        public Criteria andFunctionisparentBetween(Boolean value1, Boolean value2) {
            addCriterion("functionIsParent between", value1, value2, "functionisparent");
            return (Criteria) this;
        }

        public Criteria andFunctionisparentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("functionIsParent not between", value1, value2, "functionisparent");
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