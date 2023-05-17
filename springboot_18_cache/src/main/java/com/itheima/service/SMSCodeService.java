package com.itheima.service;

import com.itheima.domain.SMSCode;

public interface SMSCodeService {
    public String sendCodeToSMS(String tele);
    public Boolean checkCode(SMSCode smsCode);
}
