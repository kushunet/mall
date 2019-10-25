package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.OrderStatusList;
import cn.dnaizn.mall.pojo.OrderStatusListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderStatusListMapper {
    int countByExample(OrderStatusListExample example);

    int deleteByExample(OrderStatusListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderStatusList record);

    int insertSelective(OrderStatusList record);

    List<OrderStatusList> selectByExample(OrderStatusListExample example);

    OrderStatusList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderStatusList record, @Param("example") OrderStatusListExample example);

    int updateByExample(@Param("record") OrderStatusList record, @Param("example") OrderStatusListExample example);

    int updateByPrimaryKeySelective(OrderStatusList record);

    int updateByPrimaryKey(OrderStatusList record);
}