package com.sunwx.springboot.service;

import com.github.pagehelper.Page;
import com.sunwx.springboot.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> selectAll(Page page);
    public List<Product> selectBySome(Product product);
}
