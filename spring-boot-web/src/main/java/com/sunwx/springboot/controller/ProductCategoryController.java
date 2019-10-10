package com.sunwx.springboot.controller;

import com.github.pagehelper.Page;
import com.sunwx.springboot.entity.ProductCategory;
import com.sunwx.springboot.service.ProductCategoryService;
import com.sunwx.springboot.utils.PageUtils;
import com.sunwx.springboot.utils.StateParameter;
import com.sunwx.springboot.vo.ResEnv;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("category")
@Api("商品分类表操作")
public class ProductCategoryController extends BaseController {
    @Resource
    ProductCategoryService productCategoryService;
    @ApiOperation(value = "查询所有的商品分类",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="integer",
                    name="data",value="" +
                    "	\n pageNum 页码"+
                    "   \n pageSize 每页数目",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    @RequestMapping("selectAll")
    public ResEnv<List<ProductCategory>> selectAllCategory(int pageNum, int pageSize) {
        Page page =new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        return PageUtils.toResEnv(productCategoryService.selectAll(page));
    }
    @ApiOperation(value = "更新某个商品分类")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",
                    name="id",value="" +
                    "	\n parentId 上机分类的编号：0表示一级分类"+
                    "   \n name 名称"+
                    "   \n level 分类级别：0->1级；1->2级"+
                    "   \n productCount "+
                    "   \n productUnit "+
                    "   \n navStatus 是否显示在导航栏：0->不显示；1->显示"+
                    "   \n showStatus 显示状态：0->不显示；1->显示"+
                    "   \n sort "+
                    "   \n icon 图片"+
                    "   \n keywords "+
                    "   \n description 描述",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    @RequestMapping(value = "updateCategory")
    public ModelMap updateCategory(ProductCategory productCategory){
        try {
            boolean status = productCategoryService.updCategory(productCategory);
            if(status){
                return getModelMap(StateParameter.SUCCESS, "", "修改成功");
            }else{
                return getModelMap(StateParameter.FAULT, "", "修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "修改失败");
        }
    }
    @ApiOperation(value = "删除某个商品分类")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",
                    name="id",value="",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    @RequestMapping(value = "deleteCategory")
    public ModelMap deleteCategory(ProductCategory productCategory){
        try {
            boolean status = productCategoryService.deleteCategory(productCategory);
            if(status){
                return getModelMap(StateParameter.SUCCESS, "", "删除成功");
            }else{
                return getModelMap(StateParameter.FAULT, "", "删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "删除失败");
        }
    }
    @ApiOperation(value = "新增某个商品分类")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query"+
                    "	\n parentId 上机分类的编号：0表示一级分类"+
                    "   \n name 名称"+
                    "   \n level 分类级别：0->1级；1->2级"+
                    "   \n productCount "+
                    "   \n productUnit "+
                    "   \n navStatus 是否显示在导航栏：0->不显示；1->显示"+
                    "   \n showStatus 显示状态：0->不显示；1->显示"+
                    "   \n sort "+
                    "   \n icon 图片"+
                    "   \n keywords "+
                    "   \n description 描述",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    @RequestMapping(value = "insertCategory")
    public ModelMap insertCategory(ProductCategory productCategory){
        try {
            boolean status = productCategoryService.insertCategory(productCategory);
            //String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes()); //MD5加密方式
            //logger.info(String.valueOf(userList));
            if(status){
                return getModelMap(StateParameter.SUCCESS, "", "添加成功");
            }else{
                return getModelMap(StateParameter.FAULT, "", "添加失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "添加失败");
        }
    }
}
