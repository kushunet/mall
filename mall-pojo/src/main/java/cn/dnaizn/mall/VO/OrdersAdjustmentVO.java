package cn.dnaizn.mall.VO;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrdersAdjustmentVO implements Serializable {

    private String title;

    private Integer type;

    private BigDecimal fee;

    private Object discountDesc;
}
