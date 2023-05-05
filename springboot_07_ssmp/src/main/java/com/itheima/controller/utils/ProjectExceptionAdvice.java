package com.itheima.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 作为spring mvc的异常处理
//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    // 拦截所有的异常信息
    @ExceptionHandler(Exception.class) // 可以指定捕获的异常
    public R doException(Exception ex) {
        // 记录日志
        // 通知运维
        // 通知开发
        ex.printStackTrace(); // 控制台输出错误信息
        return new R("服务器故障，请稍后再试！");
    }
}
