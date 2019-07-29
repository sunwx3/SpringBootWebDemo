package com.sunwx.springboot.service;

import com.sunwx.springboot.bean.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    List<Student> selectStu(Student stu);
}
