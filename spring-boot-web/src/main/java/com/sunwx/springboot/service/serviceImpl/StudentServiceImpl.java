/*
package com.sunwx.springboot.service.serviceImpl;

import com.sunwx.springboot.bean.Student;
import com.sunwx.springboot.mapper.StudentMapper;
import com.sunwx.springboot.service.StudentService;
import com.sunwx.springboot.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public List<Student> selectStu(Student stu) {
        PageUtils.setPageInfo(1,10);

        List<Student> students = studentMapper.selectStu(stu);
        int a = students.size();
        if(a!=0){
            return students;
        }else {
            return null;
        }
    }
}
*/
