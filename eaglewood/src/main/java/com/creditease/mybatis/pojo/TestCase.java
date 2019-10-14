package com.creditease.mybatis.pojo;

public class TestCase {
    private Integer id;

    private String systemFlag;

    private String systemEnv;

    private String serviceId;

    private String merchId;

    private String txnType;

    private String bizType;

    private String pmtType;

    private String reqParams;

    private String expect;

    private String status;

    private String extend;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSystemFlag() {
        return systemFlag;
    }

    public void setSystemFlag(String systemFlag) {
        this.systemFlag = systemFlag == null ? null : systemFlag.trim();
    }

    public String getSystemEnv() {
        return systemEnv;
    }

    public void setSystemEnv(String systemEnv) {
        this.systemEnv = systemEnv == null ? null : systemEnv.trim();
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public String getMerchId() {
        return merchId;
    }

    public void setMerchId(String merchId) {
        this.merchId = merchId == null ? null : merchId.trim();
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType == null ? null : txnType.trim();
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public String getPmtType() {
        return pmtType;
    }

    public void setPmtType(String pmtType) {
        this.pmtType = pmtType == null ? null : pmtType.trim();
    }

    public String getReqParams() {
        return reqParams;
    }

    public void setReqParams(String reqParams) {
        this.reqParams = reqParams == null ? null : reqParams.trim();
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect == null ? null : expect.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }
}