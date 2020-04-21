package com.am.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSpeciesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSpeciesExample() {
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

        public Criteria andSpeciesidIsNull() {
            addCriterion("speciesId is null");
            return (Criteria) this;
        }

        public Criteria andSpeciesidIsNotNull() {
            addCriterion("speciesId is not null");
            return (Criteria) this;
        }

        public Criteria andSpeciesidEqualTo(Integer value) {
            addCriterion("speciesId =", value, "speciesid");
            return (Criteria) this;
        }

        public Criteria andSpeciesidNotEqualTo(Integer value) {
            addCriterion("speciesId <>", value, "speciesid");
            return (Criteria) this;
        }

        public Criteria andSpeciesidGreaterThan(Integer value) {
            addCriterion("speciesId >", value, "speciesid");
            return (Criteria) this;
        }

        public Criteria andSpeciesidGreaterThanOrEqualTo(Integer value) {
            addCriterion("speciesId >=", value, "speciesid");
            return (Criteria) this;
        }

        public Criteria andSpeciesidLessThan(Integer value) {
            addCriterion("speciesId <", value, "speciesid");
            return (Criteria) this;
        }

        public Criteria andSpeciesidLessThanOrEqualTo(Integer value) {
            addCriterion("speciesId <=", value, "speciesid");
            return (Criteria) this;
        }

        public Criteria andSpeciesidIn(List<Integer> values) {
            addCriterion("speciesId in", values, "speciesid");
            return (Criteria) this;
        }

        public Criteria andSpeciesidNotIn(List<Integer> values) {
            addCriterion("speciesId not in", values, "speciesid");
            return (Criteria) this;
        }

        public Criteria andSpeciesidBetween(Integer value1, Integer value2) {
            addCriterion("speciesId between", value1, value2, "speciesid");
            return (Criteria) this;
        }

        public Criteria andSpeciesidNotBetween(Integer value1, Integer value2) {
            addCriterion("speciesId not between", value1, value2, "speciesid");
            return (Criteria) this;
        }

        public Criteria andSpeciesparentidIsNull() {
            addCriterion("speciesParentId is null");
            return (Criteria) this;
        }

        public Criteria andSpeciesparentidIsNotNull() {
            addCriterion("speciesParentId is not null");
            return (Criteria) this;
        }

        public Criteria andSpeciesparentidEqualTo(Integer value) {
            addCriterion("speciesParentId =", value, "speciesparentid");
            return (Criteria) this;
        }

        public Criteria andSpeciesparentidNotEqualTo(Integer value) {
            addCriterion("speciesParentId <>", value, "speciesparentid");
            return (Criteria) this;
        }

        public Criteria andSpeciesparentidGreaterThan(Integer value) {
            addCriterion("speciesParentId >", value, "speciesparentid");
            return (Criteria) this;
        }

        public Criteria andSpeciesparentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("speciesParentId >=", value, "speciesparentid");
            return (Criteria) this;
        }

        public Criteria andSpeciesparentidLessThan(Integer value) {
            addCriterion("speciesParentId <", value, "speciesparentid");
            return (Criteria) this;
        }

        public Criteria andSpeciesparentidLessThanOrEqualTo(Integer value) {
            addCriterion("speciesParentId <=", value, "speciesparentid");
            return (Criteria) this;
        }

        public Criteria andSpeciesparentidIn(List<Integer> values) {
            addCriterion("speciesParentId in", values, "speciesparentid");
            return (Criteria) this;
        }

        public Criteria andSpeciesparentidNotIn(List<Integer> values) {
            addCriterion("speciesParentId not in", values, "speciesparentid");
            return (Criteria) this;
        }

        public Criteria andSpeciesparentidBetween(Integer value1, Integer value2) {
            addCriterion("speciesParentId between", value1, value2, "speciesparentid");
            return (Criteria) this;
        }

        public Criteria andSpeciesparentidNotBetween(Integer value1, Integer value2) {
            addCriterion("speciesParentId not between", value1, value2, "speciesparentid");
            return (Criteria) this;
        }

        public Criteria andSpeciesnameIsNull() {
            addCriterion("speciesName is null");
            return (Criteria) this;
        }

        public Criteria andSpeciesnameIsNotNull() {
            addCriterion("speciesName is not null");
            return (Criteria) this;
        }

        public Criteria andSpeciesnameEqualTo(String value) {
            addCriterion("speciesName =", value, "speciesname");
            return (Criteria) this;
        }

        public Criteria andSpeciesnameNotEqualTo(String value) {
            addCriterion("speciesName <>", value, "speciesname");
            return (Criteria) this;
        }

        public Criteria andSpeciesnameGreaterThan(String value) {
            addCriterion("speciesName >", value, "speciesname");
            return (Criteria) this;
        }

        public Criteria andSpeciesnameGreaterThanOrEqualTo(String value) {
            addCriterion("speciesName >=", value, "speciesname");
            return (Criteria) this;
        }

        public Criteria andSpeciesnameLessThan(String value) {
            addCriterion("speciesName <", value, "speciesname");
            return (Criteria) this;
        }

        public Criteria andSpeciesnameLessThanOrEqualTo(String value) {
            addCriterion("speciesName <=", value, "speciesname");
            return (Criteria) this;
        }

        public Criteria andSpeciesnameLike(String value) {
            addCriterion("speciesName like", value, "speciesname");
            return (Criteria) this;
        }

        public Criteria andSpeciesnameNotLike(String value) {
            addCriterion("speciesName not like", value, "speciesname");
            return (Criteria) this;
        }

        public Criteria andSpeciesnameIn(List<String> values) {
            addCriterion("speciesName in", values, "speciesname");
            return (Criteria) this;
        }

        public Criteria andSpeciesnameNotIn(List<String> values) {
            addCriterion("speciesName not in", values, "speciesname");
            return (Criteria) this;
        }

        public Criteria andSpeciesnameBetween(String value1, String value2) {
            addCriterion("speciesName between", value1, value2, "speciesname");
            return (Criteria) this;
        }

        public Criteria andSpeciesnameNotBetween(String value1, String value2) {
            addCriterion("speciesName not between", value1, value2, "speciesname");
            return (Criteria) this;
        }

        public Criteria andSpeciestimeIsNull() {
            addCriterion("speciesTime is null");
            return (Criteria) this;
        }

        public Criteria andSpeciestimeIsNotNull() {
            addCriterion("speciesTime is not null");
            return (Criteria) this;
        }

        public Criteria andSpeciestimeEqualTo(Date value) {
            addCriterion("speciesTime =", value, "speciestime");
            return (Criteria) this;
        }

        public Criteria andSpeciestimeNotEqualTo(Date value) {
            addCriterion("speciesTime <>", value, "speciestime");
            return (Criteria) this;
        }

        public Criteria andSpeciestimeGreaterThan(Date value) {
            addCriterion("speciesTime >", value, "speciestime");
            return (Criteria) this;
        }

        public Criteria andSpeciestimeGreaterThanOrEqualTo(Date value) {
            addCriterion("speciesTime >=", value, "speciestime");
            return (Criteria) this;
        }

        public Criteria andSpeciestimeLessThan(Date value) {
            addCriterion("speciesTime <", value, "speciestime");
            return (Criteria) this;
        }

        public Criteria andSpeciestimeLessThanOrEqualTo(Date value) {
            addCriterion("speciesTime <=", value, "speciestime");
            return (Criteria) this;
        }

        public Criteria andSpeciestimeIn(List<Date> values) {
            addCriterion("speciesTime in", values, "speciestime");
            return (Criteria) this;
        }

        public Criteria andSpeciestimeNotIn(List<Date> values) {
            addCriterion("speciesTime not in", values, "speciestime");
            return (Criteria) this;
        }

        public Criteria andSpeciestimeBetween(Date value1, Date value2) {
            addCriterion("speciesTime between", value1, value2, "speciestime");
            return (Criteria) this;
        }

        public Criteria andSpeciestimeNotBetween(Date value1, Date value2) {
            addCriterion("speciesTime not between", value1, value2, "speciestime");
            return (Criteria) this;
        }

        public Criteria andIsparentIsNull() {
            addCriterion("isParent is null");
            return (Criteria) this;
        }

        public Criteria andIsparentIsNotNull() {
            addCriterion("isParent is not null");
            return (Criteria) this;
        }

        public Criteria andIsparentEqualTo(Boolean value) {
            addCriterion("isParent =", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentNotEqualTo(Boolean value) {
            addCriterion("isParent <>", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentGreaterThan(Boolean value) {
            addCriterion("isParent >", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isParent >=", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentLessThan(Boolean value) {
            addCriterion("isParent <", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentLessThanOrEqualTo(Boolean value) {
            addCriterion("isParent <=", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentIn(List<Boolean> values) {
            addCriterion("isParent in", values, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentNotIn(List<Boolean> values) {
            addCriterion("isParent not in", values, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentBetween(Boolean value1, Boolean value2) {
            addCriterion("isParent between", value1, value2, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isParent not between", value1, value2, "isparent");
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