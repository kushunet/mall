package cn.dnaizn.mall.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class Incomes implements Serializable {
    private Integer id;

    private String ordersId;

    private String userId;

    private Integer userType;

    private Integer status;

    private Integer paymentType;

    private BigDecimal fee;

    private Integer time;

    private String desc;

}