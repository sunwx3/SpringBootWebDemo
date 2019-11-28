package com.sunwx.springboot.service;

import com.sunwx.springboot.entity.SkuStock;

import java.util.List;

public interface SkuStockService {
    //根据商品id查询商品的sku
    public List<SkuStock> selectByPid(Integer id);
    //根据商品货号查询商品的sku
    public List<SkuStock> selectBySkuCode(String skuCode);
    //修改商品的sku信息
    public boolean updateSkuCode(SkuStock skuStock);
}
