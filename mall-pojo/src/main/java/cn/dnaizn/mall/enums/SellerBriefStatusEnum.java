package cn.dnaizn.mall.enums;

import lombok.Getter;

import java.io.Serializable;

@Getter
public enum SellerBriefStatusEnum implements CodeEnum, Serializable {
    SELLER_DOWN(0, "商家关闭"),
    SELLER_UP(1, "商家开启"),
    SELLER_SEAL(2, "商家封杀"),
    SELLER_CREATE(3,"商家创建"),
    SELLER_UPDATA(4,"商家修改"),
    SELLER_DELETE(5,"商家删除"),
    ;
    private Integer code;
    private String message;

    SellerBriefStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
