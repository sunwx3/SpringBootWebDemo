package com.sunwx.springboot.service;

import com.sunwx.springboot.entity.ProductCategory;
import com.github.pagehelper.Page;

import java.util.List;

public interface ProductCategoryService {
    public List<ProductCategory> selectAll(Page page);
    public boolean insertCategory(ProductCategory productCategory);
    public boolean updCategory(ProductCategory productCategory);
    public boolean deleteCategory(ProductCategory productCategory);
}
