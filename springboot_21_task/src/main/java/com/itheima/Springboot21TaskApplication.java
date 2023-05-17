package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// 开启定时任务功能
@EnableScheduling
public class Springboot21TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot21TaskApplication.class, args);
    }

}
