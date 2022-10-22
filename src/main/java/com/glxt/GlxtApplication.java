package com.glxt;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

//@MapperScan("com.glxt.mapper")
@EnableCaching
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class GlxtApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlxtApplication.class, args);
    }

}
