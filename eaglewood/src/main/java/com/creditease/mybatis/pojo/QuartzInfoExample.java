package com.creditease.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class QuartzInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuartzInfoExample() {
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

        public Criteria andSystemFlagIsNull() {
            addCriterion("system_flag is null");
            return (Criteria) this;
        }

        public Criteria andSystemFlagIsNotNull() {
            addCriterion("system_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSystemFlagEqualTo(String value) {
            addCriterion("system_flag =", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotEqualTo(String value) {
            addCriterion("system_flag <>", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagGreaterThan(String value) {
            addCriterion("system_flag >", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagGreaterThanOrEqualTo(String value) {
            addCriterion("system_flag >=", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagLessThan(String value) {
            addCriterion("system_flag <", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagLessThanOrEqualTo(String value) {
            addCriterion("system_flag <=", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagLike(String value) {
            addCriterion("system_flag like", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotLike(String value) {
            addCriterion("system_flag not like", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagIn(List<String> values) {
            addCriterion("system_flag in", values, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotIn(List<String> values) {
            addCriterion("system_flag not in", values, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagBetween(String value1, String value2) {
            addCriterion("system_flag between", value1, value2, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotBetween(String value1, String value2) {
            addCriterion("system_flag not between", value1, value2, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemEnvIsNull() {
            addCriterion("system_env is null");
            return (Criteria) this;
        }

        public Criteria andSystemEnvIsNotNull() {
            addCriterion("system_env is not null");
            return (Criteria) this;
        }

        public Criteria andSystemEnvEqualTo(String value) {
            addCriterion("system_env =", value, "systemEnv");
            return (Criteria) this;
        }

        public Criteria andSystemEnvNotEqualTo(String value) {
            addCriterion("system_env <>", value, "systemEnv");
            return (Criteria) this;
        }

        public Criteria andSystemEnvGreaterThan(String value) {
            addCriterion("system_env >", value, "systemEnv");
            return (Criteria) this;
        }

        public Criteria andSystemEnvGreaterThanOrEqualTo(String value) {
            addCriterion("system_env >=", value, "systemEnv");
            return (Criteria) this;
        }

        public Criteria andSystemEnvLessThan(String value) {
            addCriterion("system_env <", value, "systemEnv");
            return (Criteria) this;
        }

        public Criteria andSystemEnvLessThanOrEqualTo(String value) {
            addCriterion("system_env <=", value, "systemEnv");
            return (Criteria) this;
        }

        public Criteria andSystemEnvLike(String value) {
            addCriterion("system_env like", value, "systemEnv");
            return (Criteria) this;
        }

        public Criteria andSystemEnvNotLike(String value) {
            addCriterion("system_env not like", value, "systemEnv");
            return (Criteria) this;
        }

        public Criteria andSystemEnvIn(List<String> values) {
            addCriterion("system_env in", values, "systemEnv");
            return (Criteria) this;
        }

        public Criteria andSystemEnvNotIn(List<String> values) {
            addCriterion("system_env not in", values, "systemEnv");
            return (Criteria) this;
        }

        public Criteria andSystemEnvBetween(String value1, String value2) {
            addCriterion("system_env between", value1, value2, "systemEnv");
            return (Criteria) this;
        }

        public Criteria andSystemEnvNotBetween(String value1, String value2) {
            addCriterion("system_env not between", value1, value2, "systemEnv");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNull() {
            addCriterion("service_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("service_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(String value) {
            addCriterion("service_id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(String value) {
            addCriterion("service_id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(String value) {
            addCriterion("service_id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(String value) {
            addCriterion("service_id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(String value) {
            addCriterion("service_id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(String value) {
            addCriterion("service_id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLike(String value) {
            addCriterion("service_id like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotLike(String value) {
            addCriterion("service_id not like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<String> values) {
            addCriterion("service_id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<String> values) {
            addCriterion("service_id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(String value1, String value2) {
            addCriterion("service_id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(String value1, String value2) {
            addCriterion("service_id not between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andCronExpressIsNull() {
            addCriterion("cron_express is null");
            return (Criteria) this;
        }

        public Criteria andCronExpressIsNotNull() {
            addCriterion("cron_express is not null");
            return (Criteria) this;
        }

        public Criteria andCronExpressEqualTo(String value) {
            addCriterion("cron_express =", value, "cronExpress");
            return (Criteria) this;
        }

        public Criteria andCronExpressNotEqualTo(String value) {
            addCriterion("cron_express <>", value, "cronExpress");
            return (Criteria) this;
        }

        public Criteria andCronExpressGreaterThan(String value) {
            addCriterion("cron_express >", value, "cronExpress");
            return (Criteria) this;
        }

        public Criteria andCronExpressGreaterThanOrEqualTo(String value) {
            addCriterion("cron_express >=", value, "cronExpress");
            return (Criteria) this;
        }

        public Criteria andCronExpressLessThan(String value) {
            addCriterion("cron_express <", value, "cronExpress");
            return (Criteria) this;
        }

        public Criteria andCronExpressLessThanOrEqualTo(String value) {
            addCriterion("cron_express <=", value, "cronExpress");
            return (Criteria) this;
        }

        public Criteria andCronExpressLike(String value) {
            addCriterion("cron_express like", value, "cronExpress");
            return (Criteria) this;
        }

        public Criteria andCronExpressNotLike(String value) {
            addCriterion("cron_express not like", value, "cronExpress");
            return (Criteria) this;
        }

        public Criteria andCronExpressIn(List<String> values) {
            addCriterion("cron_express in", values, "cronExpress");
            return (Criteria) this;
        }

        public Criteria andCronExpressNotIn(List<String> values) {
            addCriterion("cron_express not in", values, "cronExpress");
            return (Criteria) this;
        }

        public Criteria andCronExpressBetween(String value1, String value2) {
            addCriterion("cron_express between", value1, value2, "cronExpress");
            return (Criteria) this;
        }

        public Criteria andCronExpressNotBetween(String value1, String value2) {
            addCriterion("cron_express not between", value1, value2, "cronExpress");
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