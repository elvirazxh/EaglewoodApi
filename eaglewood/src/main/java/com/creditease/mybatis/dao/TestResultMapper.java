package com.creditease.mybatis.dao;

import com.creditease.mybatis.pojo.TestCase;
import com.creditease.mybatis.pojo.TestResult;
import com.creditease.mybatis.pojo.TestResultExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TestResultMapper {
    int countByExample(TestResultExample example);

    int deleteByExample(TestResultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestResult record);

    int insertSelective(TestResult record);

    List<TestResult> selectByExample(TestResultExample example);

    TestResult selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestResult record, @Param("example") TestResultExample example);

    int updateByExample(@Param("record") TestResult record, @Param("example") TestResultExample example);

    int updateByPrimaryKeySelective(TestResult record);

    int updateByPrimaryKey(TestResult record);

    int sumResult(@Param("sysFlag")String sysFlag, @Param("sysEnv")String sysEnv, @Param("startDate")Date startDate, @Param("endDate")Date endDate);

    int failCaseNum(@Param("sysFlag")String sysFlag, @Param("sysEnv")String sysEnv, @Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("isPassFlag")String isPassFlag);


    List<TestResult>  failResult(@Param("sysFlag")String sysFlag, @Param("sysEnv")String sysEnv, @Param("startDate")Date startDate, @Param("endDate")Date endDate);

    //查询
    List<TestResult> selectTestResultByParam(@Param("sysFlag") String sysFlag, @Param("sysEnv") String sysEnv, @Param("merchId") String merchId, @Param("serviceId") String serviceId, @Param("isPass") String isPass,@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    //批量删除
    int batchDeleteRecord(@Param("resultIds") List<Integer> resultIds);
}