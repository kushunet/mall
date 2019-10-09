package cn.dnaizn.mall.VO;

import lombok.Data;

import java.io.Serializable;
@Data
public class TokenVO implements Serializable {
    String token;
    String authorities;
}
