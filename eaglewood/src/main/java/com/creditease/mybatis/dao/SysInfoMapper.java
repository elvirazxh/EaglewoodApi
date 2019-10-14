package com.creditease.mybatis.dao;

import com.creditease.mybatis.pojo.SysInfo;
import com.creditease.mybatis.pojo.SysInfoExample;
import com.creditease.mybatis.pojo.SysInfoKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysInfoMapper {
    int countByExample(SysInfoExample example);

    int deleteByExample(SysInfoExample example);

    int deleteByPrimaryKey(@Param("systemFlag") String systemFlag, @Param("systemEnv") String systemEnv);

    int insert(SysInfo record);

    int insertSelective(SysInfo record);

    List<SysInfo> selectByExample(SysInfoExample example);

    SysInfo selectByPrimaryKey(SysInfoKey sysInfoKey);

    int updateByExampleSelective(@Param("record") SysInfo record, @Param("example") SysInfoExample example);

    int updateByExample(@Param("record") SysInfo record, @Param("example") SysInfoExample example);

    int updateByPrimaryKeySelective(SysInfo record);

    int updateByPrimaryKey(SysInfo record);
}