package com.creditease.mybatis.pojo;

public class SysInfoKey {
    private String systemFlag;

    private String systemEnv;

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
}