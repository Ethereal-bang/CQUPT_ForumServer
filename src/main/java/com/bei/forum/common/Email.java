package com.bei.forum.common;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class Email {
    private static final String senderEmail = "939847757@qq.com";

    public static String send(String email) {
        // 指定发送邮件主机
        String host = "smtp.qq.com";    // QQ邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("shen.ruofeng@qq.com", "hzcqnnyubthwbcgg"); //发件人邮件用户名、授权码
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(senderEmail));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(email));

            // Set Subject: 头部头字段
            message.setSubject("邮子论坛登录认证");

            // 设置消息体
            String randomNum = String.format("%4d", new Random().nextInt(10000));
            message.setText("您的认证码是" + randomNum);

            // 发送消息
            Transport.send(message);
            return randomNum;
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return "";
    }
}
