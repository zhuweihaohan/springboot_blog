package com.lhd.springboot_blog;

import com.lhd.springboot_blog.entity.Tag;
import com.lhd.springboot_blog.service.ArticleService;
import com.lhd.springboot_blog.service.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

@SpringBootTest
class SpringbootBlogApplicationTests {
@Autowired
private TagService tagService;
@Autowired
private ArticleService articleService;
    @Test
    void contextLoads() {
//        Tag tag=new Tag();
//        tag.setTagName("111");
//        tag.setTagDescription("111");
//        tagService.addTag(tag);
//        System.out.println(tag.getTagId());
//       articleService.addtest(6);
    }
    @Autowired
    JavaMailSender javaMailSender;
    @Test
    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("这是一封测试邮件");
        message.setFrom("lhd3f8@163.com");
        message.setTo("lhd3f8@163.com");
//        message.setCc("3x37@qq.com");
//        message.setBcc("1XXXX098@qq.com");
        message.setSentDate(new Date());
        message.setText("这是测试邮件的正文");
//        javaMailSender.send(message);
    }
    //携带图片
    @Test
    public void sendAttachFileMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("这是一封测试图片邮件");
        helper.setFrom("lhd3f8@163.com");
        helper.setTo("lhd3f8@163.com");
        helper.setSentDate(new Date());
        helper.setText("这是测试邮件的正文");
        helper.addAttachment("test.jpg",new File("C:\\work\\code\\myCode\\springboot_blog\\src\\main\\resources\\static\\img\\logo.png"));
//        javaMailSender.send(mimeMessage);
    }


}
