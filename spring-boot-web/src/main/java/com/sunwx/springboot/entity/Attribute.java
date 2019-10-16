package com.sunwx.springboot.entity;

import java.io.Serializable;

public class Attribute implements Serializable {
    private static final long serialVersionUID = 1547761882981414918L;

    /**
     * pms_product_attribute.id: 
     * <p>
     */
    private Long id;
    /**
     * pms_product_attribute.product_attribute_category_id: 
     * <p>
     */
    private Long productAttributeCategoryId;

    /**
     * pms_product_attribute.name: 
     * <p>
     */
    private String name;

    private String CategoryName;

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    /**
     * pms_product_attribute.select_type: 
     * <p>
     * <code>
     * 属性选择类型：0->唯一；1->单选；2->多选<br>
     * </code>
     */
    private Integer selectType;

    private String SelectTypee;

    /**
     * pms_product_attribute.input_type: 
     * <p>
     * <code>
     * 属性录入方式：0->手工录入；1->从列表中选取<br>
     * </code>
     */
    private Integer inputType;

    public String getSelectTypee() {
        return SelectTypee;
    }

    public void setSelectTypee(String selectTypee) {
        SelectTypee = selectTypee;
    }

    public String getInputTypee() {
        return InputTypee;
    }

    public void setInputTypee(String inputTypee) {
        InputTypee = inputTypee;
    }

    private String InputTypee;


    /**
     * pms_product_attribute.input_list: 
     * <p>
     * <code>
     * 可选值列表，以逗号隔开<br>
     * </code>
     */
    private String inputList;

    /**
     * pms_product_attribute.sort: 
     * <p>
     * <code>
     * 排序字段：最高的可以单独上传图片<br>
     * </code>
     */
    private Integer sort;

    /**
     * pms_product_attribute.filter_type: 
     * <p>
     * <code>
     * 分类筛选样式：1->普通；1->颜色<br>
     * </code>
     */
    private Integer filterType;

    /**
     * pms_product_attribute.search_type: 
     * <p>
     * <code>
     * 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索<br>
     * </code>
     */
    private Integer searchType;

    /**
     * pms_product_attribute.related_status: 
     * <p>
     * <code>
     * 相同属性产品是否关联；0->不关联；1->关联<br>
     * </code>
     */
    private Integer relatedStatus;

    /**
     * pms_product_attribute.hand_add_status: 
     * <p>
     * <code>
     * 是否支持手动新增；0->不支持；1->支持<br>
     * </code>
     */
    private Integer handAddStatus;

    /**
     * pms_product_attribute.type: 
     * <p>
     * <code>
     * 属性的类型；0->规格；1->参数<br>
     * </code>
     */
    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductAttributeCategoryId() {
        return productAttributeCategoryId;
    }

    public void setProductAttributeCategoryId(Long productAttributeCategoryId) {
        this.productAttributeCategoryId = productAttributeCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSelectType() {
        return selectType;
    }

    public void setSelectType(Integer selectType) {
        this.selectType = selectType;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public String getInputList() {
        return inputList;
    }

    public void setInputList(String inputList) {
        this.inputList = inputList == null ? null : inputList.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFilterType() {
        return filterType;
    }

    public void setFilterType(Integer filterType) {
        this.filterType = filterType;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public Integer getRelatedStatus() {
        return relatedStatus;
    }

    public void setRelatedStatus(Integer relatedStatus) {
        this.relatedStatus = relatedStatus;
    }

    public Integer getHandAddStatus() {
        return handAddStatus;
    }

    public void setHandAddStatus(Integer handAddStatus) {
        this.handAddStatus = handAddStatus;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Attribute(Long id, Long productAttributeCategoryId, String name, Integer selectType, Integer inputType, String inputList, Integer sort, Integer filterType, Integer searchType, Integer relatedStatus, Integer handAddStatus, Integer type) {
        this.id = id;
        this.productAttributeCategoryId = productAttributeCategoryId;
        this.name = name;
        this.selectType = selectType;
        this.inputType = inputType;
        this.inputList = inputList;
        this.sort = sort;
        this.filterType = filterType;
        this.searchType = searchType;
        this.relatedStatus = relatedStatus;
        this.handAddStatus = handAddStatus;
        this.type = type;
    }

    public Attribute() {
    }
}