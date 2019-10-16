package com.sunwx.springboot.controller;

import com.github.pagehelper.Page;
import com.sunwx.springboot.entity.Attribute;
import com.sunwx.springboot.entity.AttributeCategory;
import com.sunwx.springboot.service.AttributeCategoryService;
import com.sunwx.springboot.service.AttributeService;
import com.sunwx.springboot.utils.PageUtils;
import com.sunwx.springboot.vo.ResEnv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/attribute")
public class AttributeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AttributeCategoryController.class);
    @Resource
    private AttributeService attributeService;
    @RequestMapping("/selectAttributeById")
    public ResEnv<List<Attribute>> selectAttributeById(Integer id){
        List<Attribute> attributes = attributeService.selectAttributeByACId(id);
        return PageUtils.toResEnv(attributes);
    }
}
