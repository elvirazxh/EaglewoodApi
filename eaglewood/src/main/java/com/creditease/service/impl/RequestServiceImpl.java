package com.creditease.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.creditease.mybatis.dao.MerchInfoMapper;
import com.creditease.mybatis.dao.SysInfoMapper;
import com.creditease.mybatis.dao.TestCaseMapper;
import com.creditease.mybatis.dao.TestResultMapper;
import com.creditease.mybatis.pojo.*;
import com.creditease.service.RequestService;
import com.creditease.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @description 沉香发起请求的服务
 * @Author
 * @Date 2019-07-23 10:39
 **/

@Service
public class RequestServiceImpl implements RequestService {

    private static Logger logger = LoggerFactory.getLogger(RequestServiceImpl.class);

    @Autowired
    private SysInfoMapper sysInfoMapper;
    @Autowired
    private TestCaseMapper testCaseMapper;
    @Autowired
    private MerchInfoMapper merchInfoMapper;
    @Autowired
    private TestResultMapper testResultMapper;

    @Override
    public void request(String system, String env) {

        // 获取系统信息
        SysInfoExample sysInfoExample = new SysInfoExample();
        sysInfoExample.createCriteria().andSystemFlagEqualTo(system).andSystemEnvEqualTo(env);
        List<SysInfo> sysInfoList = sysInfoMapper.selectByExample(sysInfoExample);
        if (sysInfoList.size() == 0) {
            throw new RuntimeException("获取系统参数失败！");
        }
        SysInfo sysInfo = sysInfoList.get(0);

        //根据参数系统、环境获取用例list
        TestCaseExample testCaseExample = new TestCaseExample();
        testCaseExample.createCriteria().andSystemFlagEqualTo(system).andSystemEnvEqualTo(env).andStatusEqualTo("1");
        logger.info("testCaseMapper:" + testCaseMapper);
        List<TestCase> caseList = testCaseMapper.selectByExample(testCaseExample);
        if (caseList.size() == 0) {
            throw new RuntimeException("获取的用例集为空，请检查！");
        }
        //组装请求参数，
        for (TestCase testCase : caseList) {
            JSONObject req = getReqParam(testCase.getReqParams(), testCase.getServiceId(), testCase.getMerchId());
            String result = HttpClientUtil.post(sysInfo.getRequestUrl(), req, 15*1000);
            if (result == null) {
                logger.info("获取的请求结果为空！");
            }


            //获取响应结果，判断是否通过，并将结果入库
            String isPass = "false";
            List<String> expectList = Arrays.asList(testCase.getExpect().split(","));

            JSONObject resp = JSONObject.parseObject(result);
            JSONObject data = JSONObject.parseObject(resp.getString("data"));
            String status = (data.getString("status") == null) ? "03" : data.getString("status");
            if (expectList.contains(status)) {
                isPass = "true";
            }

            TestResult testResult = new TestResult();
            testResult.setSystemEnv(testCase.getSystemEnv());
            testResult.setMerchId(testCase.getMerchId());
            testResult.setServiceId(testCase.getServiceId());
            testResult.setReqBody(req.toJSONString());
            testResult.setCreateTime(new Date());
            testResult.setResult(result);
            testResult.setIspass(isPass);
            testResultMapper.insert(testResult);

        }

    }

    private JSONObject getReqParam(String reqParam, String serviceId, String merchId) {
        try {
            //获取商户及私钥
            MerchInfoExample example = new MerchInfoExample();
            example.createCriteria().andMerchidEqualTo(merchId);
            List<MerchInfo> merchInfoList = merchInfoMapper.selectByExample(example);
            if (merchInfoList.size() == 0) {
                throw new RuntimeException("获取商户信息失败！");
            }
            MerchInfo merchInfo = merchInfoList.get(0);

            //组装data
            JSONObject data = JSONObject.parseObject(reqParam);
            data.put("orderId", "EA" + UUidUtils.formatUuid());

            //组装整体请求参数
            String seqNo = "seqNo" + DateUtils.date2Str(new Date(), "yyyyMMddHHmmss");
            JSONObject request = new JSONObject();
            request.put("versionNo", "2.00");
            request.put("serviceId", serviceId);
            request.put("merchId", merchId);
            request.put("signType", "rsa");
            request.put("sign", RSAUtil.sign(seqNo + data.toJSONString(), merchInfo.getPrivateKey()));
            request.put("timestamp", DateUtils.date2Str(new Date(), "yyyyMMddHHmmss"));
            request.put("seqNo", seqNo);
            request.put("data", data.toJSONString());

            return request;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
