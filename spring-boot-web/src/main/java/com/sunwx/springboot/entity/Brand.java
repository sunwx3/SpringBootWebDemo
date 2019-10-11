package com.sunwx.springboot.entity;

import java.io.Serializable;

public class Brand implements Serializable {
    private static final long serialVersionUID = 22993759801708311L;

    /**
     * pms_brand.id: 
     * <p>
     */
    private Long id;

    /**
     * pms_brand.name: 
     * <p>
     */
    private String name;

    /**
     * pms_brand.first_letter: 
     * <p>
     * <code>
     * 首字母<br>
     * </code>
     */
    private String firstLetter;

    /**
     * pms_brand.sort: 
     * <p>
     */
    private Integer sort;

    /**
     * pms_brand.factory_status: 
     * <p>
     * <code>
     * 是否为品牌制造商：0->不是；1->是<br>
     * </code>
     */
    private Integer factoryStatus;

    /**
     * pms_brand.show_status: 
     * <p>
     */
    private Integer showStatus;

    /**
     * pms_brand.product_count: 
     * <p>
     * <code>
     * 产品数量<br>
     * </code>
     */
    private Integer productCount;

    /**
     * pms_brand.product_comment_count: 
     * <p>
     * <code>
     * 产品评论数量<br>
     * </code>
     */
    private Integer productCommentCount;

    /**
     * pms_brand.logo: 
     * <p>
     * <code>
     * 品牌logo<br>
     * </code>
     */
    private String logo;

    /**
     * pms_brand.big_pic: 
     * <p>
     * <code>
     * 专区大图<br>
     * </code>
     */
    private String bigPic;

    /**
     * pms_brand.brand_story: 
     * <p>
     * <code>
     * 品牌故事<br>
     * </code>
     */
    private String brandStory;

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

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter == null ? null : firstLetter.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFactoryStatus() {
        return factoryStatus;
    }

    public void setFactoryStatus(Integer factoryStatus) {
        this.factoryStatus = factoryStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getProductCommentCount() {
        return productCommentCount;
    }

    public void setProductCommentCount(Integer productCommentCount) {
        this.productCommentCount = productCommentCount;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic == null ? null : bigPic.trim();
    }

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory == null ? null : brandStory.trim();
    }
}