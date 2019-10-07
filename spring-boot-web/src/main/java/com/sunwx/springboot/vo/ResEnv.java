package com.sunwx.springboot.vo;


import com.sunwx.springboot.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class ResEnv<T> {
    private int status;

    private String msg;

    private T data;

    private Long total;
    private int pageNum;
    private int pageSize;
    private int pages;

    private final Map<String, Object> options = new HashMap<>();

    public static <T> ResEnv<T> success(String msg, T object) {
        return new ResEnv<>(Constants.RES_CODE_OK, msg, object);
    }

    public static <T> ResEnv<T> success(String msg) {
        return new ResEnv<>(Constants.RES_CODE_OK, msg, null);
    }

    public static <T> ResEnv<T> success(T object) {
        return new ResEnv<>(Constants.RES_CODE_OK, Constants.DEF_SUCC_MSG, object);
    }

    public static <T> ResEnv<T> success() {
        return success(Constants.DEF_SUCC_MSG);
    }

    public static <T> ResEnv<T> fail(String msg) {
        return new ResEnv<>(Constants.RES_CODE_ERROR, msg, null);
    }

    public static <T> ResEnv<T> fail() {
        return fail(Constants.DEF_FAIL_MSG);
    }

    public ResEnv() {
    }

    public ResEnv(int status) {
        this();
        this.status = status;
    }

    public ResEnv(int status, String msg) {
        this(status);
        this.msg = msg;
    }

    public ResEnv(int status, String msg, T data) {
        this(status, msg);
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public ResEnv setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResEnv setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResEnv setData(T data) {
        this.data = data;
        return this;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public ResEnv addOption(String key, Object value) {
        options.put(key, value);
        return this;
    }

    public <T> T getOption(String key) {
        return (T) options.get(key);
    }

    public boolean hasOption(String key) {
        return options.containsKey(key);
    }
}
