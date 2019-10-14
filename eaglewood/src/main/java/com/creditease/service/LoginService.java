package com.creditease.service;

import com.creditease.mybatis.pojo.UserInfo;
import com.creditease.mybatis.pojo.UserInfoExample;

/**
 * Created by admin on 2019/8/25.
 */
public interface LoginService {

    public UserInfo login(UserInfoExample user);

}
