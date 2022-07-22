package com.lhd.springboot_blog.utils.mysqlBackups;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;

@Slf4j
public class DatabaseTool {


    public DatabaseTool(){

    }
    /**
     * 备份数据库 ,控制台执行命令格式 "mysql的bin目录/mysqldump --databases  -h主机ip -P端口  -u用户名 -p密码  --default-character-set=字符集  数据库名
     *
     *  mysqlPath  mysql路径
     *  mysqlIp    mysql主机ip
     * mysqlPort  端口
     * userName   用户名
     *  password   密码
     * database   数据库名
     *  resultFile 备份文件全路径
     */
    public static   void backup(String mysqlIp, String port, String userName, String password, String database, String resultFile) {

        InputStream in = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fout = null;
        OutputStreamWriter writer = null;
        try {
            Runtime rt = Runtime.getRuntime();
            // 调用mysql的安装目录的命令
            /**linux**/
            log.info("执行mysql备份："+"mysqldump  --databases -h" + mysqlIp + " -P" + port + " -u" + userName + " -p" + "xxx"
                    + " --add-drop-database --default-character-set=utf8 " + database + " --result-file=" + resultFile+LocalDate.now()+"-blog.sql");
            Process process = rt.exec( "mysqldump  --databases -h" + mysqlIp + " -P" + port + " -u" + userName + " -p" + password
                    + " --add-drop-database --default-character-set=utf8 " + database + " --result-file=" + resultFile+LocalDate.now()+"-blog.sql");


            // 设置导出编码为utf-8。这里必须是utf-8
            in = process.getInputStream();// 控制台的输出信息作为输入流
            ErrorStreamThread errStream = new ErrorStreamThread(process.getErrorStream()); //错误流另开线程，不然会阻塞
            errStream.start();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (fout != null) {
                    fout.close();
                }
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
