package com.springboot.demo.mapper;

import com.springboot.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Insert("insert into user (id,create_date,name,age) values(#{id},#{createDate},#{name},#{age})")
    public int  insertUser(User user);
    @Select("select * from user where name = #{name}")
    public User SelUser(User user);
    @Update("update user set name = #{name} where name = 'zhang'")
    public int updUser(User user);
    @Select("select * from user where name = #{name}")
    public User selByName(User user);
}
