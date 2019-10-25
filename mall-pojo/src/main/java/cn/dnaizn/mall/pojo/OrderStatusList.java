package cn.dnaizn.mall.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderStatusList implements Serializable {
    private Integer id;

    private String orderId;

    private Integer status;

    private Integer cTime;
}