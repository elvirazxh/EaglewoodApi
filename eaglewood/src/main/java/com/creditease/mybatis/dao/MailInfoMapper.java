package com.creditease.mybatis.dao;

import com.creditease.mybatis.pojo.MailInfo;
import com.creditease.mybatis.pojo.MailInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MailInfoMapper {
    int countByExample(MailInfoExample example);

    int deleteByExample(MailInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MailInfo record);

    int insertSelective(MailInfo record);

    List<MailInfo> selectByExample(MailInfoExample example);

    MailInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MailInfo record, @Param("example") MailInfoExample example);

    int updateByExample(@Param("record") MailInfo record, @Param("example") MailInfoExample example);

    int updateByPrimaryKeySelective(MailInfo record);

    int updateByPrimaryKey(MailInfo record);

    int batchDeleteEmailInfo(@Param("resultIds") List<Integer> resultIds);

    List<MailInfo> selectMailInfoBy(@Param("mailAddress") String mailAddress, @Param("status") String status);
}