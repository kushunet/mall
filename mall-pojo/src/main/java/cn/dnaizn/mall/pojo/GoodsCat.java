package cn.dnaizn.mall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoodsCat implements Serializable {
    private Integer id;

    private String name;

    private Integer parentId;

    private String sellerId;

    private Integer sortOrder;

}