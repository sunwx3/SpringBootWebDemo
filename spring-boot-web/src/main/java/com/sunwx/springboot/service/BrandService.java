package com.sunwx.springboot.service;

import com.github.pagehelper.Page;
import com.sunwx.springboot.entity.Brand;

import java.util.List;

public interface BrandService {

    public List<Brand> selectAllBrand(Page page);

    public boolean insertBrand(Brand brand);

    public boolean updateBrand(Brand brand);

    public boolean deleteBrand(String name);

    public boolean deleteByBanchPrimaryKey(List<Integer> list);
}
