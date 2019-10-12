package com.sunwx.springboot.service.serviceImpl;

import com.github.pagehelper.Page;
import com.sunwx.springboot.entity.Brand;
import com.sunwx.springboot.entity.BrandExample;
import com.sunwx.springboot.mapper.BrandMapper;
import com.sunwx.springboot.service.BrandService;
import com.sunwx.springboot.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Source;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Slf4j
@Service
public class BrandServiceImpl implements BrandService {
    private static final Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class);
    @Resource
    BrandMapper brandMapper;
    @Override
    public List<Brand> selectAllBrand(Page page) {
        PageUtils.setPageInfo(page.getPageNum(),page.getPageSize());
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andIdIsNotNull();
        return brandMapper.selectByExample(brandExample);
    }

    @Override
    public boolean insertBrand(Brand brand) {
        int num = brandMapper.insertSelective(brand);
        boolean flag;
        if(num>0){
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean updateBrand(Brand brand) {
        int num = brandMapper.updateByPrimaryKeySelective(brand);
        logger.info("有"+num+"条数据被更新");
        boolean flag;
        if(num>0){
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean deleteBrand(String name) {
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andNameEqualTo(name);
        int num = brandMapper.deleteByExample(brandExample);
        logger.info("有"+num+"条数据被删除");
        boolean flag;
        if(num>0){
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean deleteByBanchPrimaryKey(List<Integer> list) {
        int num = brandMapper.deleteByBanchPrimaryKey(list);
        logger.info("有"+num+"条数据被删除");
        boolean flag;
        if(num>0){
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }
}
