package com.sunwx.springboot.config;

import com.sunwx.springboot.compoent.LoginHandlerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//springbppt 2.0 使用WebMvcConfigurationSupport可以扩展SpringMvc功能
@Slf4j
@Configuration
public class MyMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送请求 / 展示index页面
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/error/404").setViewName("/admin/page_error/error_404.html");
    }
    /**
     * 添加静态资源文件，外部可以直接访问地址
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //需要配置1：----------- 需要告知系统，这是要被当成静态文件的！
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //请求为/templates/下的访问classpath:/templates/
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
        //registry.addResourceHandler("/stu/**").addResourceLocations("classpath:/templates/");
        //super.addResourceHandlers(registry);
    }

    //注册拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        log.info("进入拦截器");
       registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
               .excludePathPatterns("/","/stu/login","/static/**","/templates/register.html");
    }
}
