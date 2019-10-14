package com.creditease.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysInfoExample() {
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

        public Criteria andRequestUrlIsNull() {
            addCriterion("request_url is null");
            return (Criteria) this;
        }

        public Criteria andRequestUrlIsNotNull() {
            addCriterion("request_url is not null");
            return (Criteria) this;
        }

        public Criteria andRequestUrlEqualTo(String value) {
            addCriterion("request_url =", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlNotEqualTo(String value) {
            addCriterion("request_url <>", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlGreaterThan(String value) {
            addCriterion("request_url >", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlGreaterThanOrEqualTo(String value) {
            addCriterion("request_url >=", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlLessThan(String value) {
            addCriterion("request_url <", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlLessThanOrEqualTo(String value) {
            addCriterion("request_url <=", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlLike(String value) {
            addCriterion("request_url like", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlNotLike(String value) {
            addCriterion("request_url not like", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlIn(List<String> values) {
            addCriterion("request_url in", values, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlNotIn(List<String> values) {
            addCriterion("request_url not in", values, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlBetween(String value1, String value2) {
            addCriterion("request_url between", value1, value2, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlNotBetween(String value1, String value2) {
            addCriterion("request_url not between", value1, value2, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyIsNull() {
            addCriterion("plat_public_key is null");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyIsNotNull() {
            addCriterion("plat_public_key is not null");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyEqualTo(String value) {
            addCriterion("plat_public_key =", value, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyNotEqualTo(String value) {
            addCriterion("plat_public_key <>", value, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyGreaterThan(String value) {
            addCriterion("plat_public_key >", value, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("plat_public_key >=", value, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyLessThan(String value) {
            addCriterion("plat_public_key <", value, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("plat_public_key <=", value, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyLike(String value) {
            addCriterion("plat_public_key like", value, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyNotLike(String value) {
            addCriterion("plat_public_key not like", value, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyIn(List<String> values) {
            addCriterion("plat_public_key in", values, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyNotIn(List<String> values) {
            addCriterion("plat_public_key not in", values, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyBetween(String value1, String value2) {
            addCriterion("plat_public_key between", value1, value2, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyNotBetween(String value1, String value2) {
            addCriterion("plat_public_key not between", value1, value2, "platPublicKey");
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