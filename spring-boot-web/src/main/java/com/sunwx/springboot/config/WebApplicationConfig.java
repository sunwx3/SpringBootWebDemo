package com.sunwx.springboot.config;

import com.sunwx.springboot.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import java.util.List;

@Configuration
public class WebApplicationConfig extends WebMvcConfigurerAdapter {
    @Resource
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/**/user/login", "/**/user/logout", "/**/general/getImg", "/**/general/video", "/**/upgradeInformation/*");
    }

//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(loginUserArgumentResolver());
//    }
//
//    @Bean
//    public LoginUserArgumentResolver loginUserArgumentResolver() {
//        return new LoginUserArgumentResolver();
//    }
}
