package com.sunwx.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunwx.springboot.entity.SkuStock;
import com.sunwx.springboot.service.SkuStockService;
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
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/skuStock")
@Api(value = "对于商品sku的操作")
public class SkuStockController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Resource
    private SkuStockService skuStockService;
    @ApiOperation(value = "查询所有商品sku",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="integer",
                    name="data",value="" +
                    "	\n Pid 商品id",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    @RequestMapping("/selectByPid")
    public ResEnv<List<SkuStock>> selectByPid(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("data");
        List<SkuStock> skuStocks = skuStockService.selectByPid(Integer.valueOf(id));
        return PageUtils.toResEnv(skuStocks);
    }
    @ApiOperation(value = "根据货号查询商品sku",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="integer",
                    name="data",value="" +
                    "	\n skuCode 商品货号",
                    required=true
                   // defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}"
            )
    })
    @RequestMapping("/selectBySkuCode")
    public ResEnv<List<SkuStock>> selectBySkuCode(HttpServletRequest request, HttpServletResponse response){
        String skuCode = request.getParameter("data");
        /*logger.info(data);
        JSONObject jsonObject = JSONObject.parseObject(data);
        String skuCode = jsonObject.getString("skuCode");*/
        List<SkuStock> skuStocks = skuStockService.selectBySkuCode(skuCode);
        return PageUtils.toResEnv(skuStocks);
    }
    @ApiOperation(value = "根据id更新商品sku",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="integer",
                    name="data",value="" +
                    "	\n id skuId"+
                    "	\n price 商品价格"+
                    "	\n stock 商品库存"+
                    "	\n low_price 库存告警",
                    required=true
                    // defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}"
            )
    })
    @RequestMapping("/UpdateSkuCode")
    public ModelMap updateSkuCode(SkuStock skuStock){
        try {
            /*String data = request.getParameter("data");
            logger.info(data);
            JSONObject jsonObject = JSONObject.parseObject(data);
            String id = jsonObject.getString("id");
            String price = jsonObject.getString("price");
            String stock = jsonObject.getString("stock");
            String low_stock = jsonObject.getString("low_stock");
            SkuStock skuStock = new SkuStock();
            BigDecimal bd = new BigDecimal(price);//String转Decimal
            skuStock.setPrice(bd);
            skuStock.setId(Long.valueOf(id));
            skuStock.setStock(Integer.valueOf(stock));
            skuStock.setLowStock(Integer.valueOf(low_stock));*/
            boolean flag = skuStockService.updateSkuCode(skuStock);
            if (flag){
                return getModelMap(StateParameter.SUCCESS,"","修改成功");
            }else{
                return getModelMap(StateParameter.FAULT,"","修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "修改失败");
        }
    }
}
