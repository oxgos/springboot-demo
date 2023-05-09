package com.itheima.controller.bak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseClass {
    private Class clazz = null;
    public Logger log;
    public BaseClass() {
        clazz = this.getClass();
        log = LoggerFactory.getLogger(clazz);
    }

}