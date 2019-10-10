package com.sunwx.springboot.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Product implements Serializable {
    private static final long serialVersionUID = 2576053085045652680L;

    /**
     * pms_product.id: 
     * <p>
     */
    private Long id;

    /**
     * pms_product.brand_id: 
     * <p>
     */
    private Long brandId;

    /**
     * pms_product.product_category_id: 
     * <p>
     */
    private Long productCategoryId;

    /**
     * pms_product.feight_template_id: 
     * <p>
     */
    private Long feightTemplateId;

    /**
     * pms_product.product_attribute_category_id: 
     * <p>
     */
    private Long productAttributeCategoryId;

    /**
     * pms_product.name: 
     * <p>
     */
    private String name;

    /**
     * pms_product.pic: 
     * <p>
     */
    private String pic;

    /**
     * pms_product.product_sn: 
     * <p>
     * <code>
     * 货号<br>
     * </code>
     */
    private String productSn;

    /**
     * pms_product.delete_status: 
     * <p>
     * <code>
     * 删除状态：0->未删除；1->已删除<br>
     * </code>
     */
    private Integer deleteStatus;

    /**
     * pms_product.publish_status: 
     * <p>
     * <code>
     * 上架状态：0->下架；1->上架<br>
     * </code>
     */
    private Integer publishStatus;

    /**
     * pms_product.new_status: 
     * <p>
     * <code>
     * 新品状态:0->不是新品；1->新品<br>
     * </code>
     */
    private Integer newStatus;

    /**
     * pms_product.recommand_status: 
     * <p>
     * <code>
     * 推荐状态；0->不推荐；1->推荐<br>
     * </code>
     */
    private Integer recommandStatus;

    /**
     * pms_product.verify_status: 
     * <p>
     * <code>
     * 审核状态：0->未审核；1->审核通过<br>
     * </code>
     */
    private Integer verifyStatus;

    /**
     * pms_product.sort: 
     * <p>
     * <code>
     * 排序<br>
     * </code>
     */
    private Integer sort;

    /**
     * pms_product.sale: 
     * <p>
     * <code>
     * 销量<br>
     * </code>
     */
    private Integer sale;

    /**
     * pms_product.price: 
     * <p>
     */
    private BigDecimal price;

    /**
     * pms_product.promotion_price: 
     * <p>
     * <code>
     * 促销价格<br>
     * </code>
     */
    private BigDecimal promotionPrice;

    /**
     * pms_product.gift_growth: 
     * <p>
     * <code>
     * 赠送的成长值<br>
     * </code>
     */
    private Integer giftGrowth;

    /**
     * pms_product.gift_point: 
     * <p>
     * <code>
     * 赠送的积分<br>
     * </code>
     */
    private Integer giftPoint;

    /**
     * pms_product.use_point_limit: 
     * <p>
     * <code>
     * 限制使用的积分数<br>
     * </code>
     */
    private Integer usePointLimit;

    /**
     * pms_product.sub_title: 
     * <p>
     * <code>
     * 副标题<br>
     * </code>
     */
    private String subTitle;

    /**
     * pms_product.original_price: 
     * <p>
     * <code>
     * 市场价<br>
     * </code>
     */
    private BigDecimal originalPrice;

    /**
     * pms_product.stock: 
     * <p>
     * <code>
     * 库存<br>
     * </code>
     */
    private Integer stock;

    /**
     * pms_product.low_stock: 
     * <p>
     * <code>
     * 库存预警值<br>
     * </code>
     */
    private Integer lowStock;

    /**
     * pms_product.unit: 
     * <p>
     * <code>
     * 单位<br>
     * </code>
     */
    private String unit;

    /**
     * pms_product.weight: 
     * <p>
     * <code>
     * 商品重量，默认为克<br>
     * </code>
     */
    private BigDecimal weight;

    /**
     * pms_product.preview_status: 
     * <p>
     * <code>
     * 是否为预告商品：0->不是；1->是<br>
     * </code>
     */
    private Integer previewStatus;

    /**
     * pms_product.service_ids: 
     * <p>
     * <code>
     * 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮<br>
     * </code>
     */
    private String serviceIds;

    /**
     * pms_product.keywords: 
     * <p>
     */
    private String keywords;

    /**
     * pms_product.note: 
     * <p>
     */
    private String note;

    /**
     * pms_product.album_pics: 
     * <p>
     * <code>
     * 画册图片，连产品图片限制为5张，以逗号分割<br>
     * </code>
     */
    private String albumPics;

    /**
     * pms_product.detail_title: 
     * <p>
     */
    private String detailTitle;

    /**
     * pms_product.promotion_start_time: 
     * <p>
     * <code>
     * 促销开始时间<br>
     * </code>
     */
    private Date promotionStartTime;

    /**
     * pms_product.promotion_end_time: 
     * <p>
     * <code>
     * 促销结束时间<br>
     * </code>
     */
    private Date promotionEndTime;

    /**
     * pms_product.promotion_per_limit: 
     * <p>
     * <code>
     * 活动限购数量<br>
     * </code>
     */
    private Integer promotionPerLimit;

    /**
     * pms_product.promotion_type: 
     * <p>
     * <code>
     * 促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购<br>
     * </code>
     */
    private Integer promotionType;

    /**
     * pms_product.brand_name: 
     * <p>
     * <code>
     * 品牌名称<br>
     * </code>
     */
    private String brandName;

    /**
     * pms_product.product_category_name: 
     * <p>
     * <code>
     * 商品分类名称<br>
     * </code>
     */
    private String productCategoryName;

    /**
     * pms_product.description: 
     * <p>
     * <code>
     * 商品描述<br>
     * </code>
     */
    private String description;

    /**
     * pms_product.detail_desc: 
     * <p>
     */
    private String detailDesc;

    /**
     * pms_product.detail_html: 
     * <p>
     * <code>
     * 产品详情网页内容<br>
     * </code>
     */
    private String detailHtml;

    /**
     * pms_product.detail_mobile_html: 
     * <p>
     * <code>
     * 移动端网页详情<br>
     * </code>
     */
    private String detailMobileHtml;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getFeightTemplateId() {
        return feightTemplateId;
    }

    public void setFeightTemplateId(Long feightTemplateId) {
        this.feightTemplateId = feightTemplateId;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn == null ? null : productSn.trim();
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    public Integer getRecommandStatus() {
        return recommandStatus;
    }

    public void setRecommandStatus(Integer recommandStatus) {
        this.recommandStatus = recommandStatus;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getGiftGrowth() {
        return giftGrowth;
    }

    public void setGiftGrowth(Integer giftGrowth) {
        this.giftGrowth = giftGrowth;
    }

    public Integer getGiftPoint() {
        return giftPoint;
    }

    public void setGiftPoint(Integer giftPoint) {
        this.giftPoint = giftPoint;
    }

    public Integer getUsePointLimit() {
        return usePointLimit;
    }

    public void setUsePointLimit(Integer usePointLimit) {
        this.usePointLimit = usePointLimit;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getLowStock() {
        return lowStock;
    }

    public void setLowStock(Integer lowStock) {
        this.lowStock = lowStock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getPreviewStatus() {
        return previewStatus;
    }

    public void setPreviewStatus(Integer previewStatus) {
        this.previewStatus = previewStatus;
    }

    public String getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(String serviceIds) {
        this.serviceIds = serviceIds == null ? null : serviceIds.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getAlbumPics() {
        return albumPics;
    }

    public void setAlbumPics(String albumPics) {
        this.albumPics = albumPics == null ? null : albumPics.trim();
    }

    public String getDetailTitle() {
        return detailTitle;
    }

    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle == null ? null : detailTitle.trim();
    }

    public Date getPromotionStartTime() {
        return promotionStartTime;
    }

    public void setPromotionStartTime(Date promotionStartTime) {
        this.promotionStartTime = promotionStartTime;
    }

    public Date getPromotionEndTime() {
        return promotionEndTime;
    }

    public void setPromotionEndTime(Date promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }

    public Integer getPromotionPerLimit() {
        return promotionPerLimit;
    }

    public void setPromotionPerLimit(Integer promotionPerLimit) {
        this.promotionPerLimit = promotionPerLimit;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName == null ? null : productCategoryName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc == null ? null : detailDesc.trim();
    }

    public String getDetailHtml() {
        return detailHtml;
    }

    public void setDetailHtml(String detailHtml) {
        this.detailHtml = detailHtml == null ? null : detailHtml.trim();
    }

    public String getDetailMobileHtml() {
        return detailMobileHtml;
    }

    public void setDetailMobileHtml(String detailMobileHtml) {
        this.detailMobileHtml = detailMobileHtml == null ? null : detailMobileHtml.trim();
    }
}