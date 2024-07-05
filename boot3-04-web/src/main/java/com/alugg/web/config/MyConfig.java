package com.alugg.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //保留以前
        WebMvcConfigurer.super.addResourceHandlers(registry);

        //自己写
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/a/", "classpath:/b/")
                .setCacheControl(CacheControl.maxAge(7200, TimeUnit.SECONDS));
    }

    @Override //配置拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
