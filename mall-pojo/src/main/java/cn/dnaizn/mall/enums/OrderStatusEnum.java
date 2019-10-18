package cn.dnaizn.mall.enums;

import lombok.Getter;

import java.io.Serializable;

/**
 * 订单状态
 */
@Getter
public enum OrderStatusEnum implements CodeEnum, Serializable {
    ORDER_CREATE(1, "订单创建"),
    ORDER_PAYMENT_SUCCESS(2, "支付成功"),
    ORDER_PAYMENT_REFUND_SUCCESS(3, "退款成功"),
    ORDER_DELIVER_WAITING_FOR_DELIVERY(4, "等待骑手取货"),
    ORDER_DELIVER_STATUS_ARRIVAL(5, "骑手到店"),
    ORDER_DELIVER_STATUS_DISTRIBUTION(6, "配送中"),
    ORDER_DELIVER_STATUS_COMPLETE(7, "已送达"),
    STATUS_WAITING_FOR_ORDERS(8, "发起配送"),
    ;
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
