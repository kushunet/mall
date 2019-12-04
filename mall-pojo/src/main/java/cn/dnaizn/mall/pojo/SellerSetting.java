package cn.dnaizn.mall.pojo;

import java.io.Serializable;

public class SellerSetting implements Serializable {
    private String sellerId;

    private Object setting;

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public Object getSetting() {
        return setting;
    }

    public void setSetting(Object setting) {
        this.setting = setting;
    }
}