package com.creditease.mybatis.dao;

import com.creditease.mybatis.pojo.MerchInfo;
import com.creditease.mybatis.pojo.MerchInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MerchInfoMapper {
    int countByExample(MerchInfoExample example);

    int deleteByExample(MerchInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MerchInfo record);

    int insertSelective(MerchInfo record);

    List<MerchInfo> selectByExample(MerchInfoExample example);

    MerchInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MerchInfo record, @Param("example") MerchInfoExample example);

    int updateByExample(@Param("record") MerchInfo record, @Param("example") MerchInfoExample example);

    int updateByPrimaryKeySelective(MerchInfo record);

    int updateByPrimaryKey(MerchInfo record);

    List<MerchInfo> selectMerchIdBy(@Param("sysFlag") String sysFlag, @Param("sysEnv") String sysEnv);

    List<MerchInfo> selectMerchByParam(@Param("sysFlag") String sysFlag, @Param("sysEnv") String sysEnv,@Param("merchId") String merchId);

    //批量删除
    int batchDeleteMerchInfo(@Param("resultIds") List<Integer> resultIds);
}