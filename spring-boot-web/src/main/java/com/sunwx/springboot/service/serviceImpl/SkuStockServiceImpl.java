package com.sunwx.springboot.service.serviceImpl;

import com.sunwx.springboot.entity.SkuStock;
import com.sunwx.springboot.entity.SkuStockExample;
import com.sunwx.springboot.mapper.SkuStockMapper;
import com.sunwx.springboot.service.SkuStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SkuStockServiceImpl implements SkuStockService {
    @Autowired
    private SkuStockMapper skuStockMapper;

    private SkuStockExample skuStockExample = new SkuStockExample();
    @Override
    public List<SkuStock> selectByPid(Integer id) {
        skuStockExample.createCriteria().andProductIdEqualTo(Long.valueOf(id));
        List<SkuStock> skuStocks = skuStockMapper.selectByExample(skuStockExample);
        return skuStocks;
    }

    @Override
    public List<SkuStock> selectBySkuCode(String skuCode) {
        skuStockExample.createCriteria().andSkuCodeLike(skuCode);
        List<SkuStock> skuStocks = skuStockMapper.selectByExample(skuStockExample);
        return skuStocks;
    }

    @Override
    public boolean updateSkuCode(SkuStock skuStock) {
        int update = skuStockMapper.updateByPrimaryKey(skuStock);
        boolean flag;
        if (update>0){
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }
}
