package cn.dnaizn.mall.pojo;

import java.io.Serializable;

public class DeliveryOrderStatusList implements Serializable {
    private Integer id;

    private String deliveryId;

    private Integer status;

    private Integer cTime;

    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId == null ? null : deliveryId.trim();
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}