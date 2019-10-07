package com.sunwx.springboot.controller;

import com.alibaba.druid.util.StringUtils;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @PostMapping("/user/login")
    public String login(String username, String password, Map<String, Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginMsg",username);
            //登陆以后防止表单重复提交，可以定向到主页
            return "redirect:/index.html";
        }else {
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }
}
