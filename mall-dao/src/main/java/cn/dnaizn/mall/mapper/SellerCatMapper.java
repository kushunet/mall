package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.SellerCat;
import cn.dnaizn.mall.pojo.SellerCatExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellerCatMapper {
    int countByExample(SellerCatExample example);

    int deleteByExample(SellerCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SellerCat record);

    int insertSelective(SellerCat record);

    List<SellerCat> selectByExample(SellerCatExample example);

    SellerCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SellerCat record, @Param("example") SellerCatExample example);

    int updateByExample(@Param("record") SellerCat record, @Param("example") SellerCatExample example);

    int updateByPrimaryKeySelective(SellerCat record);

    int updateByPrimaryKey(SellerCat record);
}