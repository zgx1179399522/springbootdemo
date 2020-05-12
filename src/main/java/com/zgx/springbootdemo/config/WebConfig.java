package com.zgx.springbootdemo.config;

import com.fasterxml.jackson.core.JsonParser;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@Configuration
public class WebConfig implements WebMvcConfigurer {

//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("img/**").addResourceLocations("file:D:/java/up_load/");
//    }

        public void addResourceHandlers(ResourceHandlerRegistry registry) {
           registry.addResourceHandler("webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/").resourceChain(true);
        }
}
