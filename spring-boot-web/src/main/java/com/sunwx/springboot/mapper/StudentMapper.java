package com.sunwx.springboot.mapper;

import com.sunwx.springboot.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface StudentMapper {
    List<Student> selectStu(Student stu);
}
