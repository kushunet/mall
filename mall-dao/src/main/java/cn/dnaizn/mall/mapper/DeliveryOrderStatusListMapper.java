package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.DeliveryOrderStatusList;
import cn.dnaizn.mall.pojo.DeliveryOrderStatusListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeliveryOrderStatusListMapper {
    int countByExample(DeliveryOrderStatusListExample example);

    int deleteByExample(DeliveryOrderStatusListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DeliveryOrderStatusList record);

    int insertSelective(DeliveryOrderStatusList record);

    List<DeliveryOrderStatusList> selectByExample(DeliveryOrderStatusListExample example);

    DeliveryOrderStatusList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DeliveryOrderStatusList record, @Param("example") DeliveryOrderStatusListExample example);

    int updateByExample(@Param("record") DeliveryOrderStatusList record, @Param("example") DeliveryOrderStatusListExample example);

    int updateByPrimaryKeySelective(DeliveryOrderStatusList record);

    int updateByPrimaryKey(DeliveryOrderStatusList record);
}