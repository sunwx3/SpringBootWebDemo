package com.sunwx.springboot.service.serviceImpl;

import com.github.pagehelper.Page;
import com.sunwx.springboot.entity.Brand;
import com.sunwx.springboot.entity.BrandExample;
import com.sunwx.springboot.mapper.BrandMapper;
import com.sunwx.springboot.service.BrandService;
import com.sunwx.springboot.utils.PageUtils;
import org.hibernate.annotations.Source;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {
    @Source
    BrandMapper brandMapper;
    @Override
    public List<Brand> selectAllBrand(Page page) {
        PageUtils.setPageInfo(page.getPageNum(),page.getPageSize());
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andIdIsNotNull();
        return brandMapper.selectByExample(brandExample);
    }
}
