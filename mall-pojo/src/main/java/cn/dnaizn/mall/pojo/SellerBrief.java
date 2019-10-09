package cn.dnaizn.mall.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class SellerBrief implements Serializable {
    private String sellerId;

    private String nickName;

    private Integer status;

    private Integer deliveryStatus;

    private BigDecimal customerUnitPrice;

    private Integer monthlyQuantity;

    private BigDecimal score;

    private Integer category1Id;

    private Integer category2Id;

    private Integer category3Id;

    private String linkmanMobile;

    private String linkmanName;

    private String avatar;

    private Long adcode;

    private String location;

    private String address;

    private String addressDetail;

    private String album;

    private BigDecimal minprice;

    private Integer autoStatus;

    private BigDecimal deliverFee;

    private Integer deliverDiscount;

    private Object businessHours;

    private Integer isReserve;
}