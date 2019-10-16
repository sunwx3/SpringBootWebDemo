package com.sunwx.springboot.service.serviceImpl;

import com.github.pagehelper.Page;
import com.sunwx.springboot.entity.AttributeCategory;
import com.sunwx.springboot.entity.AttributeCategoryExample;
import com.sunwx.springboot.mapper.AttributeCategoryMapper;
import com.sunwx.springboot.service.AttributeCategoryService;
import com.sunwx.springboot.utils.PageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AttributeCategoryServiceImpl implements AttributeCategoryService {
    private static final Logger logger = LoggerFactory.getLogger(AttributeCategoryServiceImpl.class);

    AttributeCategoryExample attributeCategoryExample = new AttributeCategoryExample();
    @Resource
    AttributeCategoryMapper attributeCategoryMapper;
    @Override
    public List<AttributeCategory> selectAllAttCag(Page page) {
        PageUtils.setPageInfo(page.getPageNum(),page.getPageSize());
        attributeCategoryExample.createCriteria().andIdIsNotNull();
        List<AttributeCategory> attributeCategories = attributeCategoryMapper.selectByExample(attributeCategoryExample);
        return attributeCategories;
    }

    @Override
    public boolean updateAttCag(AttributeCategory attributeCategory) {
        String name = attributeCategory.getName();
        attributeCategoryExample.createCriteria().andNameEqualTo(name);
        int update = attributeCategoryMapper.updateByExampleSelective(attributeCategory, attributeCategoryExample);
        boolean flag;
        if (update>0){
            flag = true;
        }else
            flag = false;
        return flag;
    }

    @Override
    public boolean insertAttCag(AttributeCategory attributeCategory) {
        //attributeCategoryExample.createCriteria().
        attributeCategory.setParamCount(0);
        attributeCategory.setAttributeCount(0);
        int select = attributeCategoryMapper.insertSelective(attributeCategory);
        boolean flag;
        if (select>0){
            flag = true;
        }else
            flag = false;
        return flag;
    }

    @Override
    public boolean deleteAttCag(Integer id) {
        int delete = attributeCategoryMapper.deleteByPrimaryKey(Long.valueOf(id));
        boolean flag;
        if (delete>0){
            flag = true;
        }else
            flag = false;
        return flag;
    }

    @Override
    public boolean deleteAttCagByNames(List<String> list) {
        int delete = attributeCategoryMapper.deleteByBanchName(list);
        boolean flag;
        if (delete>0){
            flag = true;
        }else
            flag = false;
        return flag;
    }
}
