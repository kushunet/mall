package cn.dnaizn.mall.VO;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderItemVO implements Serializable {

    private String title;

    private BigDecimal price;

    private Integer num;

    private BigDecimal totalFee;

    private String picPath;
}
