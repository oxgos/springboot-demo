package com.itheima.controller;

import org.springframework.web.bind.annotation.*;

// Rest模式

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/users") // 公共路径
public class UserController {
    //    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @GetMapping
    public String getAllUsers() {
        System.out.println("getAllUsers");
        return "{'module': 'user get all users'}";
    }

    //    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public String getUserById(@PathVariable String id) {
        System.out.println("getUserById : " + id);
        return "{'module': 'user get by id'}";
    }

    //    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @PostMapping
    public String saveUser(User user) {
        System.out.println("saveUser : " + user);
        return "{'module': 'save user'}";
    }

    //    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    @PutMapping
    public String updateUser(User user) {
        System.out.println("updateUser : " + user);
        return "{'module': 'update user'}";
    }

    //    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        System.out.println("deleteUser : " + id);
        return "{'module': 'delete user'}";
    }
}