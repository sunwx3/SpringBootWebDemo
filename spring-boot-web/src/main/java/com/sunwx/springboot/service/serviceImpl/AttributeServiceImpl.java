package com.sunwx.springboot.service.serviceImpl;

import com.sunwx.springboot.entity.Attribute;
import com.sunwx.springboot.mapper.AttributeMapper;
import com.sunwx.springboot.service.AttributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AttributeServiceImpl implements AttributeService {
    @Resource
    private AttributeMapper attributeMapper;
    @Override
    public List<Attribute> selectAttributeByACId(Integer id) {
        List<Attribute> attributes = attributeMapper.selectAttributeByACId(id);
        return attributes;
    }

    @Override
    public List<Attribute> selectAllByACId(Integer id) {
        attributeMapper.selectByPrimaryKey(Long.valueOf(id));
        return null;
    }

    @Override
    public boolean insertAttribute(Attribute attribute) {
        int insert = attributeMapper.insertSelective(attribute);
        boolean flag;
        if (insert>0){
            flag = true;
        }else{
            flag =  false;
        }
        return flag;
    }

    @Override
    public boolean updateAttribute(Attribute attribute) {
        int update = attributeMapper.updateByPrimaryKeySelective(attribute);
        boolean flag;
        if (update>0){
            flag = true;
        }else{
            flag =  false;
        }
        return flag;
    }

    @Override
    public boolean deleteByBanchId(List<Integer> id) {
        int delete = attributeMapper.deleteByBanchId(id);
        boolean flag;
        if (delete>0){
            flag = true;
        }else{
            flag =  false;
        }
        return flag;
    }
}
