package com.creditease.cases;/**
 * Created by admin on 2019/7/31.
 */

import com.Application;
import com.creditease.mail.EmailUtil;
import com.creditease.service.impl.MailInfoServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author
 * @createTime 2019/7/31 18:49
 * @description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class EmailTest {

    @Autowired
    MailInfoServiceImpl mailInfoServiceImpl;
    @Autowired
    EmailUtil emailUtil;

    @Test
    public void testSendEmail() throws ParseException {

        
        String[] receivers = mailInfoServiceImpl.getEmailReceivers();
        System.out.println(receivers);
        String subject = "用例执行汇总";
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        Date startDate =  formatter.parse("2019-07-31 18:40:00");
        Date endDate =  formatter.parse("2019-07-31 18:47:06");
        Map<String,String> sumData = mailInfoServiceImpl.sumData("eaglewood", "Test", startDate, endDate);
//        List<Map<String,Object>> appendContents = mailInfoServiceImpl.emailAppendContent("eaglewood", "Test", startDate, endDate);
        List<List<String>> appendContents = mailInfoServiceImpl.emailAppendContents("eaglewood", "Test", startDate, endDate);
        String content = emailUtil.buildHtmlContent(sumData, appendContents);
        emailUtil.sendMail(receivers, subject, content);
    }





}

