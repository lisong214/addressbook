package com.chinawanbang.casecollection;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.chinawanbang.**.dao")
@SpringBootApplication
@EnableScheduling 
public class CaseCollectionApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CaseCollectionApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CaseCollectionApplication.class);
    }
    
    @Bean 
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        //允许上传的文件最大值
        factory.setMaxFileSize("50MB"); //KB,MB  
        /// 设置总上传数据总大小  
        factory.setMaxRequestSize("50MB");  
        return factory.createMultipartConfig();  
    }
}