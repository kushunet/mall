package cn.dnaizn.mall.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsPrintDto {

    private String title;

    private BigDecimal price;

    private Integer num;
}
