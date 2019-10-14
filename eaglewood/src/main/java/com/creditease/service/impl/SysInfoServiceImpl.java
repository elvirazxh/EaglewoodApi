package com.creditease.service.impl;
/**
 * Created by admin on 2019/7/16.
 */

import com.creditease.mybatis.dao.SysInfoMapper;
import com.creditease.mybatis.pojo.SysInfo;
import com.creditease.mybatis.pojo.SysInfoKey;
import com.creditease.service.SysInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @createTime 2019/7/16 14:07
 * @description
 */

@Service
public class SysInfoServiceImpl implements SysInfoService {

    @Autowired
    SysInfoMapper sysInfoMapper;

    @Override
    public String getRequesetUrl(String strSysEnv, String sysFlag) {

        String requestUrl = "";

        SysInfoKey key = new SysInfoKey();
        key.setSystemEnv(strSysEnv);
        key.setSystemFlag(sysFlag);
        System.out.println("env:" + key.getSystemEnv());
        System.out.println("Flag:" + key.getSystemFlag());
        SysInfo sysInfo = sysInfoMapper.selectByPrimaryKey(key);
        if(sysInfo != null)
            requestUrl = sysInfo.getRequestUrl();
        return requestUrl;

    }
}
 
    