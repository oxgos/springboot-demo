package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotDeployApplication {

    public static void main(String[] args) {
//        彻底禁用热启动
//        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(HotDeployApplication.class);
    }

}
