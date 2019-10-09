package cn.dnaizn.mall.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class Seller implements Serializable {
    private String sellerId;

    private String name;

    private String nickName;

    private String password;

    private BigDecimal balance;

    private String email;

    private String mobile;

    private String telephone;

    private Integer status;

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

    private Date createTime;

    private String legalPerson;

    private String legalPersonCardId;

    private String legalPersonPic;

    private String bankName;

    private String bankUser;
}