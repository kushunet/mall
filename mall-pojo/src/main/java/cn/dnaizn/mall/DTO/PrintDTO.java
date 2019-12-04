package cn.dnaizn.mall.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class PrintDTO {

    private String pos_id;

    private String title;

    private String thrid_id;

    private Integer serial_id;

    private Integer platform_type;

    private String[] information_offers;

    private List<GoodsPrintDto> goodsPrintDtoList;

    private BigDecimal total;

    private String address;

    private String name;

    private String remarks;

    private String platform_type_ext;

    private String phone;
}
