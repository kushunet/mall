package cn.dnaizn.mall.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserCoupons implements Serializable {
    private Integer id;

    private Integer userId;

    private String discountId;

    private String discountUuid;

    private Object discount;

    private Integer cTime;

    private Integer isDelete;

    private Integer expire;

}