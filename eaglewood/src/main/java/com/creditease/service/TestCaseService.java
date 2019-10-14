package com.creditease.service;

import com.creditease.mybatis.pojo.TestCase;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2019/7/16.
 */

public interface TestCaseService {

    public List<TestCase> getAllCase() throws IOException;


//    public List<TestCase> queryCaseByParam(String sysFlag,String sysEnv,String serviceId);





   
}
