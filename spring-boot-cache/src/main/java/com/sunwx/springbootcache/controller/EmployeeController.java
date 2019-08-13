package com.sunwx.springbootcache.controller;

import com.sun.xml.internal.ws.api.FeatureConstructor;
import com.sunwx.springbootcache.bean.Employee;
import com.sunwx.springbootcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
