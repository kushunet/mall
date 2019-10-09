package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.GoodsDesc;
import cn.dnaizn.mall.pojo.GoodsDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsDescMapper {
    int countByExample(GoodsDescExample example);

    int deleteByExample(GoodsDescExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsDesc record);

    int insertSelective(GoodsDesc record);

    List<GoodsDesc> selectByExample(GoodsDescExample example);

    GoodsDesc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsDesc record, @Param("example") GoodsDescExample example);

    int updateByExample(@Param("record") GoodsDesc record, @Param("example") GoodsDescExample example);

    int updateByPrimaryKeySelective(GoodsDesc record);

    int updateByPrimaryKey(GoodsDesc record);
}