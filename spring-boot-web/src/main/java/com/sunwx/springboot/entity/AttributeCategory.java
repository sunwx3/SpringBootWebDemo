package com.sunwx.springboot.entity;

import java.io.Serializable;

public class AttributeCategory implements Serializable {
    private static final long serialVersionUID = 1547761882981414918L;

    /**
     * pms_product_attribute_category.id: 
     * <p>
     */
    private Long id;

    /**
     * pms_product_attribute_category.name: 
     * <p>
     */
    private String name;

    /**
     * pms_product_attribute_category.attribute_count: 
     * <p>
     * <code>
     * 属性数量<br>
     * </code>
     */
    private Integer attributeCount;

    /**
     * pms_product_attribute_category.param_count: 
     * <p>
     * <code>
     * 参数数量<br>
     * </code>
     */
    private Integer paramCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAttributeCount() {
        return attributeCount;
    }

    public void setAttributeCount(Integer attributeCount) {
        this.attributeCount = attributeCount;
    }

    public Integer getParamCount() {
        return paramCount;
    }

    public void setParamCount(Integer paramCount) {
        this.paramCount = paramCount;
    }
}