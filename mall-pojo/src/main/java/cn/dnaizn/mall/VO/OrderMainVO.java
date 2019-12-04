package cn.dnaizn.mall.VO;

import cn.dnaizn.mall.pojo.OrderStatusList;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Data
public class OrderMainVO implements Serializable {

    private String orderId;

    private Integer daySn;

    private BigDecimal payment;

    private BigDecimal total;

    private Integer paymentType;

    private String postFee;

    private Byte isEvaluate;

    private Integer status;

    private Integer afterSale;

    private Date createTime;

    private Date updateTime;

    private Date paymentTime;

    private Date consignTime;

    private Date endTime;

    private Date closeTime;

    private String shippingName;

    private String shippingCode;

    private String buyerMessage;

    private String buyerNick;

    private Byte buyerRate;

    private String receiverAreaName;

    private String receiverMobile;

    private String receiverZipCode;

    private String receiver;

    private String receiverLocation;

    private Date expire;

    private Integer invoiceType;

    private Integer sourceType;

    private Integer reserveTime;

}
