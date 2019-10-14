package com.creditease.service;

import com.alibaba.fastjson.JSONObject;
import com.creditease.mybatis.pojo.TestResult;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2019/7/16.
 */
public interface TestResultService {

    /**
     * 往test_result表里插入数据
     * @param testResult
     */
    public void insertTestResult(TestResult testResult) throws IOException;

    /**
     * Map  存储请求的组装参数;请求的响应结果;响应结果中的status
     * @return
     * @throws IOException
     */

    public Map<String,List<String>> getParamsAndResults() throws IOException;


    public JSONObject getReqParams(String caseParam, String merchId, String serviceId);

    public void saveCases(String sysFlg,String sysEnv);


}
