package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.OrdersAdjustment;
import cn.dnaizn.mall.pojo.OrdersAdjustmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersAdjustmentMapper {
    int countByExample(OrdersAdjustmentExample example);

    int deleteByExample(OrdersAdjustmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrdersAdjustment record);

    int insertSelective(OrdersAdjustment record);

    List<OrdersAdjustment> selectByExample(OrdersAdjustmentExample example);

    OrdersAdjustment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrdersAdjustment record, @Param("example") OrdersAdjustmentExample example);

    int updateByExample(@Param("record") OrdersAdjustment record, @Param("example") OrdersAdjustmentExample example);

    int updateByPrimaryKeySelective(OrdersAdjustment record);

    int updateByPrimaryKey(OrdersAdjustment record);
}