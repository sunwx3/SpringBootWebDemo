package com.sunwx.springboot.service.serviceImpl;

import com.github.pagehelper.Page;
import com.sunwx.springboot.entity.ProductCategory;
import com.sunwx.springboot.entity.ProductCategoryExample;
import com.sunwx.springboot.mapper.ProductCategoryMapper;
import com.sunwx.springboot.service.ProductCategoryService;
import com.sunwx.springboot.utils.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Resource
    ProductCategoryMapper productCategoryMapper;
    private ProductCategoryExample productCategoryExample = new ProductCategoryExample();
    @Override
    public List<ProductCategory> selectAll(Page page) {
        PageUtils.setPageInfo(page.getPageNum(),page.getPageSize());
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        productCategoryExample.createCriteria().andIdIsNotNull();
        return productCategoryMapper.selectByExample(productCategoryExample);
    }

    @Override
    public boolean insertCategory(ProductCategory productCategory) {
        int num= productCategoryMapper.insert(productCategory);
        boolean flag;
        if(num>0){
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean updCategory(ProductCategory productCategory) {
        int key = productCategoryMapper.updateByPrimaryKey(productCategory);
        boolean flag;
        if(key>0){
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean deleteCategory(ProductCategory productCategory) {
        long id = productCategory.getId();
        productCategoryExample.createCriteria().andIdEqualTo(id);
        //int key = productCategoryMapper.deleteByPrimaryKey(id);
        int key = productCategoryMapper.deleteByExample(productCategoryExample);
        boolean flag;
        if(key>0){
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }
}
