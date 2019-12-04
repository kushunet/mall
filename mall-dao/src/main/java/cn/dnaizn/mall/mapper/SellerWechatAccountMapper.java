package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.SellerWechatAccount;
import cn.dnaizn.mall.pojo.SellerWechatAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SellerWechatAccountMapper {
    int countByExample(SellerWechatAccountExample example);

    int deleteByExample(SellerWechatAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SellerWechatAccount record);

    int insertSelective(SellerWechatAccount record);

    List<SellerWechatAccount> selectByExample(SellerWechatAccountExample example);

    SellerWechatAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SellerWechatAccount record, @Param("example") SellerWechatAccountExample example);

    int updateByExample(@Param("record") SellerWechatAccount record, @Param("example") SellerWechatAccountExample example);

    int updateByPrimaryKeySelective(SellerWechatAccount record);

    int updateByPrimaryKey(SellerWechatAccount record);
}