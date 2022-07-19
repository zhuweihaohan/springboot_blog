package com.lhd.springboot_blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication()
@MapperScan("com.lhd.springboot_blog.mapper")
@EnableTransactionManagement()
public class SpringbootBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBlogApplication.class, args);
    }

}
