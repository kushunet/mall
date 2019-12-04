package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.SellerSetting;
import cn.dnaizn.mall.pojo.SellerSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SellerSettingMapper {
    int countByExample(SellerSettingExample example);

    int deleteByExample(SellerSettingExample example);

    int deleteByPrimaryKey(String sellerId);

    int insert(SellerSetting record);

    int insertSelective(SellerSetting record);

    List<SellerSetting> selectByExample(SellerSettingExample example);

    SellerSetting selectByPrimaryKey(String sellerId);

    int updateByExampleSelective(@Param("record") SellerSetting record, @Param("example") SellerSettingExample example);

    int updateByExample(@Param("record") SellerSetting record, @Param("example") SellerSettingExample example);

    int updateByPrimaryKeySelective(SellerSetting record);

    int updateByPrimaryKey(SellerSetting record);
}