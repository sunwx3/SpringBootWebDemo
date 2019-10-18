package com.sunwx.springboot.service;

import com.sunwx.springboot.entity.Attribute;

import java.util.List;

public interface AttributeService {
    public List<Attribute> selectAttributeByACId(Integer id);

    public List<Attribute> selectAllByACId(Integer id);

    public boolean insertAttribute(Attribute attribute);

    public boolean updateAttribute(Attribute attribute);

    public boolean deleteByBanchId(List<Integer> id);
}
