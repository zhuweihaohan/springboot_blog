package com.lhd.springboot_blog.utils.mail;


import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Date;

/**
 * @Author lhd
 * @Description //TODO
 * @Date 2022/7/22 16:03
 * @company bonc
 * @project springboot_blog
 */
@Slf4j
public class SendNewIpMail implements Runnable{
    private JavaMailSender javaMailSender;
    private String visitIp;
    private String site;
    public SendNewIpMail(JavaMailSender javaMailSender,String visitIp,String site){
        this.javaMailSender=javaMailSender;
        this.visitIp = visitIp;
        this.site = site;
    }
    @Override
    public void run() {
        log.info("开始发新Ip邮件");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("注意，有新IP访问");
        message.setFrom("lhd3f8@163.com");
        message.setTo("lhd3f8@163.com");
        message.setSentDate(new Date());
        message.setText("注意，有一个新的IP访问您的网站："+visitIp+",其IP属地为："+site);
        javaMailSender.send(message);

    }
}
