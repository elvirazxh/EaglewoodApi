package com.creditease.service.impl;/**
 * Created by admin on 2019/7/29.
 */

import com.alibaba.fastjson.JSONObject;
import com.creditease.mail.EmailUtil;
import com.creditease.mybatis.dao.MailInfoMapper;
import com.creditease.mybatis.dao.TestResultMapper;
import com.creditease.mybatis.pojo.MailInfo;
import com.creditease.mybatis.pojo.MailInfoExample;
import com.creditease.mybatis.pojo.TestResult;
import com.creditease.mybatis.pojo.TestResultExample;
import com.creditease.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author
 * @createTime 2019/7/29 00:06
 * @description
 */

@Service
public class MailInfoServiceImpl {

    @Autowired
    EmailUtil emailUtil;

    @Autowired
    private MailInfoMapper mailMapper;

    @Autowired
    TestResultMapper testResultMapper;

    //汇总用例执行情况
    public Map<String,String> sumData(String sysFlag, String sysEnv, Date startDate, Date endDate){
        //test_result数据汇总  执行时间,执行用例总数,用例失败数
        Map<String,String> sumDataMap = new HashMap<>();
        int totalNum = testResultMapper.sumResult(sysFlag,sysEnv,startDate,endDate);
        int failureNUm = testResultMapper.failCaseNum(sysFlag,sysEnv,startDate,endDate,"false");
        String exceuteDate = DateUtils.date2Str(startDate,DateUtils.Pattern.yyyyMMddHHmmssSSS)  + "~" + DateUtils.date2Str(endDate,DateUtils.Pattern.yyyyMMddHHmmssSSS);

        sumDataMap.put("exceuteDate",exceuteDate);
        sumDataMap.put("sysEnv",sysEnv);
        sumDataMap.put("sysFlag",sysFlag);
        sumDataMap.put("totalNum",String.valueOf(totalNum));
        sumDataMap.put("failureNUm",String.valueOf(failureNUm));

        return sumDataMap;
    }

    //获取邮件接收者
    public String[] getEmailReceivers(){
        MailInfoExample mailInfoExample = new MailInfoExample();
        mailInfoExample.createCriteria().andStatusEqualTo("1");
        List<MailInfo> mailInfoList = mailMapper.selectByExample(mailInfoExample);
        List<String> receivers = new ArrayList<>();
        for(int i=0;i <mailInfoList.size();i++){
            receivers.add(mailInfoList.get(i).getMailAddress());
        }
        return receivers.toArray(new String[receivers.size()]);
    }

       //获取邮件正文表格内容
    public List<Map<String,Object>> emailAppendContent(String sysFlag, String sysEnv, Date startDate, Date endDate){
        List<TestResult> failResultList = testResultMapper.failResult(sysFlag,sysEnv,startDate,endDate);
        System.out.println(failResultList.size());
        List<Map<String,Object>> resultMapList = new ArrayList<>();

        if(failResultList.size()>0){
            for(TestResult failResult:failResultList){
                Map<String,Object> failMap = new HashMap<>();
                failMap.put("sysEnv",failResult.getSystemEnv());
                failMap.put("ServiceId",failResult.getServiceId());
                failMap.put("MerchId",failResult.getMerchId());
                JSONObject jsonObject = JSONObject.parseObject(failResult.getReqBody());
                JSONObject jsonData = JSONObject.parseObject((String) jsonObject.get("data"));
                failMap.put("OrderId",jsonData.get("orderId"));
                failMap.put("isPass",failResult.getIspass());

                resultMapList.add(failMap);
            }
        }

        return resultMapList;
    }



    //获取邮件正文表格内容,map的key是无顺序的,避免无序显示 ,按邮件标题顺序显示
    public List<List<String>> emailAppendContents(String sysFlag, String sysEnv, Date startDate, Date endDate){
        List<TestResult> failResultList = testResultMapper.failResult(sysFlag,sysEnv,startDate,endDate);
        List<List<String>>  resultMapList = new ArrayList<>();

        if(failResultList.size()>0){
            for(TestResult failResult:failResultList){
//                Map<String,Object> failMap = new HashMap<>();
                List<String> failObj = new ArrayList<>();
                failObj.add(0,failResult.getSystemEnv());
                failObj.add(1,failResult.getServiceId());
                failObj.add(2,failResult.getMerchId());
                JSONObject jsonObject = JSONObject.parseObject(failResult.getReqBody());
                JSONObject jsonData = JSONObject.parseObject((String) jsonObject.get("data"));
                failObj.add(3,jsonData.get("orderId").toString());
                failObj.add(4,failResult.getIspass());

                resultMapList.add(failObj);
            }
        }

        return resultMapList;
    }


    public void initSendEmail(String sysFlag, String sysEnv, Date startDate, Date endDate){
        String[] receivers = getEmailReceivers();
        Map<String,String> sumData = sumData(sysFlag, sysEnv, startDate, endDate);
        List<List<String>> appendContents = emailAppendContents(sysFlag, sysEnv, startDate, endDate);
        String content = emailUtil.buildHtmlContent(sumData, appendContents);
        emailUtil.sendMail(receivers, "测试用例执行汇总信息", content);

    }



}
 
    