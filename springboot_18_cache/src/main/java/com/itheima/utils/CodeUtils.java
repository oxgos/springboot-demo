package com.itheima.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CodeUtils {

    private String[] patch = {"000000", "00000", "0000", "000", "00", "0", ""};

    public String generator(String tele) {
        int hash = tele.hashCode();
        System.out.println("hash is : " + hash);
        int encryption = 20206666;
        long result = hash ^ encryption;
        System.out.println("hash ^ encryption : " + result);
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        System.out.println("hash ^ nowTime : " + result);
        long code = Math.abs(result % 1000000);
        String codeStr = code + "";
        int len = codeStr.length();
        return patch[len] + codeStr;
    }

    @Cacheable(value = "smsCode", key = "#tele")
    public String get(String tele) {
        return null;
    }

//    public static void main(String[] args) {
//        String code = new CodeUtils().generator("13600066509");
//        System.out.println("code is : " + code);
//    }
}
