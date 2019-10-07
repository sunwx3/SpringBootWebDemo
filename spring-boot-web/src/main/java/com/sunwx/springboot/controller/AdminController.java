package com.sunwx.springboot.controller;

import com.sunwx.springboot.entity.ums_admin;
import com.sunwx.springboot.service.AdminService;
import com.sunwx.springboot.utils.PageUtils;
import com.sunwx.springboot.vo.ResEnv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@RestController
public class AdminController {
    @Resource
    AdminService adminService;
    @RequestMapping("/selectOne")
    public ResEnv<List<ums_admin>> login(){
        return PageUtils.toResEnv(adminService.selectOne());
    }
}
