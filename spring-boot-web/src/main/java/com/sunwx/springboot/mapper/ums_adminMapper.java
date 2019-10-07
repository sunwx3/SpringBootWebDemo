package com.sunwx.springboot.mapper;

import com.sunwx.springboot.entity.ums_admin;
import com.sunwx.springboot.entity.ums_adminExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

public interface ums_adminMapper {
    int countByExample(ums_adminExample example);

    int deleteByExample(ums_adminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ums_admin record);

    int insertSelective(ums_admin record);

    List<ums_admin> selectByExample(ums_adminExample example);

    ums_admin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ums_admin record, @Param("example") ums_adminExample example);

    int updateByExample(@Param("record") ums_admin record, @Param("example") ums_adminExample example);

    int updateByPrimaryKeySelective(ums_admin record);

    int updateByPrimaryKey(ums_admin record);
}