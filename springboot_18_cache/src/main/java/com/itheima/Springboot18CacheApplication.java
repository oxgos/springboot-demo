package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
// 开启缓存功能
@EnableCaching
public class Springboot18CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot18CacheApplication.class, args);
    }

}
