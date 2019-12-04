package cn.dnaizn.mall.enums;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author
 */
@Getter
public enum SellerExamineEnum implements CodeEnum, Serializable {
    /**
     * 商家申请修改
     */
    NOT_AUDIT(0,"未审核"),
    TURN_DOWN(1,"驳回"),
    PASS_AUDIT(2,"审核通过"),
    SHUT_DOWN(3,"关闭"),
    ;
    private Integer code;

    private String message;

    SellerExamineEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
