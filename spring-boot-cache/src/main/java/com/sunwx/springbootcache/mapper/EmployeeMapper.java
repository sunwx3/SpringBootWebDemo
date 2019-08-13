package com.sunwx.springbootcache.mapper;

import com.sunwx.springbootcache.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id = #{id}")
    public Employee getById(Integer id);
}
