package com.sunwx.springboot.service;

import com.github.pagehelper.Page;
import com.sunwx.springboot.entity.Brand;

import java.util.List;

public interface BrandService {
    public List<Brand> selectAllBrand(Page page);
}
