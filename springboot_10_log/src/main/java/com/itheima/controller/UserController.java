package com.itheima.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    // 创建记录日志的对象
//    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @GetMapping
    public String getById() {
        System.out.println("springboot is running .....");

        log.debug("debug....");
        log.info("info...");
        log.warn("warn...");
        log.error("error...");

        return "springboot is running .....";
    }

}