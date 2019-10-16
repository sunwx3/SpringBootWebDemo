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
}
