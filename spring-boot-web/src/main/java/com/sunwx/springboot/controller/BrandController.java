package com.sunwx.springboot.controller;

import com.github.pagehelper.Page;
import com.sunwx.springboot.entity.Brand;
import com.sunwx.springboot.service.BrandService;
import com.sunwx.springboot.utils.PageUtils;
import com.sunwx.springboot.vo.ResEnv;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.hibernate.annotations.Source;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("brand")
@RestController
@Api("商品品牌操作")
public class BrandController {
    @Source
    BrandService brandService;
    @RequestMapping("/selectAllBrand")
    @ApiOperation(value = "查询所有品牌",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="integer",
                    name="data",value="" +
                    "	\n pageNum 页码"+
                    "   \n pageSize 每页数目",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    public ResEnv<List<Brand>> selectAllBrand(int pageNum, int pageSize){
        Page page =new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        List<Brand> brands = brandService.selectAllBrand(page);
        return PageUtils.toResEnv(brands);
    }
}
