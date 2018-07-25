package com.example.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


public class WebConfig extends WebMvcConfigurationSupport {



    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

//        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login","/user/regist");
        super.addInterceptors(registry);

    }
}
