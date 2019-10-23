package com.sunwx.springboot.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class SkuStock implements Serializable {
    private static final long serialVersionUID = 1547761882981414918L;

    /**
     * pms_sku_stock.id: 
     * <p>
     */
    private Long id;

    /**
     * pms_sku_stock.product_id: 
     * <p>
     * <code>
     * 商品id<br>
     * </code>
     */
    private Long productId;

    /**
     * pms_sku_stock.sku_code: 
     * <p>
     * <code>
     * sku编码<br>
     * </code>
     */
    private String skuCode;

    /**
     * pms_sku_stock.price: 
     * <p>
     * <code>
     * 价格<br>
     * </code>
     */
    private BigDecimal price;

    /**
     * pms_sku_stock.stock: 
     * <p>
     * <code>
     * 库存<br>
     * </code>
     */
    private Integer stock;

    /**
     * pms_sku_stock.low_stock: 
     * <p>
     * <code>
     * 预警库存<br>
     * </code>
     */
    private Integer lowStock;

    /**
     * pms_sku_stock.sp1: 
     * <p>
     * <code>
     * 规格属性1<br>
     * </code>
     */
    private String sp1;

    /**
     * pms_sku_stock.sp2: 
     * <p>
     * <code>
     * 规格属性2<br>
     * </code>
     */
    private String sp2;

    /**
     * pms_sku_stock.sp3: 
     * <p>
     * <code>
     * 规格属性3<br>
     * </code>
     */
    private String sp3;

    /**
     * pms_sku_stock.pic: 
     * <p>
     * <code>
     * 展示图片<br>
     * </code>
     */
    private String pic;

    /**
     * pms_sku_stock.sale: 
     * <p>
     * <code>
     * 销量<br>
     * </code>
     */
    private Integer sale;

    /**
     * pms_sku_stock.promotion_price: 
     * <p>
     * <code>
     * 单品促销价格<br>
     * </code>
     */
    private BigDecimal promotionPrice;

    /**
     * pms_sku_stock.lock_stock: 
     * <p>
     * <code>
     * 锁定库存<br>
     * </code>
     */
    private Integer lockStock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode == null ? null : skuCode.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public String getSp1() {
        return sp1;
    }

    public void setSp1(String sp1) {
        this.sp1 = sp1 == null ? null : sp1.trim();
    }

    public String getSp2() {
        return sp2;
    }

    public void setSp2(String sp2) {
        this.sp2 = sp2 == null ? null : sp2.trim();
    }

    public String getSp3() {
        return sp3;
    }

    public void setSp3(String sp3) {
        this.sp3 = sp3 == null ? null : sp3.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getLockStock() {
        return lockStock;
    }

    public void setLockStock(Integer lockStock) {
        this.lockStock = lockStock;
    }
}