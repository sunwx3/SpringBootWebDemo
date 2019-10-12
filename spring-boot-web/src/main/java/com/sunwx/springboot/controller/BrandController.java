package com.sunwx.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.sunwx.springboot.entity.Brand;
import com.sunwx.springboot.service.BrandService;
import com.sunwx.springboot.utils.PageUtils;
import com.sunwx.springboot.utils.StateParameter;
import com.sunwx.springboot.vo.ResEnv;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.hibernate.annotations.Source;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("brand")
@RestController
@Api("商品品牌操作")
public class BrandController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
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
    @ApiOperation(value = "修改某个品牌",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="integer",
                    name="data",value="" +
                    "	\n name 名称"+
                    "   \n firstLetter 首字母"+
                    "	\n sort 排序"+
                    "	\n factoruStatus 厂家直销"+
                    "	\n showStatus 显示状态"+
                    "	\n productCount 数量"+
                    "	\n productCommentCount "+
                    "	\n logo 图标"+
                    "	\n bigPic "+
                    "	\n brandStory 品牌故事",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    @RequestMapping("/insertBrand")
    public ModelMap insertBrand(Brand brand){
        try {
            boolean flag = brandService.insertBrand(brand);
            if (flag){
                return getModelMap(StateParameter.SUCCESS,"","添加成功");
            }else{
                return getModelMap(StateParameter.FAULT,"","添加失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "添加失败");
        }
    }
    @ApiOperation(value = "更新某个品牌",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="integer",
                    name="data",value="" +
                    "\n id 主键"+
                    "	\n name 名称"+
                    "   \n firstLetter 首字母"+
                    "	\n sort 排序"+
                    "	\n factoryStatus 厂家直销"+
                    "	\n showStatus 显示状态"+
                    "	\n productCount 数量"+
                    "	\n productCommentCount "+
                    "	\n logo 图标"+
                    "	\n bigPic "+
                    "	\n brandStory 品牌故事",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    @RequestMapping("/updateBrand")
    public ModelMap updateBrand(Brand brand){
        try {
            boolean flag = brandService.updateBrand(brand);
            //String jsonString = JSONObject.toJSONString(brand);
            Object jsonString = JSONObject.toJSON(brand);//对象转为json
            if (flag){
                return getModelMap(StateParameter.SUCCESS,jsonString,"修改成功");
            }else{
                return getModelMap(StateParameter.FAULT,"","修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "修改失败");
        }
    }
    @ApiOperation(value = "删除某个品牌",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="integer",
                    name="data",value="" +
                    "	\n name 名称",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    @RequestMapping("/deleteBrand")
    public ModelMap deleteBrand(String name){
        try {
            boolean flag = brandService.deleteBrand(name);
            if (flag){
                return getModelMap(StateParameter.SUCCESS,"","删除成功");
            }else{
                return getModelMap(StateParameter.FAULT,"","删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "删除失败");
        }
    }
    @ApiOperation(value = "批量删除某个品牌",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="integer",
                    name="data",value="" +
                    "	\n name 名称",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    @RequestMapping("/deleteBanchBrand")
    public ModelMap deleteBanchBrand(HttpServletRequest request, HttpServletResponse response){
        try {
            String list = request.getParameter("list");
            List<Integer> banchBrand=new ArrayList<>();
            String params[] = list.split(",");
            for (int i = 0; i < params.length; i++) {
                banchBrand.add(Integer.valueOf(params[i]));
            }
            boolean flag = brandService.deleteByBanchPrimaryKey(banchBrand);
            if (flag){
                return getModelMap(StateParameter.SUCCESS,"","删除成功");
            }else{
                return getModelMap(StateParameter.FAULT,"","删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "删除失败");
        }
    }
}
