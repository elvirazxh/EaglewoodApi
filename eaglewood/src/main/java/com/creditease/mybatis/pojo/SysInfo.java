package com.creditease.mybatis.pojo;

public class SysInfo {
    private String systemFlag;

    private String systemEnv;

    private String requestUrl;

    private String platPublicKey;

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

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl == null ? null : requestUrl.trim();
    }

    public String getPlatPublicKey() {
        return platPublicKey;
    }

    public void setPlatPublicKey(String platPublicKey) {
        this.platPublicKey = platPublicKey == null ? null : platPublicKey.trim();
    }
}