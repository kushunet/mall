package cn.dnaizn.mall.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Goods implements Serializable {
    private Integer id;

    private Integer topCategory;

    private Integer secondCategory;

    private String sellerId;

    private String title;

    private Integer isMarketable;

    private Long cTime;

    private Integer brandId;

    private String description;

    private String smallPic;

    private String images;

    private Integer isEnableSpec;

    private Integer isDelete;

    private Integer sortOrder;

    private Integer minPurchase;

    private Object labels;

    private Object properties;

}