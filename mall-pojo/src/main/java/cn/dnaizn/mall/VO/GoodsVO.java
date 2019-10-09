package cn.dnaizn.mall.VO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GoodsVO implements Serializable {
    private Integer id;

    private String title;

    private Integer topCategory;

    private Integer secondCategory;

    private Integer isMarketable;

    private Integer brandId;

    private String description;

    private String smallPic;

    private String images;

    private Integer isEnableSpec;

    private Integer isDelete;

    private Integer sortOrder;

    private Integer minPurchase;

    private Object labels;

    private Object properties;

    private List<GoodsDescVO> list;
}
