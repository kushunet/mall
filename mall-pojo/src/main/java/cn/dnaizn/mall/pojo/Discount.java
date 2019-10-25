package cn.dnaizn.mall.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class Discount implements Serializable {
    private Integer id;

    private String uuid;

    private String sellerId;

    private String title;

    private Integer type;

    private Integer num;

    private Float discount;

    private Integer expire;

    private BigDecimal useMiniPrice;

    private BigDecimal maxDiscountPrice;

    private Integer isDelete;

}