package com.sunwx.springboot.controller;

import com.sunwx.springboot.bean.Student;
import com.sunwx.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class StudentLoginController {
    @Autowired
    StudentService studentService;
    @RequestMapping(value = "/stu/login")
    public String login(Student stu, Map<String,Object> map, HttpSession session){
        List<Student> students = studentService.selectStu(stu);
        System.out.println("aaaaaaaaaaaaa");
        if(CollectionUtils.isEmpty(students)){
            map.put("msg","用户名或密码错误");
            return "login";
        }else {
            session.setAttribute("loginMsg",students);
            return "index";

        }
    }
}
