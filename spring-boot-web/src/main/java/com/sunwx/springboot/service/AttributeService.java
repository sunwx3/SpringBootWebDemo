package com.sunwx.springboot.service;

import com.sunwx.springboot.entity.Attribute;

import java.util.List;

public interface AttributeService {
    public List<Attribute> selectAttributeByACId(Integer id);

    public List<Attribute> selectAllByACId(Integer id);
}
