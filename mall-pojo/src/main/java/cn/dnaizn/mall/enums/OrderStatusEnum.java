package cn.dnaizn.mall.enums;

import lombok.Getter;

import java.io.Serializable;

/**
 * 订单状态
 */
@Getter
public enum OrderStatusEnum implements CodeEnum , Serializable {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
