package com.sunwx.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sunwx.springboot.mapper")
public class SpringBootWebApplication {

    public static void main(String[] args) {
          SpringApplication.run(SpringBootWebApplication.class, args);
    }

}
