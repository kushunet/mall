package cn.dnaizn.mall.VO;

import cn.dnaizn.mall.pojo.Seller;
import cn.dnaizn.mall.pojo.SellerBrief;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class SellerVO implements Serializable {
    private String name;

    private String nickName;

    private String email;

    private String mobile;

    private String telephone;

    private Integer deliveryStatus;

    private String addressDetail;

    private String linkmanName;

    private String linkmanQq;

    private String linkmanMobile;

    private String linkmanEmail;

    private String license;

    private String papers;

    private Long address;

    private String logoPic;

    private String brief;

    private String legalPerson;

    private String legalPersonCardId;

    private String legalPersonPic;

    private String bankName;

    private String bankUser;

    private Integer category1Id;

    private Integer category2Id;

    private Integer category3Id;

    private String avatar;

    private String album;

    private BigDecimal minprice;

    private Integer autoStatus;

    private BigDecimal deliverFee;

    private Integer deliverDiscount;

    private Object businessHours;

    private Integer isReserve;
}
