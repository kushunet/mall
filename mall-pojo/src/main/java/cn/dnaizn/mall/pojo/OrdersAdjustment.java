package cn.dnaizn.mall.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrdersAdjustment implements Serializable {
    private Integer id;

    private String orderId;

    private String title;

    private String discountId;

    private Integer type;

    private BigDecimal fee;

    private Integer cTime;

    private Object discountDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId == null ? null : discountId.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Integer getcTime() {
        return cTime;
    }

    public void setcTime(Integer cTime) {
        this.cTime = cTime;
    }

    public Object getDiscountDesc() {
        return discountDesc;
    }

    public void setDiscountDesc(Object discountDesc) {
        this.discountDesc = discountDesc;
    }
}