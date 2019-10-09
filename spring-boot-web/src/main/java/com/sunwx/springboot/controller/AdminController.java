package com.sunwx.springboot.controller;

import com.sunwx.springboot.entity.ums_admin;
import com.sunwx.springboot.service.AdminService;
import com.sunwx.springboot.utils.PageUtils;
import com.sunwx.springboot.vo.ResEnv;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@Api(value = "测试用的管理员模块", description = "测试用的管理员模块。。。。")
@RestController
public class AdminController {
    @Resource
    AdminService adminService;
    @RequestMapping("/selectOne")
    @ApiOperation(value = "查询一个用户",httpMethod = "GET",
            notes="nickName 用户姓名" +
                    "	\n phone 用户手机号" +
                    "	\n sessionId 会话id" +
                    "	\n useType 登录类型（此处不用管）" +
                    "	\n userName 用户名")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="String",
                    name="data",value="" +
                    "	\n user_name 用户名"+
                    "   \n passwd 密码"+
                    "   \n validCode 验证码",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    public ResEnv<List<ums_admin>> login(){
        return PageUtils.toResEnv(adminService.selectOne());
    }
}
