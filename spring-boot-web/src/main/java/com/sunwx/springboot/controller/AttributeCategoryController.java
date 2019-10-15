package com.sunwx.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.sunwx.springboot.entity.AttributeCategory;
import com.sunwx.springboot.service.AttributeCategoryService;
import com.sunwx.springboot.utils.PageUtils;
import com.sunwx.springboot.utils.StateParameter;
import com.sunwx.springboot.vo.ResEnv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/attributeCategory")
public class AttributeCategoryController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(AttributeCategoryController.class);
    @Resource
    private AttributeCategoryService attributeCategoryService;
    @RequestMapping("/selectAllAttCat")
    public ResEnv<List<AttributeCategory>> selectAllAttCat(int pageNum,int pageSize) {
        Page page = new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        List<AttributeCategory> attributeCategories = attributeCategoryService.selectAllAttCag(page);
        return PageUtils.toResEnv(attributeCategories);
    }
    @RequestMapping("/updateAttCat")
    public ModelMap updateAttCat(AttributeCategory attributeCategory){
        try {
            boolean status = attributeCategoryService.updateAttCag(attributeCategory);
            Object json = JSONObject.toJSON(attributeCategory);
            if(status){
                return getModelMap(StateParameter.SUCCESS, "json", "修改成功");
            }else{
                return getModelMap(StateParameter.FAULT, "", "修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "修改失败");
        }
    }
    @RequestMapping("/insertAttCat")
    public ModelMap insertAttCat(AttributeCategory attributeCategory){
        try {
            boolean status = attributeCategoryService.insertAttCag(attributeCategory);
            Object json = JSONObject.toJSON(attributeCategory);
            if(status){
                return getModelMap(StateParameter.SUCCESS, "json", "添加成功");
            }else{
                return getModelMap(StateParameter.FAULT, "", "添加失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "添加失败");
        }
    }
    @RequestMapping("/deleteAttCat")
    public ModelMap deleteAttCat(Integer id){
        try {
            boolean status = attributeCategoryService.deleteAttCag(id);
            if(status){
                return getModelMap(StateParameter.SUCCESS, "json", "添加成功");
            }else{
                return getModelMap(StateParameter.FAULT, "", "添加失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "添加失败");
        }
    }
}
