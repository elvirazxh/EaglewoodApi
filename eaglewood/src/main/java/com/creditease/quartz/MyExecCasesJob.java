package com.creditease.quartz;

import com.creditease.mybatis.pojo.TestResult;
import com.creditease.service.RequestService;
import com.creditease.service.impl.MailInfoServiceImpl;
import com.creditease.service.impl.RequestServiceImpl;
import com.creditease.service.impl.TestResultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description 发起请求的job
 * @Author
 * @Date 2019-07-23 10:30
 **/
//
//@Configuration
@Component // 此注解必加
@EnableScheduling // 此注解必加
@Service
public class MyExecCasesJob{
//        extends BaseJob {

    @Autowired
    private TestResultServiceImpl testResultServiceImpl;
//
//    @Autowired
//    private MailInfoServiceImpl mailInfoServiceImpl;

    protected void autoExecute(String sysFlg, String sysEnv) {
//        Date startTime = new Date();
        testResultServiceImpl.saveCases(sysFlg,sysEnv);
//        Date endTime = new Date();
//        mailInfoServiceImpl.initSendEmail(sysFlg,sysEnv,startTime,endTime);

    }
}
