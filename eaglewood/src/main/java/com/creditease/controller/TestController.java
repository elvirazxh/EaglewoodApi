package com.creditease.controller;

import com.creditease.service.RequestService;
import com.creditease.service.impl.TestResultServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description
 * @Author zxh
 * @Date 2019-07-24 15:34
 **/
@Controller
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

//    @Autowired
//    private RequestService requestService;

    @Autowired
    private TestResultServiceImpl testResultService;

    @RequestMapping(value = "exe", method = RequestMethod.GET)
    public @ResponseBody
    String exe(@RequestParam("sysFlg") String sysFlg, @RequestParam("sysEnv") String sysEnv) {
        logger.info("sysFlg:" + sysFlg + "=====sysEnv: " + sysEnv);
        if (sysFlg.isEmpty()) {
            return "sysFlg is not null!";
        }
        if (sysEnv.isEmpty()) {
            return "sysEnv is not null!";
        }
//        requestService.request(sysFlg, env);

        testResultService.saveCases(sysFlg,sysEnv);
        return "start execute job!";
    }

}
