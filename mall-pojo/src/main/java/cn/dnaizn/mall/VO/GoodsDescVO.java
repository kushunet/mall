package cn.dnaizn.mall.VO;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class GoodsDescVO implements Serializable {
    private Integer id;

    private Integer stock;

    private String title;

    private String introduction;

    private BigDecimal price;

    private BigDecimal packagefee;

    private Integer maxStock;

    private Byte isFill;

    private BigDecimal discount;

    private Byte isFullReduction;
}
