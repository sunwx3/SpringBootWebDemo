package com.sunwx.springboot.service.serviceImpl;

import com.sunwx.springboot.entity.ums_admin;
import com.sunwx.springboot.entity.ums_adminExample;
import com.sunwx.springboot.mapper.ums_adminMapper;
import com.sunwx.springboot.service.AdminService;
import com.sunwx.springboot.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Slf4j
@Service
public class AdminServiceimpl implements AdminService {
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceimpl.class);
    @Resource
    ums_adminMapper adminMapper;
    @Override
    public List<ums_admin> selectOne() {
        PageUtils.setPageInfo(1,10);
        ums_adminExample adminExample = new ums_adminExample();
        adminExample.createCriteria().andUsernameLike("%ad%");
        List<ums_admin> ums_admins = this.adminMapper.selectByExample(adminExample);
        logger.error("the list size is {}",ums_admins);
        log.info("the list size is {}",ums_admins);
        return ums_admins;
    }


}

