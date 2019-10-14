package com.creditease.mybatis.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestResultExample() {
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

        public Criteria andMerchIdIsNull() {
            addCriterion("merch_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchIdIsNotNull() {
            addCriterion("merch_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchIdEqualTo(String value) {
            addCriterion("merch_id =", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotEqualTo(String value) {
            addCriterion("merch_id <>", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdGreaterThan(String value) {
            addCriterion("merch_id >", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdGreaterThanOrEqualTo(String value) {
            addCriterion("merch_id >=", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdLessThan(String value) {
            addCriterion("merch_id <", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdLessThanOrEqualTo(String value) {
            addCriterion("merch_id <=", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdLike(String value) {
            addCriterion("merch_id like", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotLike(String value) {
            addCriterion("merch_id not like", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdIn(List<String> values) {
            addCriterion("merch_id in", values, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotIn(List<String> values) {
            addCriterion("merch_id not in", values, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdBetween(String value1, String value2) {
            addCriterion("merch_id between", value1, value2, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotBetween(String value1, String value2) {
            addCriterion("merch_id not between", value1, value2, "merchId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNull() {
            addCriterion("service_Id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("service_Id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(String value) {
            addCriterion("service_Id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(String value) {
            addCriterion("service_Id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(String value) {
            addCriterion("service_Id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(String value) {
            addCriterion("service_Id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(String value) {
            addCriterion("service_Id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(String value) {
            addCriterion("service_Id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLike(String value) {
            addCriterion("service_Id like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotLike(String value) {
            addCriterion("service_Id not like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<String> values) {
            addCriterion("service_Id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<String> values) {
            addCriterion("service_Id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(String value1, String value2) {
            addCriterion("service_Id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(String value1, String value2) {
            addCriterion("service_Id not between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andReqBodyIsNull() {
            addCriterion("req_body is null");
            return (Criteria) this;
        }

        public Criteria andReqBodyIsNotNull() {
            addCriterion("req_body is not null");
            return (Criteria) this;
        }

        public Criteria andReqBodyEqualTo(String value) {
            addCriterion("req_body =", value, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyNotEqualTo(String value) {
            addCriterion("req_body <>", value, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyGreaterThan(String value) {
            addCriterion("req_body >", value, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyGreaterThanOrEqualTo(String value) {
            addCriterion("req_body >=", value, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyLessThan(String value) {
            addCriterion("req_body <", value, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyLessThanOrEqualTo(String value) {
            addCriterion("req_body <=", value, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyLike(String value) {
            addCriterion("req_body like", value, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyNotLike(String value) {
            addCriterion("req_body not like", value, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyIn(List<String> values) {
            addCriterion("req_body in", values, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyNotIn(List<String> values) {
            addCriterion("req_body not in", values, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyBetween(String value1, String value2) {
            addCriterion("req_body between", value1, value2, "reqBody");
            return (Criteria) this;
        }

        public Criteria andReqBodyNotBetween(String value1, String value2) {
            addCriterion("req_body not between", value1, value2, "reqBody");
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

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andIspassIsNull() {
            addCriterion("isPass is null");
            return (Criteria) this;
        }

        public Criteria andIspassIsNotNull() {
            addCriterion("isPass is not null");
            return (Criteria) this;
        }

        public Criteria andIspassEqualTo(String value) {
            addCriterion("isPass =", value, "ispass");
            return (Criteria) this;
        }

        public Criteria andIspassNotEqualTo(String value) {
            addCriterion("isPass <>", value, "ispass");
            return (Criteria) this;
        }

        public Criteria andIspassGreaterThan(String value) {
            addCriterion("isPass >", value, "ispass");
            return (Criteria) this;
        }

        public Criteria andIspassGreaterThanOrEqualTo(String value) {
            addCriterion("isPass >=", value, "ispass");
            return (Criteria) this;
        }

        public Criteria andIspassLessThan(String value) {
            addCriterion("isPass <", value, "ispass");
            return (Criteria) this;
        }

        public Criteria andIspassLessThanOrEqualTo(String value) {
            addCriterion("isPass <=", value, "ispass");
            return (Criteria) this;
        }

        public Criteria andIspassLike(String value) {
            addCriterion("isPass like", value, "ispass");
            return (Criteria) this;
        }

        public Criteria andIspassNotLike(String value) {
            addCriterion("isPass not like", value, "ispass");
            return (Criteria) this;
        }

        public Criteria andIspassIn(List<String> values) {
            addCriterion("isPass in", values, "ispass");
            return (Criteria) this;
        }

        public Criteria andIspassNotIn(List<String> values) {
            addCriterion("isPass not in", values, "ispass");
            return (Criteria) this;
        }

        public Criteria andIspassBetween(String value1, String value2) {
            addCriterion("isPass between", value1, value2, "ispass");
            return (Criteria) this;
        }

        public Criteria andIspassNotBetween(String value1, String value2) {
            addCriterion("isPass not between", value1, value2, "ispass");
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