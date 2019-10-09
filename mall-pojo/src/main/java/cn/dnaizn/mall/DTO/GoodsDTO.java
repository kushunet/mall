package cn.dnaizn.mall.DTO;


import cn.dnaizn.mall.pojo.Goods;
import cn.dnaizn.mall.pojo.GoodsDesc;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GoodsDTO implements Serializable {
    private Goods goods;//商品SPU基本信息
    private List<GoodsDesc> goodsDescList;//商品SKU信息
}
