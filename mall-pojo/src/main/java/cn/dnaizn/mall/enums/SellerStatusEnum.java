package cn.dnaizn.mall.enums;

import lombok.Getter;

import java.io.Serializable;
@Getter
public enum SellerStatusEnum implements CodeEnum, Serializable {
    NOT_AUDIT(0,"未审核"),
    PASS_AUDIT(1,"审核通过"),
    TURN_DOWN(2,"驳回"),
    SHUT_DOWN(3,"关闭"),
    ;
    private Integer code;

    private String message;

    SellerStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
