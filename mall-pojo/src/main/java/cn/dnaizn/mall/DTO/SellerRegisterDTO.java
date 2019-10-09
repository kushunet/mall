package cn.dnaizn.mall.DTO;

import lombok.Data;

import java.io.Serializable;
@Data
public class SellerRegisterDTO implements Serializable {
    private String sellerId;
    private String password;
    private String mobile;
    private String code;
}
