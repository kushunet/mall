package cn.dnaizn.mall.pojo;

import java.io.Serializable;

public class FullReduction implements Serializable {
    private Integer id;

    private String sellerId;

    private Object reduction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public Object getReduction() {
        return reduction;
    }

    public void setReduction(Object reduction) {
        this.reduction = reduction;
    }
}