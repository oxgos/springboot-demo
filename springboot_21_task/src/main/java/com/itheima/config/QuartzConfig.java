package com.itheima.config;

import com.itheima.quartz.MyQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail printJobDetail() {
        // 绑定具体的工作
        return JobBuilder
                .newJob(MyQuartz.class)
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger printJobTrigger() {
        // cron表达式
        // 位置：秒(0) 分(0) 时(0) 日(1) 月(1) 星期（Mon）
        // 符号：*：任意， ？：不规定， 0/5：从0秒开始每间隔5秒执行，0,15,30,45：0、15、30、45秒时，执行
        // 绑定对应的工作明细
        ScheduleBuilder schedBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(printJobDetail())
                .withSchedule(schedBuilder).build();
    }

}
