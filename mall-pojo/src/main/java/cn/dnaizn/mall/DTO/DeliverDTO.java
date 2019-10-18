package cn.dnaizn.mall.DTO;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DeliverDTO implements Serializable {
    private BigDecimal minprice;

    private BigDecimal deliverFee;

    private BigDecimal deliverDiscount;

    private Integer autoStatus;

    private Integer isReserve;
}
