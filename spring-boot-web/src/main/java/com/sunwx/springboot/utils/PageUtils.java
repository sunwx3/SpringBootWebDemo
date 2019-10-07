package com.sunwx.springboot.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunwx.springboot.vo.ResEnv;

import java.util.ArrayList;
import java.util.List;

public class PageUtils {
    public static <T> ResEnv<List<T>> toResEnv(List<T> list) {
        if (list == null)
            return ResEnv.success();

        Long total;
        int pageNum;
        int pageSize;
        int pages;
        List<T> results;
        if (list instanceof Page) {
            Page<T> page = (Page) list;
            total = page.getTotal();
            pageNum = page.getPageNum();
            pageSize = page.getPageSize();
            pages = page.getPages();
            results = page.getResult();
        } else {
            total = (long) list.size();
            pageNum = 1;
            pageSize = list.size();
            pages = pageNum;
            results = list;
        }
        ResEnv<List<T>> resEnv = ResEnv.success(results);
        resEnv.setTotal(total);
        resEnv.setPageNum(pageNum);
        resEnv.setPageSize(pageSize);
        resEnv.setPages(pages);
        return resEnv;
    }

    /**
     * 分页参数设置
     *
     * @param pageNum,<1时,默认为1
     * @param pageSize,<1时,默认最大值,即不分页
     */
    public static void setPageInfo(Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null) {
            return;
        }
        if (pageNum < 1) {
            pageNum = 1;
        }
        if (pageSize > 0) {
            PageHelper.startPage(pageNum, pageSize);
        }

    }

}

