package com.sunwx.springbootcache;

import com.sunwx.springbootcache.bean.Employee;
import com.sunwx.springbootcache.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作k-v都是字符串
    @Autowired
    RedisTemplate redisTemplate;//k-v 都是对象
    @Autowired
    RedisTemplate<Object,Employee> empRedisTemplate;
    @Test
    public void contextLoads() {
    }
    @Test
    public void test01(){
        //给redis中 保存数据
       //stringRedisTemplate.opsForValue().append("mssage", "zhangsan");
       // String msg = stringRedisTemplate.opsForValue().get("msg");
        stringRedisTemplate.opsForList().leftPush("mylist","1");
        //log.info("msg=="+msg);
    }
    @Test
    public void test02(){
        Employee employee = employeeMapper.getById(2);
        //默认如果保存对象，使用jdk序列化机制，序列化的数据保存到redis中
        //redisTemplate.opsForValue().set("emp-01",employee);
        //将数据以json形式保存
        empRedisTemplate.opsForValue().set("emp01",employee);
    }

}
