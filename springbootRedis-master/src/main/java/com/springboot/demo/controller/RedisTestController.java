package com.springboot.demo.controller;

import com.springboot.demo.base.controller.BaseController;
import com.springboot.demo.base.utils.RedisConstants;
import com.springboot.demo.base.utils.RedisUtil;
import com.springboot.demo.base.utils.StateParameter;
import com.springboot.demo.entity.User;
import com.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: RedisTestController
 * @Auther: zhangyingqi
 * @Date: 2018/8/28 17:24
 * @Description:
 */
@Controller
@ResponseBody
@RequestMapping("/redis")
public class RedisTestController extends BaseController{

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    UserService userService;
    @RequestMapping(value="/list")
    public String view(HttpServletRequest request, String name){
        logger.info("返回列表页面");
        return "/demoPage/listPage/"+ name;
    }

    /**
     * @auther: zhangyingqi
     * @date: 17:26 2018/8/28
     * @param: []
     * @return: org.springframework.ui.ModelMap
     * @Description: 测试redis存储&读取
     */
    @RequestMapping(value="/test")
    @ResponseBody
    public ModelMap test(){
        try {
            redisUtil.set("redisTemplate","这是一条测试数据", RedisConstants.datebase2);
            String value = redisUtil.get("redisTemplate",RedisConstants.datebase2).toString();
            logger.info("redisValue="+value);
            logger.info("读取redis成功");
            return getModelMap(StateParameter.SUCCESS, value, "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }

    @RequestMapping(value="/setUser")
    @ResponseBody
    public ModelMap setUser(){
        try {
            User user = new User();
            user.setName("隔壁老王");
            user.setAge(28);
            user.setId(getUuid());
            redisUtil.set("user",user, RedisConstants.datebase1);
            User res = (User)redisUtil.get("user",RedisConstants.datebase1);
            logger.info("res="+res.toString());
            logger.info("读取redis成功");
            return getModelMap(StateParameter.SUCCESS, res, "操作成功");
            //return getModelMap(StateParameter.SUCCESS, "", "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }
    @RequestMapping(value="/insertUser")
    @ResponseBody
    public ModelMap insertUser(User user){
        try {
            user.setId(getUuid());

            user.setCreateDate(new Date());
            Date createDate = user.getCreateDate();
            System.out.println(createDate);

            int user1= userService.insertUser(user);
            return getModelMap(StateParameter.SUCCESS, user1, "操作成功");
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }
    @RequestMapping(value="/selectUser")
    @ResponseBody
    public ModelMap selectUser(User user){
        try {
            User selUser = userService.SelUser(user);
            /*redisUtil.set("selUser",selUser, RedisConstants.datebase1);
            logger.info("查数据库");*/
            User res = (User)redisUtil.get("selUser",RedisConstants.datebase1);
            logger.info("res="+res.toString());
            logger.info("读取redis成功");
            return getModelMap(StateParameter.SUCCESS, selUser, "操作成功");
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "操作失败");
        }

    }
    @RequestMapping("/updUser/{name}")
    public ModelMap updUser(User user){
        try {
            int updUser = userService.updUser(user);
            logger.info("修改数据库成功");
            User user1 = userService.SelUser(user);
            redisUtil.set("userInfo_"+user1.getName(),user1,RedisConstants.datebase1);
            logger.info("缓存更新成功");
            return getModelMap(StateParameter.SUCCESS, user1, "操作成功");
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }
    @RequestMapping("/selByName/{name}")
    public ModelMap selByName(User user){
        try {
            String key = "userInfo_"+user.getName();
            logger.info(key);
            if(redisUtil.hasKey(key)){
                User userInfo = (User) redisUtil.get(key, RedisConstants.datebase1);
                logger.info("缓存读取："+userInfo.toString());
                return getModelMap(StateParameter.SUCCESS, userInfo, "操作成功");
            }else {
                User selByName = userService.selByName(user);
                redisUtil.set("userInfo_"+user.getName(),selByName,RedisConstants.datebase1);
                logger.info("加载缓存键为：："+key);
                logger.info("数据库读取："+selByName.toString());
                return getModelMap(StateParameter.SUCCESS, selByName, "操作成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, e, "操作失败");
        }
    }


}
