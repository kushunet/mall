package cn.dnaizn.mall.pojo;

import java.io.Serializable;

public class OrderStatusList implements Serializable {
    private Integer id;

    private String orderId;

    private Integer status;

    private Integer cTime;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getcTime() {
        return cTime;
    }

    public void setcTime(Integer cTime) {
        this.cTime = cTime;
    }
}