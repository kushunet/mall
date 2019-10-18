package cn.dnaizn.mall.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Discount implements Serializable {
    private Integer id;

    private String uuid;

    private String sellerId;

    private String title;

    private Integer type;

    private Integer num;

    private Float discount;

    private Integer expire;

    private BigDecimal useMiniPrice;

    private BigDecimal maxDiscountPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }

    public BigDecimal getUseMiniPrice() {
        return useMiniPrice;
    }

    public void setUseMiniPrice(BigDecimal useMiniPrice) {
        this.useMiniPrice = useMiniPrice;
    }

    public BigDecimal getMaxDiscountPrice() {
        return maxDiscountPrice;
    }

    public void setMaxDiscountPrice(BigDecimal maxDiscountPrice) {
        this.maxDiscountPrice = maxDiscountPrice;
    }
}