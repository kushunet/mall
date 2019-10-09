package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.SellerBrief;
import cn.dnaizn.mall.pojo.SellerBriefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SellerBriefMapper {
    int countByExample(SellerBriefExample example);

    int deleteByExample(SellerBriefExample example);

    int deleteByPrimaryKey(String sellerId);

    int insert(SellerBrief record);

    int insertSelective(SellerBrief record);

    List<SellerBrief> selectByExample(SellerBriefExample example);

    SellerBrief selectByPrimaryKey(String sellerId);

    int updateByExampleSelective(@Param("record") SellerBrief record, @Param("example") SellerBriefExample example);

    int updateByExample(@Param("record") SellerBrief record, @Param("example") SellerBriefExample example);

    int updateByPrimaryKeySelective(SellerBrief record);

    int updateByPrimaryKey(SellerBrief record);
}