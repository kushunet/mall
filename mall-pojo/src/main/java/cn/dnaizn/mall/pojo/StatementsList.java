package cn.dnaizn.mall.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StatementsList implements Serializable {
    private Integer id;

    private Integer statementsId;

    private String orderId;

    private String sellerId;

    private BigDecimal amount;

    private Date time;

    private Integer cTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatementsId() {
        return statementsId;
    }

    public void setStatementsId(Integer statementsId) {
        this.statementsId = statementsId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getcTime() {
        return cTime;
    }

    public void setcTime(Integer cTime) {
        this.cTime = cTime;
    }
}