package com.sunwx.springboot.mapper;

import com.sunwx.springboot.entity.AttributeCategory;
import com.sunwx.springboot.entity.AttributeCategoryExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AttributeCategoryMapper {
    int countByExample(AttributeCategoryExample example);

    int deleteByExample(AttributeCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AttributeCategory record);

    int insertSelective(AttributeCategory record);

    List<AttributeCategory> selectByExample(AttributeCategoryExample example);

    AttributeCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AttributeCategory record, @Param("example") AttributeCategoryExample example);

    int updateByExample(@Param("record") AttributeCategory record, @Param("example") AttributeCategoryExample example);

    int updateByPrimaryKeySelective(AttributeCategory record);

    int updateByPrimaryKey(AttributeCategory record);
}