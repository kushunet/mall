package cn.dnaizn.mall.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by echisan on 2018/6/23
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class LoginDTO implements Serializable {
    //用户名
    private String username;
    //密码
    private String password;
    //是否记住
    private Integer rememberMe;
}
