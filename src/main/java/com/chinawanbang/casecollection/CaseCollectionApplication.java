package com.chinawanbang.casecollection;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
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
}