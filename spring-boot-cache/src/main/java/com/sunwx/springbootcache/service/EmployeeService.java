package com.sunwx.springbootcache.service;

import com.sunwx.springbootcache.bean.Employee;
import com.sunwx.springbootcache.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Slf4j
@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    CacheManager cacheManager;
    // 能够根据方法的请求参数对其结果进行缓存
    @Cacheable
    public Employee getById(Integer id){
        System.out.println("查询"+id+"员工");
        log.info("无缓存时调用");
        Employee employee = employeeMapper.getById(id);
        return employee;
    }

    /**
     * 使用代码侵入的方式存redis缓存
     * @param id
     */
    @Cacheable
    public Employee getByIdToRedis(Integer id){
        log.info("查询"+id+"员工");
        log.info("无缓存时调用");
        Employee employee = employeeMapper.getById(id);
        Cache cache =cacheManager.getCache("emp");
        cache.put("emp"+id,employee);
        return employee;
    }
    @CachePut
    public void insertEmp(Employee employee){
        Integer flag = employeeMapper.insertEmp(employee);
        log.info("新增成功"+employee.getLastName());
    }
    //    @CachePut: 既调用方法，又更新缓存数据；同步更新缓存
    //    修改了数据库的某个数据，同时更新缓存
    //    运行：
    //        1.先调用目标方法
    //        2.将目标方法的结果缓存起来
    @CachePut("#result.id")
    public Employee updateEmp(Employee employee){
        log.info("updateEmp"+employee);
        int flag = employeeMapper.updateEmp(employee);
        log.info("flag"+flag);
        return employee;
    }
    //       @CacheEvict:缓存清除
    //       key:指定要清除的数据
    //       allEntries = true : 指定清除这个缓存中的所有数据
    //       beforeInvocation=fales: 缓存的清除是否在方法之前执行
    //       默认代表缓存清除操作是在方法执行之后执行；如果出现异常缓存就不会清除
    //       beforeInvocation=true  代表清除缓存操作是在方法运行之前执行，无论方法是否出现异常，缓存都清除
    @CacheEvict(beforeInvocation = true)
    public void deleteEmp(Integer id){
        Integer flag = employeeMapper.deleteEmp(id);
        log.info("删除成功");
        log.info("deleteEmp"+id);
    }
}
