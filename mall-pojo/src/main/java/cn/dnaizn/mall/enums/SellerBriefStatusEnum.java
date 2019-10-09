package cn.dnaizn.mall.enums;

import lombok.Getter;

import java.io.Serializable;

@Getter
public enum SellerBriefStatusEnum implements CodeEnum, Serializable {
    SELLER_DOWN(0, "关闭"),
    SELLER_UP(1, "开启"),
    ;
    private Integer code;
    private String message;

    SellerBriefStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
