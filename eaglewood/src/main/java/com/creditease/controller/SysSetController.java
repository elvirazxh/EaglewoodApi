package com.creditease.controller;
/**
 * Created by admin on 2019/9/23.
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.creditease.mybatis.dao.MailInfoMapper;
import com.creditease.mybatis.dao.MerchInfoMapper;
import com.creditease.mybatis.dao.QuartzInfoMapper;
import com.creditease.mybatis.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zxh
 * @createTime 2019/9/23 15:47
 * @description
 */
@RestController
@CrossOrigin
public class SysSetController {

    @Autowired
    private MerchInfoMapper merchInfoMapper;

    @Autowired
    private QuartzInfoMapper quartzInfoMapper;

    @Autowired
    private MailInfoMapper mailInfoMapper;

    //根据参数查询用户信息
    @ResponseBody
    @RequestMapping(value = "/showUserByParam", method = RequestMethod.POST)
    public List<MerchInfo> showUserByParam(@RequestBody String sysFlag,
                                           @RequestBody String sysEnv,
                                           @RequestBody String serviceId,
                                           HttpServletRequest request) {
        sysFlag = request.getParameter("sysFlag");
        sysEnv = request.getParameter("sysEnv");
        serviceId = request.getParameter("serviceId");
        return merchInfoMapper.selectMerchByParam(sysFlag, sysEnv, serviceId);
    }

    @ResponseBody
    @RequestMapping(value = "/insertOrUpdateMerchInfo", method = RequestMethod.POST)
    public String insertOrUpdateMerchInfo(@RequestBody Map map) {
        MerchInfoExample merchInfoExample = new MerchInfoExample();
        merchInfoExample.createCriteria().andMerchidIsNotNull();
        List<MerchInfo> merchInfos = merchInfoMapper.selectByExample(merchInfoExample);
        List<String> merchIdList = new ArrayList<>();
        for (MerchInfo merchInfo:merchInfos){
            if(!merchIdList.contains(merchInfo.getMerchid())){
                merchIdList.add(merchInfo.getMerchid());
            }
        }

        if(map.get("userId") == null || map.get("userId") == ""){//新增
            if(!merchIdList.contains((String) map.get("merchId"))){
                MerchInfo merchInfo = new MerchInfo();
                merchInfo.setMerchid((String) map.get("merchId"));
                merchInfo.setSystemEnv((String) map.get("sysEnv"));
                merchInfo.setSystemFlag((String) map.get("sysFlag"));
                merchInfo.setPublicKey((String) map.get("publicKey"));
                merchInfo.setPrivateKey((String) map.get("privateKey"));
                merchInfo.setRemark((String) map.get("remark"));
                int count = merchInfoMapper.insert(merchInfo);
                if (count != 0) {
                    System.out.println("新增用户成功");
                    return "success";
                } else {
                    System.out.println("新增用户失败");
                    return "error";
                }

            }else{
                return "用户ID重复,新增用户失败";
            }
        }else{//修改
            MerchInfo updateInfo = merchInfoMapper.selectByPrimaryKey((Integer) map.get("userId"));
            List<String> removeMerchIdList = new ArrayList<>();
            for(String merchId: merchIdList){
                if(merchId.equals(map.get("userId"))){
                    removeMerchIdList.add(merchId);
                }
            }
            //去除要修改记录的merchId
            if(removeMerchIdList.size()>0){
                merchIdList.removeAll(removeMerchIdList);
            }
            if(!merchIdList.contains((String) map.get("merchId"))){
                updateInfo.setMerchid((String) map.get("merchId"));
                updateInfo.setSystemEnv((String) map.get("sysEnv"));
                updateInfo.setSystemFlag((String) map.get("sysFlag"));
                updateInfo.setPublicKey((String) map.get("publicKey"));
                updateInfo.setPrivateKey((String) map.get("privateKey"));
                updateInfo.setRemark((String) map.get("remark"));

                int num1 = merchInfoMapper.updateByPrimaryKey(updateInfo);

                if (num1 != 0) {
                    System.out.println("更新用户成功");
                    return "success";
                } else {
                    System.out.println("更新用户失败");
                    return "error";
                }
            }else{
                return "用户ID重复,更新用户失败";
            }
        }

    }

    @ResponseBody
    @RequestMapping(value = "/deleteMerchInfo", method = RequestMethod.POST)
    public String deleteMerchInfo(@RequestBody Map map) {
        JSONArray arrObj = JSONArray.parseArray((String) map.get("resultIds"));
        List<Integer> resultIdList =  arrObj.toJavaList(Integer.class);

        int num = merchInfoMapper.batchDeleteMerchInfo(resultIdList);
        if (num != 0) {
            System.out.println("删除用户成功");
            return "success";
        } else {
            System.out.println("删除用户失败");
            return "error";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getMerchInfoById", method = RequestMethod.POST)
    public MerchInfo getMerchInfoById(@RequestBody Map map){
        return merchInfoMapper.selectByPrimaryKey((Integer) map.get("merchIdForUpdate"));
    }

    @ResponseBody
    @RequestMapping(value = "/getTaskInfo", method = RequestMethod.POST)
    public QuartzInfo getTaskInfo(@RequestBody Map map){
        Map resultObj = (Map) map.get("taskFlag");
        String sysFlag = (String) resultObj.get("systemFlag");
        String sysEnv = (String) resultObj.get("systemEnv");
        String serviceId = (String) resultObj.get("serviceId");

        QuartzInfoExample quartzInfoExample = new QuartzInfoExample();
        quartzInfoExample.createCriteria().andSystemEnvEqualTo(sysEnv).andSystemFlagEqualTo(sysFlag).andServiceIdEqualTo(serviceId);
        return quartzInfoMapper.selectByExample(quartzInfoExample).get(0);
    }

    @ResponseBody
    @RequestMapping(value = "/showTaskInfoByParam", method = RequestMethod.POST)
    public List<QuartzInfo> showTaskInfoByParam(@RequestBody String sysFlag,
                                                @RequestBody String sysEnv,
                                                @RequestBody String serviceId,
                                                HttpServletRequest request){
        sysFlag = request.getParameter("sysFlag");
        sysEnv = request.getParameter("sysEnv");
        serviceId = request.getParameter("serviceId");
        return quartzInfoMapper.selectTaskInfoBy(sysFlag,sysEnv,serviceId);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteTaskInfo", method = RequestMethod.POST)
    public String deleteTaskInfo(@RequestBody Map map){
        JSONObject resultObj = JSONObject.parseObject((String) map.get("resultObj"));
        String sysFlag = (String) resultObj.get("systemFlag");
        String sysEnv = (String) resultObj.get("systemEnv");
        String serviceId = (String) resultObj.get("serviceId");

        QuartzInfoExample quartzInfoExample = new QuartzInfoExample();
        quartzInfoExample.createCriteria().andSystemEnvEqualTo(sysEnv).andSystemFlagEqualTo(sysFlag).andServiceIdEqualTo(serviceId);
        int numDel = quartzInfoMapper.deleteByExample(quartzInfoExample);
        if (numDel != 0) {
            System.out.println("删除任务成功");
            return "success";
        } else {
            System.out.println("删除任务失败");
            return "error";
        }
    }



    @ResponseBody
    @RequestMapping(value = "/showTaskId", method = RequestMethod.POST)
    public List<String>showTaskId(){
        QuartzInfoExample quartzInfoExample = new QuartzInfoExample();
        quartzInfoExample.createCriteria().andServiceIdIsNotNull();
        List<QuartzInfo> quartzInfoList = quartzInfoMapper.selectByExample(quartzInfoExample);
        List<String>taskIds = new ArrayList<>();
        for(QuartzInfo quartzInfo:quartzInfoList){
            if(!taskIds.contains(quartzInfo.getServiceId())){
                taskIds.add(quartzInfo.getServiceId());
            }
        }
        return taskIds;
    }




    @ResponseBody
    @RequestMapping(value = "/insertOrUpdateTaskInfo", method = RequestMethod.POST)
    public String insertOrUpdateTaskInfo(@RequestBody Map map) {
        List<QuartzInfo> countList= quartzInfoMapper.selectTaskInfoBy((String) map.get("sysFlag"),(String) map.get("sysEnv"),(String) map.get("serviceId"));
        if(map.get("taskFlag") == null || map.get("taskFlag") == ""){//新增
            if(countList.size()>=1){
                return "任务ID重复";
            }else{
                QuartzInfo quartzInfo = new QuartzInfo();
                quartzInfo.setSystemEnv((String) map.get("sysEnv"));
                quartzInfo.setSystemFlag((String) map.get("sysFlag"));
                quartzInfo.setServiceId((String) map.get("serviceId"));
                quartzInfo.setCronExpress((String) map.get("cronExpress"));
                int count = quartzInfoMapper.insert(quartzInfo);
                if (count != 0) {
                    System.out.println("新增任务成功");
                    return "success";
                } else {
                    System.out.println("新增任务失败");
                    return "error";
                }
            }



        }else{//修改
            Map resultObj = (Map) map.get("taskFlag");
            String sysFlag = (String) resultObj.get("systemFlag");
            String sysEnv = (String) resultObj.get("systemEnv");
            String serviceId = (String) resultObj.get("serviceId");
            QuartzInfoExample quartzInfoExample = new QuartzInfoExample();
            quartzInfoExample.createCriteria().andSystemEnvEqualTo(sysEnv).andSystemFlagEqualTo(sysFlag).andServiceIdEqualTo(serviceId);
            QuartzInfo updateInfo = quartzInfoMapper.selectByExample(quartzInfoExample).get(0);
//            List<QuartzInfo> updateInfoList = quartzInfoMapper.selectByExample(quartzInfoExample);


//            if(updateInfoList.size()<=1){
//
//            }
            if(countList.size()>=1 && !serviceId.endsWith((String) map.get("serviceId"))){
                return "任务ID重复";
            }else{

                updateInfo.setSystemEnv((String) map.get("sysEnv"));
                updateInfo.setSystemFlag((String) map.get("sysFlag"));
                updateInfo.setServiceId((String) map.get("serviceId"));
                updateInfo.setCronExpress((String) map.get("cronExpress"));

                int num2 = quartzInfoMapper.updateByExampleSelective(updateInfo,quartzInfoExample);
                if (num2 != 0) {
                    System.out.println("更新任务成功");
                    return "success";
                } else {
                    System.out.println("更新用户失败");
                    return "error";
                }
            }


        }

    }


    //校验serviceID是否唯一
    @ResponseBody
    @RequestMapping(value = "/showEmailAccount", method = RequestMethod.POST)
    public List<String> showEmailAccount(){
        MailInfoExample mailInfoExample = new MailInfoExample();
        mailInfoExample.createCriteria().andMailAddressIsNotNull();
        List<MailInfo> mailInfoList = mailInfoMapper.selectByExample(mailInfoExample);

        List<String> mailAccountList = new ArrayList<>();
        for(MailInfo mailInfo:mailInfoList){
            if(!mailAccountList.contains(mailInfo.getMailAddress())){
                mailAccountList.add(mailInfo.getMailAddress());
            }
        }

        return mailAccountList;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteEmailInfo", method = RequestMethod.POST)
    public String deleteEmailInfo(@RequestBody Map map){
        JSONArray arrObj = JSONArray.parseArray((String) map.get("resultIds"));
        List<Integer> resultIdList =  arrObj.toJavaList(Integer.class);

        int num = mailInfoMapper.batchDeleteEmailInfo(resultIdList);
        if (num != 0) {
            System.out.println("删除邮箱账号成功");
            return "success";
        } else {
            System.out.println("删除邮箱账号失败");
            return "error";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getEmailInfoById", method = RequestMethod.POST)
    public MailInfo getEmailInfoById(@RequestBody Map map){
        System.out.println(map.get("emailIdForUpdate"));
        return mailInfoMapper.selectByPrimaryKey((Integer) map.get("emailIdForUpdate"));
    }

    @ResponseBody
    @RequestMapping(value = "/showEmailByParam", method = RequestMethod.POST)
    public List<MailInfo> showEmailByParam(@RequestBody String mailAddress,
                                   @RequestBody String status,
                                   HttpServletRequest request) {

        mailAddress = request.getParameter("mailAddress");
        status = request.getParameter("status");
        return mailInfoMapper.selectMailInfoBy(mailAddress, status);
    }

    @ResponseBody
    @RequestMapping(value = "/insertOrUpdateEmailInfo", method = RequestMethod.POST)
    public String insertOrUpdateEmailInfo(@RequestBody Map map){

        List<String> mailAccountList = showEmailAccount();
        if(map.get("emailId") == null || map.get("emailId") == ""){//新增加

            if(!mailAccountList.contains(map.get("mailAddress"))){
                MailInfo mailInfo = new MailInfo();
                mailInfo.setMailAddress((String) map.get("mailAddress"));
                mailInfo.setStatus((String) map.get("status"));
                mailInfo.setRemark((String) map.get("remark"));
                int insertNum = mailInfoMapper.insert(mailInfo);
                if(insertNum>0){
                    System.out.println("新增邮箱账号成功");
                    return "success";
                }else{
                    System.out.println("新增邮箱账号失败");
                    return "error";
                }

            }else{
                return "邮箱账号重复!";
            }

        }else{//修改
            MailInfo updateInfo = mailInfoMapper.selectByPrimaryKey((Integer) map.get("emailId"));
            List<String> removeMailIdList = new ArrayList<>();
            for(String emailId: mailAccountList){
                if(emailId.equals(updateInfo.getMailAddress())){
                    removeMailIdList.add(emailId);
                }
            }
            //去除要修改记录的merchId
            if(removeMailIdList.size()>0){
                mailAccountList.removeAll(removeMailIdList);
            }
            if(!mailAccountList.contains(map.get("mailAddress"))){

                updateInfo.setMailAddress((String) map.get("mailAddress"));
                updateInfo.setStatus((String) map.get("status"));
                updateInfo.setRemark((String) map.get("remark"));

                int updateNum = mailInfoMapper.updateByPrimaryKey(updateInfo);

                if (updateNum != 0) {
                    System.out.println("更新邮箱账户成功");
                    return "success";
                } else {
                    System.out.println("更新邮箱账户失败");
                    return "error";
                }
            }else{
                return "邮箱账号ID重复,更新邮箱账户失败";
            }
        }
    }




}