package cn.dnaizn.mall.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDTO implements Serializable {
    //区域代码
    private long adcode;
    //省市区
    private String Address;
    //地址描述
    private String addressDetail;
    //定位
    private String location;
}
