package cn.dnaizn.mall.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeliveryOrderStatusList implements Serializable {
    private Integer id;

    private String deliveryId;

    private Integer status;

    private Integer cTime;

    private String desc;

}