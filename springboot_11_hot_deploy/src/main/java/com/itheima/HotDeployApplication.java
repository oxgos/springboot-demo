package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class HotDeployApplication {

    public static void main(String[] args) {
//        彻底禁用热启动
        System.setProperty("Spring.devtools.livereload.enabled", "false");
        SpringApplication.run(HotDeployApplication.class);
    }

}
