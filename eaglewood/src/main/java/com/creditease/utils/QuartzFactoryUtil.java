package com.creditease.utils;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @description
 * @Author
 * @Date 2019-07-24 13:39
 **/

public class QuartzFactoryUtil {
    /**
     * 单例模式
     */
    private static SchedulerFactory schedulerFactory;

    static {
        schedulerFactory = new StdSchedulerFactory();
    }

    public static Scheduler createScheduler() throws SchedulerException {
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        return scheduler;
    }

}
