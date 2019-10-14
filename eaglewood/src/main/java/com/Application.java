package com; /**
 * Created by admin on 2019/6/24.
 */

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author zxh
 * @createTime 2019/6/24 11:54
 * @description
 */

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@MapperScan(basePackages = "com.creditease.mybatis.dao")
@ComponentScan({"com.creditease"})
public class Application {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    @Bean("quartzScheduler")
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        // 延时启动，应用启动x秒后
        schedulerFactoryBean.setStartupDelay(1);

        schedulerFactoryBean.setConfigLocation(new ClassPathResource("quartz.properties"));
        return schedulerFactoryBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

 
    