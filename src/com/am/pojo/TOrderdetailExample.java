package com.am.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TOrderdetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOrderdetailExample() {
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

        public Criteria andOrderdetailidIsNull() {
            addCriterion("orderDetailId is null");
            return (Criteria) this;
        }

        public Criteria andOrderdetailidIsNotNull() {
            addCriterion("orderDetailId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdetailidEqualTo(Integer value) {
            addCriterion("orderDetailId =", value, "orderdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderdetailidNotEqualTo(Integer value) {
            addCriterion("orderDetailId <>", value, "orderdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderdetailidGreaterThan(Integer value) {
            addCriterion("orderDetailId >", value, "orderdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderdetailidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderDetailId >=", value, "orderdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderdetailidLessThan(Integer value) {
            addCriterion("orderDetailId <", value, "orderdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderdetailidLessThanOrEqualTo(Integer value) {
            addCriterion("orderDetailId <=", value, "orderdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderdetailidIn(List<Integer> values) {
            addCriterion("orderDetailId in", values, "orderdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderdetailidNotIn(List<Integer> values) {
            addCriterion("orderDetailId not in", values, "orderdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderdetailidBetween(Integer value1, Integer value2) {
            addCriterion("orderDetailId between", value1, value2, "orderdetailid");
            return (Criteria) this;
        }

        public Criteria andOrderdetailidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderDetailId not between", value1, value2, "orderdetailid");
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

        public Criteria andItemidIsNull() {
            addCriterion("itemId is null");
            return (Criteria) this;
        }

        public Criteria andItemidIsNotNull() {
            addCriterion("itemId is not null");
            return (Criteria) this;
        }

        public Criteria andItemidEqualTo(Integer value) {
            addCriterion("itemId =", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotEqualTo(Integer value) {
            addCriterion("itemId <>", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidGreaterThan(Integer value) {
            addCriterion("itemId >", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("itemId >=", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidLessThan(Integer value) {
            addCriterion("itemId <", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidLessThanOrEqualTo(Integer value) {
            addCriterion("itemId <=", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidIn(List<Integer> values) {
            addCriterion("itemId in", values, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotIn(List<Integer> values) {
            addCriterion("itemId not in", values, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidBetween(Integer value1, Integer value2) {
            addCriterion("itemId between", value1, value2, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotBetween(Integer value1, Integer value2) {
            addCriterion("itemId not between", value1, value2, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemnumIsNull() {
            addCriterion("itemNum is null");
            return (Criteria) this;
        }

        public Criteria andItemnumIsNotNull() {
            addCriterion("itemNum is not null");
            return (Criteria) this;
        }

        public Criteria andItemnumEqualTo(Integer value) {
            addCriterion("itemNum =", value, "itemnum");
            return (Criteria) this;
        }

        public Criteria andItemnumNotEqualTo(Integer value) {
            addCriterion("itemNum <>", value, "itemnum");
            return (Criteria) this;
        }

        public Criteria andItemnumGreaterThan(Integer value) {
            addCriterion("itemNum >", value, "itemnum");
            return (Criteria) this;
        }

        public Criteria andItemnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("itemNum >=", value, "itemnum");
            return (Criteria) this;
        }

        public Criteria andItemnumLessThan(Integer value) {
            addCriterion("itemNum <", value, "itemnum");
            return (Criteria) this;
        }

        public Criteria andItemnumLessThanOrEqualTo(Integer value) {
            addCriterion("itemNum <=", value, "itemnum");
            return (Criteria) this;
        }

        public Criteria andItemnumIn(List<Integer> values) {
            addCriterion("itemNum in", values, "itemnum");
            return (Criteria) this;
        }

        public Criteria andItemnumNotIn(List<Integer> values) {
            addCriterion("itemNum not in", values, "itemnum");
            return (Criteria) this;
        }

        public Criteria andItemnumBetween(Integer value1, Integer value2) {
            addCriterion("itemNum between", value1, value2, "itemnum");
            return (Criteria) this;
        }

        public Criteria andItemnumNotBetween(Integer value1, Integer value2) {
            addCriterion("itemNum not between", value1, value2, "itemnum");
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