package com.itheima.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public String getById() {
        System.out.println("springboot is running");
        return "springboot is running...";
    }

}