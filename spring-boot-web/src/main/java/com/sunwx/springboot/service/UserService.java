package com.sunwx.springboot.service;



import com.sunwx.springboot.entity.User;

import java.util.List;

public interface UserService {
    public List<User> userLogin(User user);

    public List<User> selectAllUser(String id);
}
