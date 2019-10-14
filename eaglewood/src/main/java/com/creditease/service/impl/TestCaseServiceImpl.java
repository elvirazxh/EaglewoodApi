package com.creditease.service.impl;

import com.creditease.mybatis.dao.TestCaseMapper;
import com.creditease.mybatis.pojo.TestCase;
import com.creditease.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestCaseServiceImpl implements TestCaseService {

    @Autowired
    private TestCaseMapper testCaseMapper;



    @Override
    public List<TestCase> getAllCase() {
        return testCaseMapper.selectAll();
    }

//    @Override
//    public List<TestCase> queryCaseByParam(String sysFlag,String sysEnv,String serviceId) {
//        return testCaseMapper.selectCaseBy(sysFlag,sysEnv,serviceId,status);
//    }

}

