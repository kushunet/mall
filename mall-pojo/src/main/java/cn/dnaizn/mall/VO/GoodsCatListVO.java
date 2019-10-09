package cn.dnaizn.mall.VO;

import cn.dnaizn.mall.pojo.GoodsCat;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class GoodsCatListVO extends GoodsCatVO implements Serializable {
    private List<GoodsCat> goodsCatVOList;
}
