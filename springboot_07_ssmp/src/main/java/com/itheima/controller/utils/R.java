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

    public R(Integer code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
