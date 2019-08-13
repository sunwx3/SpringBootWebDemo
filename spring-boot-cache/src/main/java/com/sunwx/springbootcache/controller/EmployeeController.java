package com.sunwx.springbootcache.controller;

import com.sunwx.springbootcache.bean.Employee;
import com.sunwx.springbootcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id){
        Employee employee = employeeService.getById(id);
        return employee;
    }
    @GetMapping("/emp")
    public Employee updateEmp(Employee employee){
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeService.deleteEmp(id);
        return "success";
    }
    @GetMapping("/insert")
    public String insrtEmp(Employee employee){
        employeeService.insertEmp(employee);
        return "success";
    }
}
