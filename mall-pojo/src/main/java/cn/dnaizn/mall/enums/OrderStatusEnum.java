package cn.dnaizn.mall.enums;

import lombok.Getter;

import java.io.Serializable;

/**
 * 订单状态
 */
@Getter
public enum OrderStatusEnum implements CodeEnum, Serializable {
    PENDING_PAYMENT(1,"待付款"),
    PENDING_SHIPPED(2,"待发货"),
    PENDING_RECEIVED(3,"已发货"),
    ORDER_COMPLETE(5,"待收货"),
    ORDER_REFUND(6,"订单关闭"),
    ORDER_CLOSE(7,"订单完成"),
    ORDER_CANCEL(9,"申请退款"),
    ORDER_REFUNDED(10,"已取消"),
    SHIPPED(11,"已退款"),
    REFUSAL_OF_REFUND(12,"商家拒绝退款"),
    WAITING_FOR_ORDERS(13,"等待接单"),
    REFUNDING(14,"退款中"),
    ;

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
