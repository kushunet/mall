package cn.dnaizn.mall.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class OrderItem implements Serializable {
    private Integer id;

    private Integer itemId;

    private String orderId;

    private String sellerId;

    private Integer skuId;

    private String title;

    private BigDecimal price;

    private Integer num;

    private BigDecimal totalFee;

    private String picPath;

}