package cn.dnaizn.mall.enums;


import lombok.Getter;

import java.io.Serializable;

/**
 * 商品状态
 */
@Getter
public enum ProductStatusEnum implements CodeEnum , Serializable {
    UP(0, "在架"),
    DOWN(1, "下架");
    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
