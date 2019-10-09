package cn.dnaizn.mall.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsDesc implements Serializable {
    private Integer id;

    private Integer goodsId;

    private Integer stock;

    private String title;

    private String introduction;

    private BigDecimal price;

    private BigDecimal packagefee;

    private Long cTime;

    private Integer maxStock;

    private Byte isFill;

    private BigDecimal discount;

    private Byte isFullReduction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPackagefee() {
        return packagefee;
    }

    public void setPackagefee(BigDecimal packagefee) {
        this.packagefee = packagefee;
    }

    public Long getcTime() {
        return cTime;
    }

    public void setcTime(Long cTime) {
        this.cTime = cTime;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }

    public Byte getIsFill() {
        return isFill;
    }

    public void setIsFill(Byte isFill) {
        this.isFill = isFill;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Byte getIsFullReduction() {
        return isFullReduction;
    }

    public void setIsFullReduction(Byte isFullReduction) {
        this.isFullReduction = isFullReduction;
    }
}