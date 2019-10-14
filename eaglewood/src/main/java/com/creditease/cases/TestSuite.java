package com.creditease.cases;
/**
 * Created by admin on 2019/7/18.
 */

import com.Application;
import com.creditease.mybatis.pojo.TestCase;
import com.creditease.mybatis.pojo.TestResult;

import com.creditease.service.TestCaseService;
import com.creditease.service.TestResultService;
import com.creditease.service.impl.TestCaseServiceImpl;
import com.creditease.service.impl.TestResultServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author
 * @createTime 2019/7/18 10:49
 * @description
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Application.class)

@SpringBootTest(classes = Application.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class TestSuite extends
        AbstractTestNGSpringContextTests {

    @Autowired
    TestResultService testResultService;
    @Autowired
    TestCaseService testCaseService;

    @Test
    public void testSuite() throws Exception {
        List<TestCase> allCase = testCaseService.getAllCase();
        Map<String,List<String>> mapObj = testResultService.getParamsAndResults();
        System.out.println("测试case的参数响应结果返回start :"
                + mapObj
                +"测试case的参数响应结果返回end -------------------------");
        TestResult testResult = new TestResult();

        for(int i=0;i<allCase.size();i++){
            testResult.setSystemFlag(allCase.get(i).getSystemFlag());
            testResult.setSystemEnv(allCase.get(i).getSystemEnv());
            testResult.setMerchId(allCase.get(i).getMerchId());
            testResult.setServiceId(allCase.get(i).getServiceId());
            testResult.setReqBody(mapObj.get("requestParams").get(i));
            testResult.setCreateTime(new Date());
            testResult.setResult(mapObj.get("responseResult").get(i));
            if(mapObj.get("respStatus").get(i).equals("03")){
                testResult.setIspass("false");
            }else{
                testResult.setIspass("true");
            }

            testResultService.insertTestResult(testResult);
        }



    }
}
 
    