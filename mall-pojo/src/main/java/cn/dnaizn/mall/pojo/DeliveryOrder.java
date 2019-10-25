package cn.dnaizn.mall.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class DeliveryOrder implements Serializable {
    private Integer id;

    private Integer userId;

    private String sellerId;

    private Integer status;

    private String orderId;

    private String deliveryId;

    private String thirdDeliveryId;

    private Integer adcode;

    private Integer cTime;

    private String cityName;

    private String startAddress;

    private String startPoint;

    private String baiduStartPoint;

    private String endAddress;

    private String endPoint;

    private String baiduEndPoint;

    private String sellerName;

    private String sellerPhone;

    private String userName;

    private String userPhone;

    private Object deliverInfo;

    private String remarks;

    private BigDecimal deliverFee;

}