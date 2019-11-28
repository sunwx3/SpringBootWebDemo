package com.sunwx.springboot.controller;

import com.sunwx.springboot.entity.Product;
import com.sunwx.springboot.service.ProductService;
import com.sunwx.springboot.utils.FileUtils;
import com.sunwx.springboot.utils.StateParameter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
@Api("上传图片")
@RestController
public class FileUploadController extends BaseController {

    private final ResourceLoader resourceLoader;
    @Autowired
    public FileUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    @Autowired
    private ProductService productService;
    @ApiOperation(value = "上传图片",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",dataType="integer",
                    name="data",value="" +
                    "	\n file 文件"
                   // required=true
                    //defaultValue="{\"user_name\":\"\",\"passwd\":\"\",\"validCode\":\"\"}"
            )
    })
    @RequestMapping("/fileUpload")
    public ModelMap upload(@RequestParam("fileName") MultipartFile file, Product product, HttpServletRequest request){
        //判断文件时是否为空
        if (file.isEmpty()){
            return getModelMap(StateParameter.SUCCESS, "file is empty.文件是空的", "上传失败");
        }
        String originalFilename = file.getOriginalFilename();
        String newName = FileUtils.getFileName(originalFilename);
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
            File upload = new File(path.getAbsolutePath(), "static/tmpupload/");
            System.out.println(upload);
            if (!upload.exists()) upload.mkdirs();
            if (FileUtils.upload(file, String.valueOf(upload), newName)){
                // 上传成功，给出页面提示
                product.setPic(String.valueOf(upload));
                productService.uploadPicture(product);//存到数据库
                return getModelMap(StateParameter.SUCCESS, "", "上传成功");
            }else {
                return getModelMap(StateParameter.SUCCESS, "", "上传失败");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
