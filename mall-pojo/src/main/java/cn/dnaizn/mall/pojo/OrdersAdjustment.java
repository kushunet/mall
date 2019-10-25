package cn.dnaizn.mall.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class OrdersAdjustment implements Serializable {
    private Integer id;

    private String orderId;

    private String title;

    private String discountId;

    private Integer type;

    private BigDecimal fee;

    private Integer cTime;

    private Object discountDesc;

}