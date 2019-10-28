package com.sunwx.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableCaching
@EnableWebMvc
@SpringBootApplication
@MapperScan("com.sunwx.springboot.mapper")

public class SpringBootWebApplication {

    public static void main(String[] args) {
          SpringApplication.run(SpringBootWebApplication.class, args);
    }

}
