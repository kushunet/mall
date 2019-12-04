package cn.dnaizn.mall.enums;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author lin
 */
@Getter
public enum RedisStatusEnum implements CodeEnum, Serializable {
    /**
     * 商家redis推荐
     */
    CREATE(0,"创建"),
    UPDATE(2,"修改"),
    DELETE(1,"删除"),
    ;
    private Integer code;
    private String message;

    RedisStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
