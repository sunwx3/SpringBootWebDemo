package com.sunwx.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.sun.deploy.net.HttpResponse;
import com.sunwx.springboot.entity.Attribute;
import com.sunwx.springboot.entity.AttributeCategory;
import com.sunwx.springboot.service.AttributeCategoryService;
import com.sunwx.springboot.service.AttributeService;
import com.sunwx.springboot.utils.PageUtils;
import com.sunwx.springboot.utils.StateParameter;
import com.sunwx.springboot.vo.ResEnv;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.HttpResource;

import javax.annotation.Resource;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api("对于商品属性的操作" )
@RequestMapping("/attribute")
public class AttributeController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(AttributeCategoryController.class);
    @Resource
    private AttributeService attributeService;
    @ApiOperation(value = "根据属性类型Id查询所有商品属性",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="integer",
                    name="data",value="" +
                    "	\n pageNum 页码"+
                    "   \n pageSize 每页数目",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    @RequestMapping("/selectAttributeById")
    public ResEnv<List<Attribute>> selectAttributeById(Integer id ,Integer pageNum,Integer pageSize){
        PageUtils.setPageInfo(pageNum,pageSize);
        List<Attribute> attributes = attributeService.selectAttributeByACId(id);
        Object json = JSONObject.toJSON(attributes);
        System.out.println(json);
        logger.info(json.toString());
        return PageUtils.toResEnv(attributes);
    }
    @ApiOperation(value = "新增商品属性",httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="integer",
                    name="data",value="" +
                    "	\n product_attribute_category_id  商品属性分类"+
                    "   \n name  名称"+
                    "   \n select_type  属性选择类型：0->唯一；1->单选；2->多选；对应属性和参数意义不同；"+
                    "   \n input_list 可选值列表，以逗号隔开"+
                    "   \n sort  排序字段：最高的可以单独上传图片"+
                    "   \n filter_type  分类筛选样式：1->普通；1->颜色"+
                    "   \n related_status  相同属性产品是否关联；0->不关联；1->关联"+
                    "   \n hand_add_status  是否支持手动新增；0->不支持；1->支持"+
                    "   \n type  属性的类型；0->规格；1->参数",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    @RequestMapping("/insertAttribute")
    public ModelMap insertAttribute(Attribute attribute){
        try {
            boolean status = attributeService.insertAttribute(attribute);
            Object json = JSONObject.toJSON(attribute);
            if(status){
                return getModelMap(StateParameter.SUCCESS, json, "插入成功");
            }else{
                return getModelMap(StateParameter.FAULT, "", "插入失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "插入失败");
        }
    }
    @ApiOperation(value = "修改商品属性",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="integer",
                    name="data",value="" +
                    "	\n product_attribute_category_id  商品属性分类"+
                    "   \n name  名称"+
                    "   \n select_type  属性选择类型：0->唯一；1->单选；2->多选；对应属性和参数意义不同；"+
                    "   \n input_list 可选值列表，以逗号隔开"+
                    "   \n sort  排序字段：最高的可以单独上传图片"+
                    "   \n filter_type  分类筛选样式：1->普通；1->颜色"+
                    "   \n related_status  相同属性产品是否关联；0->不关联；1->关联"+
                    "   \n hand_add_status  是否支持手动新增；0->不支持；1->支持"+
                    "   \n type  属性的类型；0->规格；1->参数",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    @RequestMapping("/updateAttribute")
    public ModelMap updateAttribute(Attribute attribute){
        try {
            boolean status = attributeService.updateAttribute(attribute);
            Object json = JSONObject.toJSON(attribute);
            if(status){
                return getModelMap(StateParameter.SUCCESS, json, "修改成功");
            }else{
                return getModelMap(StateParameter.FAULT, "", "修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "修改失败");
        }
    }
    @ApiOperation(value = "批量删除商品属性",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="String",
                    name="data",value="" +
                    "	\n id  商品属性id",
                    required=true,
                    defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}")
    })
    @RequestMapping("/deleteByBanchId")
    public ModelMap deleteByBanchId(HttpServletRequest request, HttpServletResponse response){
        try {
            String ids = request.getParameter("id");
            List<Integer> Ids=new ArrayList<>();
            String params[] = ids.split(",");
            for (int i = 0; i < params.length; i++) {
                Ids.add(Integer.valueOf(params[i]));
            }
            boolean status = attributeService.deleteByBanchId(Ids);
           // Object json = JSONObject.toJSON(attribute);
            if(status){
                return getModelMap(StateParameter.SUCCESS, "删除条数:"+ Ids.size(), "删除成功");
            }else{
                return getModelMap(StateParameter.FAULT, "", "删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "删除失败");
        }
    }

}
