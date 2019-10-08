package com.sunwx.springboot.controller;

import com.sunwx.springboot.entity.User;
import com.sunwx.springboot.service.UserService;
import com.sunwx.springboot.utils.StateParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserLoginController extends BaseController {
    @Autowired
    UserService userService;
    public ModelMap userLogin(User user){
        try {
            List<User> userList = userService.userLogin(user);
            return getModelMap(StateParameter.SUCCESS, userList, "操作成功");
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }
}
