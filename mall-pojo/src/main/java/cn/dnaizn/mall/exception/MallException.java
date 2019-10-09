package cn.dnaizn.mall.exception;

import cn.dnaizn.mall.enums.ResultEnum;

import java.io.Serializable;

public class MallException extends RuntimeException implements Serializable {
    private Integer code;

    public MallException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public MallException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
