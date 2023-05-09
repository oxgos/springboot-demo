package com.itheima.controller.bak;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users1")
public class UserController1 extends BaseClass {
    // 创建记录日志的对象
//    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @GetMapping
    public String getById1() {
        System.out.println("springboot is running .....");

        log.debug("debug....");
        log.info("info...");
        log.warn("warn...");
        log.error("error...");

        return "springboot is running .....";
    }

}