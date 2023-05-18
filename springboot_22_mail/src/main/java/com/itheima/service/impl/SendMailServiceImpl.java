package com.itheima.service.impl;

import com.itheima.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    // 发送人
    private String from = "oxgoss@163.com";
    // 接收人
    private String to = "122486975@qq.com";
    // 标题
    private String subject = "测试邮件";
    // 正文
    private String context = "<img src='https://img1.baidu.com/it/u=1960110688,1786190632&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=281' /><a href='https://www.baidu.com'>测试邮件正文内容</a>";


    @Override
    public void sendMail() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            // MimeMessageHelper第二参数为true，才能发送多附件
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(from + "(小豆豆)");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context, true);

            // 添加附件
            File f1 = new File("/Users/gavin_guo/Desktop/study-demo/后端/java/springboot/springboot_22_mail/pom.xml");
            File f2 = new File("/Users/gavin_guo/Desktop/study-demo/后端/java/springboot/springboot_22_mail/src/main/resources/安装虚拟机.png");

            helper.addAttachment(f1.getName(), f1);
            helper.addAttachment("图片.png", f2);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
