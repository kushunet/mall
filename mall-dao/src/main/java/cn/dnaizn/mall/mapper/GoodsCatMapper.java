package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.GoodsCat;
import cn.dnaizn.mall.pojo.GoodsCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsCatMapper {
    int countByExample(GoodsCatExample example);

    int deleteByExample(GoodsCatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsCat record);

    int insertSelective(GoodsCat record);

    List<GoodsCat> selectByExample(GoodsCatExample example);

    GoodsCat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsCat record, @Param("example") GoodsCatExample example);

    int updateByExample(@Param("record") GoodsCat record, @Param("example") GoodsCatExample example);

    int updateByPrimaryKeySelective(GoodsCat record);

    int updateByPrimaryKey(GoodsCat record);
}