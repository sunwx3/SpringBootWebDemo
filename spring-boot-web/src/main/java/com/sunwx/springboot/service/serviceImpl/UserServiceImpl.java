package com.sunwx.springboot.service.serviceImpl;

import com.sunwx.springboot.entity.User;
import com.sunwx.springboot.entity.UserExample;
import com.sunwx.springboot.mapper.UserMapper;
import com.sunwx.springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public List<User> userLogin(User user) {
        return userMapper.userLogin(user);
    }

    @Override
    public List<User> selectAllUser(String id) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(id);
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }
}
