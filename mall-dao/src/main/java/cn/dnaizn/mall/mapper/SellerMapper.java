package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.Seller;
import cn.dnaizn.mall.pojo.SellerExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SellerMapper {
    int countByExample(SellerExample example);

    int deleteByExample(SellerExample example);

    int deleteByPrimaryKey(String sellerId);

    int insert(Seller record);

    int insertSelective(Seller record);

    List<Seller> selectByExample(SellerExample example);

    Seller selectByPrimaryKey(String sellerId);

    int updateByExampleSelective(@Param("record") Seller record, @Param("example") SellerExample example);

    int updateByExample(@Param("record") Seller record, @Param("example") SellerExample example);

    int updateByPrimaryKeySelective(Seller record);

    int updateByPrimaryKey(Seller record);

    Seller findMobile(String mobile);
}