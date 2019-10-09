package cn.dnaizn.mall.VO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import java.io.Serializable;

@Data
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class GoodsCatVO implements Serializable {
    private Integer id;
    private String name;
    private Integer parentId;
    private String sellerId;
    private Integer sortOrder;
    private Integer number;
}
