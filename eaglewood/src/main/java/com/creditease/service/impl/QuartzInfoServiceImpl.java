package com.creditease.service.impl;

import com.creditease.mybatis.dao.QuartzInfoMapper;
import com.creditease.mybatis.pojo.QuartzInfo;
import com.creditease.service.QuartzInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @Author
 * @Date 2019-07-23 18:24
 **/
@Service
public class QuartzInfoServiceImpl implements QuartzInfoService {

    @Autowired
    private QuartzInfoMapper quartzInfoMapper;

    @Override
    public List<QuartzInfo> selectAll() {
        return quartzInfoMapper.selectAll();
    }

}
