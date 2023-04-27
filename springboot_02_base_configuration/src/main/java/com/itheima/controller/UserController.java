package com.itheima.controller;

import com.itheima.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    // 读取yaml数据中的单一数据
    @Value("${country}")
    private String country;

    @Value("${user1.name}")
    private String name1;

    @Value("${likes[1]}")
    private String like1;

    @Value("${users[1].name}")
    private String name2;

    @Value("${tempDir}")
    private String tempDir;

    // 使用自动装配将所有的数据封装到一个对象Environment中
    @Autowired
    private Environment env;

    @Autowired
    private MyDataSource myDataSource;

    @GetMapping
    public String getById() {
        System.out.println("springboot is running");
        System.out.println("country =====> " + country);
        System.out.println("name1 =====> " + name1);
        System.out.println("name2 =====> " + name2);
        System.out.println("like1 =====> " + like1);
        System.out.println("tempDir =====> " + tempDir);
        System.out.println("--------------------");
        System.out.println(env.getProperty("server.port"));
        System.out.println(env.getProperty("user1.name"));
        System.out.println("--------------------");
        System.out.println(myDataSource);
        return "springboot is running...";
    }
}

