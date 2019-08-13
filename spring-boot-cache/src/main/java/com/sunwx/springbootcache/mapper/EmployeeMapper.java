package com.sunwx.springbootcache.mapper;

import com.sunwx.springbootcache.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id = #{id}")
    public Employee getById(Integer id);
    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id= #{id}")
    public int updateEmp(Employee employee);
    @Delete("delete  from employee where id=#{id}")
    public Integer deleteEmp(Integer id);
    @Insert("insert into Employee(lastName,email,gender,d_id) values (#{lastName},#{email},#{gender},#{dId})")
    public Integer insertEmp(Employee employee);
}
