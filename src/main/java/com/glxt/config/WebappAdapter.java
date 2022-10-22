package com.glxt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpSession;

@Configuration
public class WebappAdapter implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(loginInterceptor.getUrl());
        WebMvcConfigurer.super.addInterceptors(registry);

    }

}
