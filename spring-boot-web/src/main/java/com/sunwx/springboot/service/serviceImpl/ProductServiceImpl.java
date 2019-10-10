package com.sunwx.springboot.service.serviceImpl;

import com.github.pagehelper.Page;
import com.sunwx.springboot.entity.Product;
import com.sunwx.springboot.entity.ProductExample;
import com.sunwx.springboot.mapper.ProductMapper;
import com.sunwx.springboot.service.ProductService;
import com.sunwx.springboot.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> selectAll(Page page) {
        PageUtils.setPageInfo(page.getPageNum(),page.getPageSize());
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andIdIsNotNull();
        List<Product> products = productMapper.selectByExample(productExample);
        return products;
    }
}
