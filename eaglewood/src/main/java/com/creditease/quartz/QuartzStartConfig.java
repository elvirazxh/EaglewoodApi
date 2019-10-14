package com.creditease.quartz;

import com.alibaba.fastjson.JSON;
import com.creditease.mybatis.pojo.QuartzInfo;
import com.creditease.service.QuartzInfoService;
import com.creditease.utils.SpringContextUtil;
import com.creditease.utils.SpringUtil;
import org.apache.commons.lang3.StringUtils;
import org.quartz.CronExpression;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

import java.text.ParseException;
import java.util.List;

/**
 * @description 定时任务启动
 * @Author
 * @Date 2019-07-22 18:21
 **/

@Configuration
public class QuartzStartConfig implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(QuartzStartConfig.class);

    @Autowired
    private QuartzInfoService quartzInfoService;

    @Autowired
    private Scheduler quartzScheduler;

    @Override
    public void run(String... args) throws Exception {
        logger.info("通过实现CommandLineRunner接口，在spring boot项目启动后立即执行此方法");

        List<QuartzInfo> quartzInfoList = quartzInfoService.selectAll();
        logger.info("加载定时任务数{},任务信息{}", quartzInfoList.size(), JSON.toJSONString(quartzInfoList));

        for(QuartzInfo quartzInfo:quartzInfoList){
            try{
                logger.debug(quartzInfo.toString());

                String taskServiceId = StringUtils.trim(quartzInfo.getServiceId());
                String quartzCron = StringUtils.trim(quartzInfo.getCronExpress());

                boolean validExpression = CronExpression.isValidExpression(quartzCron);
                if (!validExpression) {
                    logger.error("错误的定时器表达式,{}", quartzInfo);
                    continue;
                }

                MethodInvokingJobDetailFactoryBean jobFactory = new MethodInvokingJobDetailFactoryBean();
                //是否并发,否
                /*
                 *  是否并发执行
                 *  例如每5s执行一次任务，但是当前任务还没有执行完，就已经过了5s了，
                 *  如果此处为true，则下一个任务会执行，如果此处为false，则下一个任务会等待上一个任务执行完后，再开始执行
                 */
                jobFactory.setConcurrent(false);
                //设置任务的名字
                jobFactory.setName(quartzInfo.getSystemEnv());
                //设置任务的分组
                jobFactory.setGroup(quartzInfo.getSystemFlag());
                //为需要执行的实体类对应的对象
                jobFactory.setTargetObject(SpringUtil.getApplicationContext().getBean(taskServiceId));
                //execute为需要执行的方法
                //通过这几个配置，告诉JobDetailFactoryBean我们需要执行定时执行ScheduleTask类中的runJob方法
                jobFactory.setTargetMethod("autoExecute"); // 使用父类模板方法，做切面处理
                jobFactory.setArguments(new String[]{quartzInfo.getSystemFlag(), quartzInfo.getSystemEnv()});
                jobFactory.afterPropertiesSet();
                //配置定时任务的触发器，也就是什么时候触发执行定时任务
                CronTriggerFactoryBean triggerFactory = new CronTriggerFactoryBean();
                //设置触发器的name
                triggerFactory.setName(quartzInfo.getSystemEnv() + "_" + quartzInfo.getSystemFlag() + "触发器::");
                triggerFactory.setJobDetail(jobFactory.getObject());
                //设置定时器的表达式
                triggerFactory.setCronExpression(quartzCron);
                triggerFactory.afterPropertiesSet();
                //加载任务
                quartzScheduler.scheduleJob(jobFactory.getObject(), triggerFactory.getObject());

            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (SchedulerException e) {
                e.printStackTrace();
            }





        }

    }

}
