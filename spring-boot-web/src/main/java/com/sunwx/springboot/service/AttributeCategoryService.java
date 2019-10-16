package com.sunwx.springboot.service;

import com.github.pagehelper.Page;
import com.sunwx.springboot.entity.AttributeCategory;

import java.util.List;

public interface AttributeCategoryService {
    public List<AttributeCategory> selectAllAttCag(Page page);

    public boolean updateAttCag(AttributeCategory attributeCategory);

    public boolean insertAttCag(AttributeCategory attributeCategory);

    public boolean deleteAttCag(Integer id);

    public boolean deleteAttCagByNames(List<String> list);
}
