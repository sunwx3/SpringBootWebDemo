package com.springboot.demo.service;

import com.springboot.demo.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    User save(User user);

    User findById(String id);

    void delete(User user);

    List<User> findAll();

    int insertUser(User user);

    User SelUser(User user);

    int updUser(User user);

    User selByName(User user);
}
