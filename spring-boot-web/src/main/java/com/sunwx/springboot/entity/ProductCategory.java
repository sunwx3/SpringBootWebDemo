package com.sunwx.springboot.entity;

import java.io.Serializable;

public class ProductCategory implements Serializable {
    private static final long serialVersionUID = 22993759801708311L;

    /**
     * pms_product_category.id: 
     * <p>
     */
    private Long id;

    /**
     * pms_product_category.parent_id: 
     * <p>
     * <code>
     * 上机分类的编号：0表示一级分类<br>
     * </code>
     */
    private Long parentId;

    /**
     * pms_product_category.name: 
     * <p>
     */
    private String name;

    /**
     * pms_product_category.level: 
     * <p>
     * <code>
     * 分类级别：0->1级；1->2级<br>
     * </code>
     */
    private Integer level;

    /**
     * pms_product_category.product_count: 
     * <p>
     */
    private Integer productCount;

    /**
     * pms_product_category.product_unit: 
     * <p>
     */
    private String productUnit;

    /**
     * pms_product_category.nav_status: 
     * <p>
     * <code>
     * 是否显示在导航栏：0->不显示；1->显示<br>
     * </code>
     */
    private Integer navStatus;

    /**
     * pms_product_category.show_status: 
     * <p>
     * <code>
     * 显示状态：0->不显示；1->显示<br>
     * </code>
     */
    private Integer showStatus;

    /**
     * pms_product_category.sort: 
     * <p>
     */
    private Integer sort;

    /**
     * pms_product_category.icon: 
     * <p>
     * <code>
     * 图标<br>
     * </code>
     */
    private String icon;

    /**
     * pms_product_category.keywords: 
     * <p>
     */
    private String keywords;

    /**
     * pms_product_category.description: 
     * <p>
     * <code>
     * 描述<br>
     * </code>
     */
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit == null ? null : productUnit.trim();
    }

    public Integer getNavStatus() {
        return navStatus;
    }

    public void setNavStatus(Integer navStatus) {
        this.navStatus = navStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}