package com.sunwx.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.sunwx.springboot.mapper")
@ComponentScan("com.sunwx.springboot.config")
public class SpringBootWebApplication {

    public static void main(String[] args) {
          SpringApplication.run(SpringBootWebApplication.class, args);
    }

}
