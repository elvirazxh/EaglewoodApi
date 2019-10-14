package com.creditease.service.impl;
/**
 * Created by admin on 2019/8/25.
 */

import com.creditease.mybatis.dao.UserInfoMapper;
import com.creditease.mybatis.pojo.UserInfo;
import com.creditease.mybatis.pojo.UserInfoExample;
import com.creditease.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zxh
 * @createTime 2019/8/25 15:26
 * @description
 */
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public UserInfo login(UserInfoExample user) {

        List<UserInfo> userInfoList = userInfoMapper.selectByExample(user);
        if(userInfoList.size()==0){
            throw new RuntimeException("获取用户信息失败!");
        }
        return userInfoList.get(0);
    }
}
 
    