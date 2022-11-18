package com.glxt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

//@MapperScan("com.glxt.mapper") //指定接口扫描路径
@EnableCaching
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)//排除自动注入安全自动配置
public class GlxtApplication extends SpringBootServletInitializer {
    //提供springboot启动的初始化器
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GlxtApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(GlxtApplication.class, args);
    }

}
