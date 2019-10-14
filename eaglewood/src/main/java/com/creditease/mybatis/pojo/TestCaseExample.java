package com.creditease.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class TestCaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestCaseExample() {
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

        public Criteria andTxnTypeIsNull() {
            addCriterion("txn_type is null");
            return (Criteria) this;
        }

        public Criteria andTxnTypeIsNotNull() {
            addCriterion("txn_type is not null");
            return (Criteria) this;
        }

        public Criteria andTxnTypeEqualTo(String value) {
            addCriterion("txn_type =", value, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeNotEqualTo(String value) {
            addCriterion("txn_type <>", value, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeGreaterThan(String value) {
            addCriterion("txn_type >", value, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeGreaterThanOrEqualTo(String value) {
            addCriterion("txn_type >=", value, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeLessThan(String value) {
            addCriterion("txn_type <", value, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeLessThanOrEqualTo(String value) {
            addCriterion("txn_type <=", value, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeLike(String value) {
            addCriterion("txn_type like", value, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeNotLike(String value) {
            addCriterion("txn_type not like", value, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeIn(List<String> values) {
            addCriterion("txn_type in", values, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeNotIn(List<String> values) {
            addCriterion("txn_type not in", values, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeBetween(String value1, String value2) {
            addCriterion("txn_type between", value1, value2, "txnType");
            return (Criteria) this;
        }

        public Criteria andTxnTypeNotBetween(String value1, String value2) {
            addCriterion("txn_type not between", value1, value2, "txnType");
            return (Criteria) this;
        }

        public Criteria andBizTypeIsNull() {
            addCriterion("biz_type is null");
            return (Criteria) this;
        }

        public Criteria andBizTypeIsNotNull() {
            addCriterion("biz_type is not null");
            return (Criteria) this;
        }

        public Criteria andBizTypeEqualTo(String value) {
            addCriterion("biz_type =", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotEqualTo(String value) {
            addCriterion("biz_type <>", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeGreaterThan(String value) {
            addCriterion("biz_type >", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeGreaterThanOrEqualTo(String value) {
            addCriterion("biz_type >=", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLessThan(String value) {
            addCriterion("biz_type <", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLessThanOrEqualTo(String value) {
            addCriterion("biz_type <=", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLike(String value) {
            addCriterion("biz_type like", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotLike(String value) {
            addCriterion("biz_type not like", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeIn(List<String> values) {
            addCriterion("biz_type in", values, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotIn(List<String> values) {
            addCriterion("biz_type not in", values, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeBetween(String value1, String value2) {
            addCriterion("biz_type between", value1, value2, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotBetween(String value1, String value2) {
            addCriterion("biz_type not between", value1, value2, "bizType");
            return (Criteria) this;
        }

        public Criteria andPmtTypeIsNull() {
            addCriterion("pmt_type is null");
            return (Criteria) this;
        }

        public Criteria andPmtTypeIsNotNull() {
            addCriterion("pmt_type is not null");
            return (Criteria) this;
        }

        public Criteria andPmtTypeEqualTo(String value) {
            addCriterion("pmt_type =", value, "pmtType");
            return (Criteria) this;
        }

        public Criteria andPmtTypeNotEqualTo(String value) {
            addCriterion("pmt_type <>", value, "pmtType");
            return (Criteria) this;
        }

        public Criteria andPmtTypeGreaterThan(String value) {
            addCriterion("pmt_type >", value, "pmtType");
            return (Criteria) this;
        }

        public Criteria andPmtTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pmt_type >=", value, "pmtType");
            return (Criteria) this;
        }

        public Criteria andPmtTypeLessThan(String value) {
            addCriterion("pmt_type <", value, "pmtType");
            return (Criteria) this;
        }

        public Criteria andPmtTypeLessThanOrEqualTo(String value) {
            addCriterion("pmt_type <=", value, "pmtType");
            return (Criteria) this;
        }

        public Criteria andPmtTypeLike(String value) {
            addCriterion("pmt_type like", value, "pmtType");
            return (Criteria) this;
        }

        public Criteria andPmtTypeNotLike(String value) {
            addCriterion("pmt_type not like", value, "pmtType");
            return (Criteria) this;
        }

        public Criteria andPmtTypeIn(List<String> values) {
            addCriterion("pmt_type in", values, "pmtType");
            return (Criteria) this;
        }

        public Criteria andPmtTypeNotIn(List<String> values) {
            addCriterion("pmt_type not in", values, "pmtType");
            return (Criteria) this;
        }

        public Criteria andPmtTypeBetween(String value1, String value2) {
            addCriterion("pmt_type between", value1, value2, "pmtType");
            return (Criteria) this;
        }

        public Criteria andPmtTypeNotBetween(String value1, String value2) {
            addCriterion("pmt_type not between", value1, value2, "pmtType");
            return (Criteria) this;
        }

        public Criteria andReqParamsIsNull() {
            addCriterion("req_Params is null");
            return (Criteria) this;
        }

        public Criteria andReqParamsIsNotNull() {
            addCriterion("req_Params is not null");
            return (Criteria) this;
        }

        public Criteria andReqParamsEqualTo(String value) {
            addCriterion("req_Params =", value, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsNotEqualTo(String value) {
            addCriterion("req_Params <>", value, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsGreaterThan(String value) {
            addCriterion("req_Params >", value, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsGreaterThanOrEqualTo(String value) {
            addCriterion("req_Params >=", value, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsLessThan(String value) {
            addCriterion("req_Params <", value, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsLessThanOrEqualTo(String value) {
            addCriterion("req_Params <=", value, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsLike(String value) {
            addCriterion("req_Params like", value, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsNotLike(String value) {
            addCriterion("req_Params not like", value, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsIn(List<String> values) {
            addCriterion("req_Params in", values, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsNotIn(List<String> values) {
            addCriterion("req_Params not in", values, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsBetween(String value1, String value2) {
            addCriterion("req_Params between", value1, value2, "reqParams");
            return (Criteria) this;
        }

        public Criteria andReqParamsNotBetween(String value1, String value2) {
            addCriterion("req_Params not between", value1, value2, "reqParams");
            return (Criteria) this;
        }

        public Criteria andExpectIsNull() {
            addCriterion("expect is null");
            return (Criteria) this;
        }

        public Criteria andExpectIsNotNull() {
            addCriterion("expect is not null");
            return (Criteria) this;
        }

        public Criteria andExpectEqualTo(String value) {
            addCriterion("expect =", value, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectNotEqualTo(String value) {
            addCriterion("expect <>", value, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectGreaterThan(String value) {
            addCriterion("expect >", value, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectGreaterThanOrEqualTo(String value) {
            addCriterion("expect >=", value, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectLessThan(String value) {
            addCriterion("expect <", value, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectLessThanOrEqualTo(String value) {
            addCriterion("expect <=", value, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectLike(String value) {
            addCriterion("expect like", value, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectNotLike(String value) {
            addCriterion("expect not like", value, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectIn(List<String> values) {
            addCriterion("expect in", values, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectNotIn(List<String> values) {
            addCriterion("expect not in", values, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectBetween(String value1, String value2) {
            addCriterion("expect between", value1, value2, "expect");
            return (Criteria) this;
        }

        public Criteria andExpectNotBetween(String value1, String value2) {
            addCriterion("expect not between", value1, value2, "expect");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andExtendIsNull() {
            addCriterion("extend is null");
            return (Criteria) this;
        }

        public Criteria andExtendIsNotNull() {
            addCriterion("extend is not null");
            return (Criteria) this;
        }

        public Criteria andExtendEqualTo(String value) {
            addCriterion("extend =", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotEqualTo(String value) {
            addCriterion("extend <>", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThan(String value) {
            addCriterion("extend >", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThanOrEqualTo(String value) {
            addCriterion("extend >=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThan(String value) {
            addCriterion("extend <", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThanOrEqualTo(String value) {
            addCriterion("extend <=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLike(String value) {
            addCriterion("extend like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotLike(String value) {
            addCriterion("extend not like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendIn(List<String> values) {
            addCriterion("extend in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotIn(List<String> values) {
            addCriterion("extend not in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendBetween(String value1, String value2) {
            addCriterion("extend between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotBetween(String value1, String value2) {
            addCriterion("extend not between", value1, value2, "extend");
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