package com.springboot.demo.service.impl;

import com.springboot.demo.dao.UserDao;
import com.springboot.demo.entity.User;
import com.springboot.demo.mapper.UserMapper;
import com.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Auther: zhangyingqi
 * @Date: 2018/8/27 17:26
 * @Description:
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Autowired
    UserMapper userMapper;

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public int insertUser(User user) {
        int flag = userMapper.insertUser(user);
        return flag;
    }

    @Override
    public User SelUser(User user) {
        User selUser = userMapper.SelUser(user);
        return selUser;
    }

    @Override
    public int updUser(User user) {
        int flag = userMapper.updUser(user);
        return flag;
    }

    @Override
    public User selByName(User user) {
        User selByName = userMapper.selByName(user);
        return selByName;
    }


}
