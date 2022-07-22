package com.lhd.springboot_blog.schedule;


import com.lhd.springboot_blog.utils.mysqlBackups.DatabaseTool;
import com.lhd.springboot_blog.utils.mysqlBackups.TimeUtils;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.time.LocalDate;
import java.util.Date;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
@Slf4j
public class SaticScheduleTask {

    //3.添加定时任务
    //@Scheduled(cron = "*/30 * * * * ?")

    // Cron表达式范例：
//
//    每隔5秒执行一次：*/5 * * * * ?
//
//    每隔1分钟执行一次：0 */1 * * * ?
//
//    每天23点执行一次：0 0 23 * * ?
//
//    每天凌晨1点执行一次：0 0 1 * * ?
//
//    每月1号凌晨1点执行一次：0 0 1 1 * ?
//
//    每月最后一天23点执行一次：0 0 23 L * ?
//
//    每周星期天凌晨1点实行一次：0 0 1 ? * L
//
//    在26分、29分、33分执行一次：0 26,29,33 * * * ?
//
//    每天的0点、13点、18点、21点都执行一次：0 0 0,13,18,21 * * ?

    @Value("${resultFile}")
    private String resultFile;
    @Value("${mysqlIp}")
    private   String mysqlIp;
    @Value("${spring.datasource.username}")
    private  String userName;
    @Value("${spring.datasource.password}")
    private  String password;
    @Value("${database}")
    private  String database;
    @Value("${mysql_port}")
    private  String port;
    @Autowired
    JavaMailSender javaMailSender;

@Scheduled(cron = "0 0 10 * * ?")
//    @Scheduled(cron = "0 */1 * * * ?")
        public void job4() {
            try {
                //备份当天数据库
                log.info("备份今天的数据库备份："+new Date());
                DatabaseTool.backup(mysqlIp,port,userName,password,database,resultFile);
                //删除7天前的备份
                log.info("删除七天前的备份文件:"+resultFile+ TimeUtils.getLast7Day() +"-blog.sql");
                File file = new File(resultFile+ TimeUtils.getLast7Day() +"-blog.sql");
                if (file.exists()){
                    file.delete();
                }
                Thread.sleep(30000);
                log.info("开始发邮件");
                MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
                helper.setSubject(TimeUtils.getDay()+"数据库备份");
                helper.setFrom("lhd3f8@163.com");
                helper.setTo("lhd3f8@163.com");
                helper.setSentDate(new Date());
                helper.setText(TimeUtils.getDay()+"的数据库备份，见附件");
                helper.addAttachment(TimeUtils.getDay()+"-blog.sql",new File(resultFile+LocalDate.now()+"-blog.sql"));
                javaMailSender.send(mimeMessage);
            }catch (Exception e){
                log.error("备份数据库报错："+e);

            }
        }

    }

