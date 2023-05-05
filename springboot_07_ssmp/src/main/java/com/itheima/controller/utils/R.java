package com.itheima.controller.utils;

import lombok.Data;

@Data
public class R {
    private Integer code;
    private Object data;
    private String message;

    public R() {
    }

    public R(Integer code) {
        this.code = code;
    }

    public R(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public R(Object data) {
        this.code = 1;
        this.data = data;
    }

    public R(Object data, String message) {
        this.data = data;
        this.message = message;
    }

    public R(String message) {
        this.code = 0;
        this.message = message;
    }
}
