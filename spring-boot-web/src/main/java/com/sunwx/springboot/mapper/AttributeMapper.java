package com.sunwx.springboot.mapper;

import com.sunwx.springboot.entity.Attribute;
import com.sunwx.springboot.entity.AttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttributeMapper {
    int countByExample(AttributeExample example);

    int deleteByExample(AttributeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Attribute record);

    int insertSelective(Attribute record);

    List<Attribute> selectByExample(AttributeExample example);

    Attribute selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Attribute record, @Param("example") AttributeExample example);

    int updateByExample(@Param("record") Attribute record, @Param("example") AttributeExample example);

    int updateByPrimaryKeySelective(Attribute record);

    int updateByPrimaryKey(Attribute record);

    List<Attribute> selectAttributeByACId(Integer id);
}