package com.sunwx.springboot.service.serviceImpl;

import com.github.pagehelper.Page;
import com.sunwx.springboot.entity.Product;
import com.sunwx.springboot.entity.ProductExample;
import com.sunwx.springboot.mapper.ProductMapper;
import com.sunwx.springboot.service.ProductService;
import com.sunwx.springboot.utils.PageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductMapper productMapper;
    private ProductExample productExample = new ProductExample();
    @Override
    public List<Product> selectAll(Page page) {
        PageUtils.setPageInfo(page.getPageNum(),page.getPageSize());
        productExample.createCriteria().andIdIsNotNull();
        List<Product> products = productMapper.selectByExample(productExample);
        return products;
    }

    @Override
    public List<Product> selectBySome(Product product) {
       /* productExample.createCriteria().andNameIsNull().andNameLike(product.getName()).andProductSnLike(product.getProductSn()).
                andProductCategoryIdEqualTo(product.getProductCategoryId()).andBrandIdEqualTo(product.getBrandId())
                .andPublishStatusEqualTo(product.getPublishStatus()).andVerifyStatusEqualTo(product.getVerifyStatus());*/
        List<Product> products = productMapper.selectBySome(product);
        return products;
    }
}
