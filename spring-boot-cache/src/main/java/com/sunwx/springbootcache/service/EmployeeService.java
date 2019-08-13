package com.sunwx.springbootcache.service;

import com.sunwx.springbootcache.bean.Employee;
import com.sunwx.springbootcache.mapper.EmployeeMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;



@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Cacheable
    public Employee getById(Integer id){
        System.out.println("查询"+id+"员工");
        Employee employee = employeeMapper.getById(id);
        return employee;
    }
}
