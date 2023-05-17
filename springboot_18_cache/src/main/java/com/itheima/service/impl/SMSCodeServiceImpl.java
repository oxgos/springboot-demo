package com.itheima.service.impl;

import com.itheima.domain.SMSCode;
import com.itheima.service.SMSCodeService;
import com.itheima.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    @Override
    // 存和放
//     @Cacheable(value = "smsCode", key = "#tele")
    // @CachePut只存
    @CachePut(value = "smsCode", key = "#tele")
    public String sendCodeToSMS(String tele) {
        return codeUtils.generator(tele);
    }

    @Override
    public Boolean checkCode(SMSCode smsCode) {
        // 取出内存中的验证码与传递过来的验证码对比，如果相同，返回true
        String code = smsCode.getCode();
        // 需要在springBoot的Bean里，才能读取缓存
        String cacheCode = codeUtils.get(smsCode.getTele());
        return code.equals(cacheCode);
    }

}
