package com.creditease.mybatis.dao;

import com.creditease.mybatis.pojo.TestCase;
import com.creditease.mybatis.pojo.TestCaseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestCaseMapper {
    int countByExample(TestCaseExample example);

    int deleteByExample(TestCaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestCase record);

    int insertSelective(TestCase record);

    List<TestCase> selectByExample(TestCaseExample example);

    TestCase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestCase record, @Param("example") TestCaseExample example);

    int updateByExample(@Param("record") TestCase record, @Param("example") TestCaseExample example);

    int updateByPrimaryKeySelective(TestCase record);

    int updateByPrimaryKey(TestCase record);

    //zxh insert
    List<TestCase> selectAll();

    List<TestCase> selectCaseBy(@Param("sysFlag") String sysFlag,@Param("sysEnv") String sysEnv,@Param("merchId") String merchId,@Param("serviceId") String serviceId,@Param("status") String status,@Param("txnType") String txnType,@Param("pmtType") String pmtType);

    //批量删除
    int batchDeleteCase(@Param("caseIds") List<Integer> caseIds);
}