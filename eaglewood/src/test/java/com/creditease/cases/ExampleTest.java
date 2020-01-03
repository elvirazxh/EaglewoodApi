package com.creditease.cases;/**
 * Created by admin on 2019/9/9.
 */

import com.Application;
import com.alibaba.fastjson.JSONObject;
import com.creditease.mybatis.dao.SysInfoMapper;
import com.creditease.mybatis.pojo.SysInfo;
import com.creditease.mybatis.pojo.SysInfoExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @createTime 2019/9/9 11:42
 * @description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ExampleTest {

    @Autowired
    private SysInfoMapper sysInfoMapper;


//    @Test
//    public void testMethod(){
//        SysInfoExample sysInfoExample = new SysInfoExample();
//        sysInfoExample.createCriteria().andSystemFlagIsNotNull();
//        List<SysInfo> sysInfoList = sysInfoMapper.selectByExample(sysInfoExample);
//        List<String> sysFlagList = new ArrayList<>();
//        for(SysInfo sysInfo:sysInfoList){
//            if(!sysFlagList.contains(sysInfo.getSystemFlag())){
//                System.out.println(sysInfo.getSystemFlag());
//                sysFlagList.add(sysInfo.getSystemFlag());
//
//            }
//        }
//
//        System.out.println(sysFlagList);
//    }


    @Test
    public  void testFunc(){

        String jsonStr = "{\"bankOrderId\":\"D191113150008YLD54EQ004I\",\"completeTime\":\"20191113150008\",\"extend1\":\"自有通道入金记账接口测试\",\"retCode\":\"0000\",\"retMsg\":\"业务处理成功\",\"status\":\"02\",\"subCode\":\"0000\",\"subMsg\":\"业务处理成功\"}";
        JSONObject resp = JSONObject.parseObject(jsonStr);
        //JSONObject data = JSONObject.parseObject(resp.getString("data"));

//        JSONObject data = resp.getJSONObject("data");

        System.out.println(resp);

        System.out.println("**************************************");

        System.out.println(resp.get("bankOrderId"));






    }
}
 
    