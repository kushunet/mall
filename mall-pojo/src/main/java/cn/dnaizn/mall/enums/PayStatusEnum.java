package cn.dnaizn.mall.enums;

import lombok.Getter;

import java.io.Serializable;

/**
 * 支付状态
 */
@Getter
public enum PayStatusEnum implements CodeEnum , Serializable {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
