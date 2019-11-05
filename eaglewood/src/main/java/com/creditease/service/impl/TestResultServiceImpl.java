package com.creditease.service.impl;/**
 * Created by admin on 2019/7/16.
 */

import com.alibaba.fastjson.JSONObject;
import com.creditease.mybatis.dao.*;
import com.creditease.mybatis.pojo.*;

import com.creditease.service.MerchInfoService;
import com.creditease.service.SysInfoService;
import com.creditease.service.TestCaseService;
import com.creditease.service.TestResultService;
import com.creditease.utils.DatabaseUtil;
import com.creditease.utils.DateUtils;
import com.creditease.utils.HttpClientUtil;
import com.creditease.utils.RSAUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author
 * @createTime 2019/7/16 17:47
 * @description
 */
@Service
public class TestResultServiceImpl implements TestResultService {

    @Autowired
    private TestCaseService testCaseService;
    @Autowired
    private MerchInfoService merchInfoService;
    @Autowired
    private SysInfoService sysInfoService;

    @Autowired
    TestResultMapper testResultMapper;

    @Autowired
    private MerchInfoMapper merchInfoMapper;

    @Autowired
    private SysInfoMapper sysInfoMapper;

    @Autowired
    private TestCaseMapper testCaseMapper;


    @Autowired
    private MailInfoServiceImpl mailInfoServiceImpl;


    /**
     * 往test_result表里插入数据
     * @param testResult
     */
    @Override
    public void insertTestResult(TestResult testResult) throws IOException {
        testResultMapper.insert(testResult);
    }


    /**
     * Map  存储请求的组装参数;请求的响应结果;响应结果中的status
     * @return
     * @throws IOException
     */
    public Map<String,List<String>> getParamsAndResults() throws IOException {
        Map<String,List<String>> mapObj = new HashMap<>();
        List<String> requestParams = new ArrayList<>();
        List<String> responseResult = new ArrayList<>();
        List<String> respStatus = new ArrayList<>();
        List<TestCase> allCase = testCaseService.getAllCase();
        String caseParam = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();


        if(allCase.isEmpty()){
             return null;
         }else{
              for(int i=0;i<allCase.size();i++){
                  //获取case中的参数
                  caseParam = allCase.get(i).getReqParams();
                  //生成订单号和seqNo
                  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmssS");
                  String orderId = "EA" + dateFormat.format(Calendar.getInstance().getTime());
                  String seqNo = "SeqNo" + dateFormat.format(Calendar.getInstance().getTime());
                  //生成timestamp
                  SimpleDateFormat timesFormat = new SimpleDateFormat("yyyyMMddhhmmss");
                  String times = timesFormat.format(Calendar.getInstance().getTime());

                  JSONObject caseParamObj = JSONObject.parseObject(caseParam);
                  caseParamObj.put("orderId",orderId);

                  //签名
                  String content = seqNo + caseParamObj.toJSONString();
                  //组装请求公共参数
                  JSONObject newObj = new JSONObject();
                  newObj.put("versionNo", "2.00");
                  newObj.put("serviceId", allCase.get(i).getServiceId());
                  newObj.put("merchId", allCase.get(i).getMerchId());
                  newObj.put("signType","RSA" );
                  //获取私钥
                  try {
                      if(!allCase.get(i).getSystemEnv().isEmpty() && !allCase.get(i).getMerchId().isEmpty()){
                          newObj.put("sign", RSAUtil.sign(content,merchInfoService.getPrivateKey(allCase.get(i).getSystemEnv(),allCase.get(i).getMerchId())));
                      }
                  } catch (Exception e) {
                      e.printStackTrace();
                  }
                  newObj.put("timestamp", times);
                  newObj.put("seqNo", seqNo);
                  newObj.put("data", caseParamObj.toJSONString());
                  //组装好了新的参数
                  requestParams.add(i,newObj.toJSONString());

                  //请求的URL
                  HttpPost post = new HttpPost(sysInfoService.getRequesetUrl(allCase.get(i).getSystemEnv(),allCase.get(i).getSystemFlag()));
                  //设置头信息
                  post.setHeader("content-type","application/json");
                  StringEntity entity = new StringEntity(requestParams.get(i),"utf-8");
                  post.setEntity(entity);

                  //执行post方法
                  HttpResponse response = null;
                  try {
                      response = httpClient.execute(post);
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
                  //获取响应结果
//                  //组装好了新的响应结果
                  responseResult.add(i, EntityUtils.toString(response.getEntity(),"utf-8"));


                  JSONObject resultObj = JSONObject.parseObject(responseResult.get(i)) ;
                  JSONObject resultData = JSONObject.parseObject((String) resultObj.get("data"));

                  //data为null时,请求已经出错
                  if(resultData!=null && !"null".equals(resultData)){
                      respStatus.add(i, String.valueOf(resultData.get("status")));
                  }else {
                      respStatus.add(i,"03");
                  }

                  mapObj.put("requestParams",requestParams);
                  mapObj.put("responseResult",responseResult);
                  mapObj.put("respStatus",respStatus);

              }
         }
        return mapObj;

    }

    @Override
    public JSONObject getReqParams(String caseParam, String merchId, String serviceId) {
        //获取对应merchId参数的商户及私钥
        MerchInfoExample example = new MerchInfoExample();
        example.createCriteria().andMerchidEqualTo(merchId);

        List<MerchInfo> merchInfoList = merchInfoMapper.selectByExample(example);
        if (merchInfoList.size() == 0) {
            throw new RuntimeException("获取商户信息失败！");
        }

        MerchInfo merchInfo = merchInfoList.get(0);//用于获取私钥
        //生成订单号和seqNo
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmssS");
        String orderId = "EA" + dateFormat.format(Calendar.getInstance().getTime());
        String seqNo = "SeqNo" + dateFormat.format(Calendar.getInstance().getTime());
        JSONObject data = JSONObject.parseObject(caseParam);
        data.put("orderId",orderId);

        JSONObject reqObj = new JSONObject();
        reqObj.put("versionNo", "2.00");
        reqObj.put("serviceId", serviceId);
        reqObj.put("merchId", merchId);
        reqObj.put("signType", "rsa");
        try {
            reqObj.put("sign", RSAUtil.sign(seqNo + data.toJSONString(), merchInfo.getPrivateKey()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        reqObj.put("timestamp", DateUtils.date2Str(new Date(), "yyyyMMddHHmmss"));
        reqObj.put("seqNo", seqNo);
        reqObj.put("data", data.toJSONString());

        return reqObj;
    }

    @Override
    public void saveCases(String sysFlg, String sysEnv) {
        Date runStart = new Date();
        SysInfoExample sysInfoExample = new SysInfoExample();
        //得到相匹配 参数sysFlg,sysEnv 对应的系统信息
        sysInfoExample.createCriteria().andSystemEnvEqualTo(sysEnv).andSystemFlagEqualTo(sysFlg);
        List<SysInfo> sysInfos = sysInfoMapper.selectByExample(sysInfoExample);
        if (sysInfos.size() == 0) {
            throw new RuntimeException("获取系统参数信息失败！");
        }

        SysInfo sysInfo = sysInfos.get(0);//得到系统参数信息用于获取请求URL

        //根据系统参数sysFlg, sysEnv,status=1 获取用例集
        TestCaseExample caseExample = new TestCaseExample();
        caseExample.createCriteria().andSystemEnvEqualTo(sysEnv).andSystemFlagEqualTo(sysFlg).andStatusEqualTo("1");
        List<TestCase> caseList = testCaseMapper.selectByExample(caseExample);
        if (caseList.size() == 0) {
            throw new RuntimeException("获取用例集为空,请检查用例信息");
        }

        String resultStr = "";
        for(TestCase testCase:caseList){
            //获取发送HTTP请求的 参数集合
            JSONObject reuestParams = getReqParams(testCase.getReqParams(),testCase.getMerchId(),testCase.getServiceId());
            resultStr = HttpClientUtil.post(sysInfo.getRequestUrl(),reuestParams,15*1000);
            JSONObject resultObj = JSONObject.parseObject(resultStr);
            JSONObject resultData = JSONObject.parseObject((String) resultObj.get("data"));

            String isPass = "false";
            //data为null时,请求已经出错   resultData==null && "null".equals(resultData) ||  resultData.getString("status") == "03"
            if(resultData==null && "null".equals(resultData)){
                isPass = "false";
            }
//            System.out.println(resultData.get("status"));

            if( resultData.get("status").equals("03")){
                isPass = "false";
            }else {
                isPass = "true";
            }

            TestResult testResult = new TestResult();
            testResult.setSystemFlag(testCase.getSystemFlag());
            testResult.setSystemEnv(testCase.getSystemEnv());
            testResult.setMerchId(testCase.getMerchId());
            testResult.setServiceId(testCase.getServiceId());
            testResult.setReqBody(reuestParams.toJSONString());
            testResult.setCreateTime(new Date());
            testResult.setResult(resultStr);
            testResult.setIspass(isPass);

//            System.out.println("------插入库start-------");
            testResultMapper.insert(testResult);
//            System.out.println("------插入库end -------");

        }

        long endTime = System.currentTimeMillis();

        String dateStr = DateUtils.getDateStr(endTime+20*1000,"yyyyMMddHHmmssSSS");
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        try {
            Date runEnd = sf.parse(dateStr);
            mailInfoServiceImpl.initSendEmail(sysFlg,sysEnv,runStart,runEnd);
        } catch (ParseException e) {
            e.printStackTrace();
        }





    }




}

