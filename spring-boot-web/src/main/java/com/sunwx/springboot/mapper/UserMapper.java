package com.sunwx.springboot.mapper;

import com.sunwx.springboot.entity.User;
import com.sunwx.springboot.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> userLogin(User user);
}