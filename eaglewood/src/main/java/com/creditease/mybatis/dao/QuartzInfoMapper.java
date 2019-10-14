package com.creditease.mybatis.dao;

import com.creditease.mybatis.pojo.QuartzInfo;
import com.creditease.mybatis.pojo.QuartzInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuartzInfoMapper {
    int countByExample(QuartzInfoExample example);

    int deleteByExample(QuartzInfoExample example);

    int insert(QuartzInfo record);

    int insertSelective(QuartzInfo record);

    List<QuartzInfo> selectByExample(QuartzInfoExample example);

    List<QuartzInfo> selectAll();

    int updateByExampleSelective(@Param("record") QuartzInfo record, @Param("example") QuartzInfoExample example);

    int updateByExample(@Param("record") QuartzInfo record, @Param("example") QuartzInfoExample example);

    List<QuartzInfo> selectTaskInfoBy(@Param("sysFlag") String sysFlag,@Param("sysEnv") String sysEnv,@Param("serviceId") String serviceId);


}