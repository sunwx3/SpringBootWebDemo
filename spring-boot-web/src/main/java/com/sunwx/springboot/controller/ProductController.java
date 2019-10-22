package com.sunwx.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.sunwx.springboot.entity.Product;
import com.sunwx.springboot.service.ProductService;
import com.sunwx.springboot.service.serviceImpl.ProductServiceImpl;
import com.sunwx.springboot.utils.PageUtils;
import com.sunwx.springboot.utils.StateParameter;
import com.sunwx.springboot.vo.ResEnv;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

@RestController
@RequestMapping("product")
@Api(value = "对于商品的操作")
public class ProductController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Resource
    ProductService productService;
    @RequestMapping("selectAll")
    @ApiOperation(value = "查询所有商品",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="integer",
                    name="data",value="" +
                    "	\n pageNum 页码"+
                    "   \n pageSize 每页数目",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    public ResEnv<List<Product>> productList(int pageNum,int pageSize) {
        Page page = new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        return PageUtils.toResEnv(productService.selectAll(page));
    }
    @RequestMapping("selectBySome")
    @ApiOperation(value = "查询所有商品",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="integer",
                    name="data",value="" +
                    "	\n name 商品名称"+
                    "	\n productSn 商品名称"+
                    "	\n productCategoryId 类别名称"+
                    "	\n BrandId 品牌名称"+
                    "	\n publishStatus 上架状态"+
                    "	\n publishStatus 上架状态"+
                    "	\n verifyStatus 上架状态"+
                    "	\n pageNum 页码"+
                    "   \n pageSize 每页数目",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    public ResEnv<List<Product>> selectBySome(Product product,int pageNum,int pageSize) {
        PageUtils.setPageInfo(pageNum,pageSize);
        return PageUtils.toResEnv(productService.selectBySome(product));
    }
    @RequestMapping("deleteById")
    @ApiOperation(value = "查询所有商品",httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="list",
                    name="data",value="" +
                    "   \n id 编号",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    public ModelMap deleteById(HttpServletRequest request, HttpServletResponse response){
        try {
            String data = request.getParameter("data");
            JSONObject jsonObject = JSONObject.parseObject(data);
            String ids = jsonObject.getString("id");
            List<Integer> list = new ArrayList<Integer>();
            String[] params = ids.split(",");
            for (int i = 0 ;i <params.length;i++){
                list.add(Integer.valueOf(params[i]));
            }
            Boolean delete = productService.deleteByBanchId(list);
            if (delete){
                return getModelMap(StateParameter.SUCCESS,"","删除成功");
            }else{
                return getModelMap(StateParameter.FAULT,"","删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT,"","删除失败");
        }

    }
}
