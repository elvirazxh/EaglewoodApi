package com.creditease.quartz;


import com.creditease.service.impl.TestResultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseJob {

//    public String getSysFlg() {
//        return sysFlg;
//    }
//
//    public void setSysFlg(String sysFlg) {
//        this.sysFlg = sysFlg;
//    }
//
//    public String getSysEnv() {
//        return sysEnv;
//    }
//
//    public void setSysEnv(String sysEnv) {
//        this.sysEnv = sysEnv;
//    }
//
//    private String sysFlg;
//    private String sysEnv;


    @Autowired
    private TestResultServiceImpl testResultServiceImpl;

    private void runJob(String sysFlg,String sysEnv){
        testResultServiceImpl.saveCases(sysFlg,sysEnv);

    }




//    public abstract void runJob(String sysFlg,String sysEnv) throws Exception;

    public void autoExecute() throws Exception {
        System.out.println("启动---------");

    }










}


