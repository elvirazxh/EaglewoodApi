package com.creditease.controller;

/**
 * Created by admin on 2019/8/28.
 */

import com.alibaba.fastjson.JSONArray;
import com.creditease.mybatis.dao.MerchInfoMapper;
import com.creditease.mybatis.dao.SysInfoMapper;
import com.creditease.mybatis.dao.TestCaseMapper;
import com.creditease.mybatis.dao.TestResultMapper;
import com.creditease.mybatis.pojo.*;
import com.creditease.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zxh
 * @createTime 2019/8/28 10:29
 * @description
 */

@RestController
@CrossOrigin
public class CaseController {

    @Autowired
    private TestCaseMapper testCaseMapper;

    @Autowired
    private SysInfoMapper sysInfoMapper;

    @Autowired
    private MerchInfoMapper merchInfoMapper;

    @Autowired
    private TestResultMapper testResultMapper;


    //根据参数查询测试用来信息

    @ResponseBody
    @RequestMapping(value = "/showCaseByParam",method = RequestMethod.POST)
    public List<TestCase> showCaseByParam(@RequestBody String sysFlag,
                                          @RequestBody String sysEnv,
                                          @RequestBody String merchId,
                                          @RequestBody String serviceId,
                                          @RequestBody String status,
                                          @RequestBody String txnType,
                                          @RequestBody String pmtType,
                                          HttpServletRequest request){
        sysFlag = request.getParameter("sysFlag");
        sysEnv = request.getParameter("sysEnv");
        merchId = request.getParameter("merchId");
        serviceId = request.getParameter("serviceId");
        status = request.getParameter("status");
        txnType = request.getParameter("txnType");
        pmtType = request.getParameter("pmtType");
        return testCaseMapper.selectCaseBy(sysFlag,sysEnv,merchId,serviceId,status,txnType,pmtType);
    }


    @ResponseBody
    @RequestMapping(value = "/showSysFlag",method = RequestMethod.POST)
    public List<String> showSysFlag(@RequestBody Map map){
        SysInfoExample sysInfoExample = new SysInfoExample();
        sysInfoExample.createCriteria().andSystemFlagIsNotNull();
        List<SysInfo> sysInfoList = sysInfoMapper.selectByExample(sysInfoExample);
        List<String> sysFlagList = new ArrayList<>();
        for(SysInfo sysInfo:sysInfoList){
            if(!sysFlagList.contains(sysInfo.getSystemFlag())){
                sysFlagList.add(sysInfo.getSystemFlag());

            }
        }

        return sysFlagList;

    }

    @ResponseBody
    @RequestMapping(value = "/showSysEnv",method = RequestMethod.POST)
    public List<String> showSysEnv(){
        SysInfoExample sysInfoExample = new SysInfoExample();
        sysInfoExample.createCriteria().andSystemEnvIsNotNull();
        List<SysInfo> sysInfos = sysInfoMapper.selectByExample(sysInfoExample);
        List<String> sysEnvList = new ArrayList<>();
        for(SysInfo sysInfo:sysInfos){
            if(!sysEnvList.contains(sysInfo.getSystemEnv())){
                sysEnvList.add(sysInfo.getSystemEnv());

            }
        }
        return sysEnvList;
    }
    @ResponseBody
    @RequestMapping(value = "/showServiceId",method = RequestMethod.POST)
    public List<String> showServiceId(){
        TestCaseExample testCaseExample = new TestCaseExample();
        testCaseExample.createCriteria().andServiceIdIsNotNull();
        List<TestCase> testCaseList = testCaseMapper.selectByExample(testCaseExample);
        List<String> serviceIdList = new ArrayList<>();
        for(TestCase testCase:testCaseList){
            if(!serviceIdList.contains(testCase.getServiceId())){
                serviceIdList.add(testCase.getServiceId());
            }
        }
        return serviceIdList;
    }



    @ResponseBody
    @RequestMapping(value = "/showMerchId",method = RequestMethod.POST)
    public List<String> showMerchId(){
        MerchInfoExample merchInfoExample = new MerchInfoExample();
        merchInfoExample.createCriteria().andMerchidIsNotNull();
        List<MerchInfo> merchInfos = merchInfoMapper.selectByExample(merchInfoExample);
        List<String> merchIdList = new ArrayList<>();
        for (MerchInfo merchInfo:merchInfos){
            if(!merchIdList.contains(merchInfo.getMerchid())){
                merchIdList.add(merchInfo.getMerchid());
            }
        }
        return merchIdList;
    }

    @ResponseBody
    @RequestMapping(value = "/showTxnType",method = RequestMethod.POST)
    public List<String>showTxnType(){
        TestCaseExample testCaseExample = new TestCaseExample();
        testCaseExample.createCriteria().andTxnTypeIsNotNull();
        List<TestCase> testCaseList = testCaseMapper.selectByExample(testCaseExample);
        List<String> txnTypeList = new ArrayList<>();
        for(TestCase testCase: testCaseList){
            if(!txnTypeList.contains(testCase.getTxnType())){
                txnTypeList.add(testCase.getTxnType());
            }
        }
        return txnTypeList;
    }


    @ResponseBody
    @RequestMapping(value = "/showPmtType",method = RequestMethod.POST)
    public List<String>showPmtType(){
        TestCaseExample testCaseExample = new TestCaseExample();
        testCaseExample.createCriteria().andPmtTypeIsNotNull();
        List<TestCase> testCaseList = testCaseMapper.selectByExample(testCaseExample);
        List<String> pmtTypeList = new ArrayList<>();
        for(TestCase testCase: testCaseList){
            if(!pmtTypeList.contains(testCase.getPmtType())){
                pmtTypeList.add(testCase.getPmtType());
            }
        }
        return pmtTypeList;
    }

//    增加测试用例
    @ResponseBody
    @RequestMapping(value = "/insertCase",method = RequestMethod.POST)
    public String insertCase(HttpServletRequest request,@RequestBody Map map){

        TestCase testCase = new TestCase();
        testCase.setSystemFlag((String) map.get("sysFlag"));
        testCase.setSystemEnv((String) map.get("sysEnv"));
        testCase.setMerchId((String) map.get("merchId"));
        testCase.setServiceId((String) map.get("serviceId"));
        testCase.setTxnType((String) map.get("txnType"));
        testCase.setPmtType((String) map.get("pmtType"));
        testCase.setBizType((String) map.get("bizType"));
        testCase.setReqParams((String) map.get("reqParams"));
        testCase.setExpect((String) map.get("expect"));
        testCase.setStatus((String) map.get("status"));
        testCase.setExtend((String) map.get("extend"));

        int num = testCaseMapper.insert(testCase);
        if (num !=0){
            System.out.println("新增成功");
            return "success";
        }else {
            System.out.println("新增失败");
            return "add error";
        }
    }

    //修改测试用例
    @ResponseBody
    @RequestMapping(value = "/updateCase",method = RequestMethod.POST)
    public String updateCase(HttpServletRequest request,@RequestBody Map map){

        TestCase testCaseUpdate = testCaseMapper.selectByPrimaryKey((Integer) map.get("caseId"));
        testCaseUpdate.setSystemFlag((String) map.get("sysFlag"));
        testCaseUpdate.setSystemEnv((String) map.get("sysEnv"));
        testCaseUpdate.setMerchId((String) map.get("merchId"));
        testCaseUpdate.setServiceId((String) map.get("serviceId"));
        testCaseUpdate.setTxnType((String) map.get("txnType"));
        testCaseUpdate.setPmtType((String) map.get("pmtType"));
        testCaseUpdate.setBizType((String) map.get("bizType"));
        testCaseUpdate.setReqParams((String) map.get("reqParams"));
        testCaseUpdate.setExpect((String) map.get("expect"));
        testCaseUpdate.setStatus((String) map.get("status"));
        testCaseUpdate.setExtend((String) map.get("extend"));

        int num = testCaseMapper.updateByPrimaryKey(testCaseUpdate);
        if (num !=0){
            System.out.println("修改成功");
            return "success";
        }else {
            System.out.println("修改失败");
            return "update error";
        }
    }



//  批量删除测试用例
    @ResponseBody
    @RequestMapping(value = "/deleteCase",method = RequestMethod.POST)
    public String deleteCase(HttpServletRequest request
                             ,@RequestBody Map map){

        System.out.println(map.get("caseIds"));
        JSONArray arrObj = JSONArray.parseArray((String) map.get("caseIds"));
        List<Integer> castIdList =  arrObj.toJavaList(Integer.class);
        int number = testCaseMapper.batchDeleteCase(castIdList);
        if (number !=0){
            System.out.println("删除成功");
            return "success";
        }else {
            System.out.println("删除失败");
            return "error";
        }
    }
    //批量删除测试结果记录
    @ResponseBody
    @RequestMapping(value = "/deleteTestResult",method = RequestMethod.POST)
    public String deleteTestResult(HttpServletRequest request
            ,@RequestBody Map map){
        System.out.println(map.get("resultIds"));
        JSONArray arrObj = JSONArray.parseArray((String) map.get("resultIds"));
        List<Integer> resultIdList =  arrObj.toJavaList(Integer.class);
        int count = testResultMapper.batchDeleteRecord(resultIdList);
        if (count !=0){
            System.out.println("删除记录成功");
            return "success";
        }else {
            System.out.println("删除记录失败");
            return "error";
        }
    }


    @ResponseBody
    @RequestMapping(value = "/getCaseById",method = RequestMethod.POST)
    public TestCase getCaseById(HttpServletRequest request,
                                @RequestBody Map map){

        System.out.println(map.get("caseIdForUpdate"));
        Integer caseId = (Integer) map.get("caseIdForUpdate");
        return testCaseMapper.selectByPrimaryKey(caseId);
    }



    //根据参数查询用例执行信息
    @ResponseBody
    @RequestMapping(value = "/showTestResultByParam",method = RequestMethod.POST)
    public List<TestResult> showTestResultByParam(@RequestBody String sysFlag,
                                                  @RequestBody String sysEnv,
                                                  @RequestBody String merchId,
                                                  @RequestBody String serviceId,
                                                  @RequestBody String isPass,
                                                  @RequestBody String startDate,
                                                  @RequestBody String endDate,
                                                  HttpServletRequest request)  {

        List<TestResult>  testResultList= new ArrayList<>();

        sysFlag = request.getParameter("sysFlag");
        sysEnv = request.getParameter("sysEnv");
        merchId = request.getParameter("merchId");
        serviceId = request.getParameter("serviceId");
        isPass = request.getParameter("isPass");
        startDate = request.getParameter("startDate");
        endDate = request.getParameter("endDate");
        try {
            Date startDateObj =  DateUtils.strParseDate(startDate,"yyyy-MM-dd HH:mm:ss");
            Date endDateObj =  DateUtils.strParseDate(endDate,"yyyy-MM-dd HH:mm:ss");
            testResultList = testResultMapper.selectTestResultByParam(sysFlag,sysEnv,merchId,serviceId,isPass,startDateObj,endDateObj);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return testResultList;

    }



}
 
    