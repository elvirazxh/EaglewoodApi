package com.creditease.mybatis.pojo;

public class QuartzInfo {
    private String systemFlag;

    private String systemEnv;

    private String serviceId;

    private String cronExpress;

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

    public String getCronExpress() {
        return cronExpress;
    }

    public void setCronExpress(String cronExpress) {
        this.cronExpress = cronExpress == null ? null : cronExpress.trim();
    }
}