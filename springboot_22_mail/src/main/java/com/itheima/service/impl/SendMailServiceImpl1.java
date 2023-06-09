package com.itheima.service.impl;

import com.itheima.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

public class SendMailServiceImpl1 implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    // 发送人
    private String from = "oxgoss@163.com";
    // 接收人
    private String to = "122486975@qq.com";
    // 标题
    private String subject = "测试邮件";
    // 正文
    private String context = "测试邮件正文内容";


    @Override
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from + "(小豆豆)");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);

        javaMailSender.send(message);
    }
}
