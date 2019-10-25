package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.OrderMain;
import cn.dnaizn.mall.pojo.OrderMainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMainMapper {
    int countByExample(OrderMainExample example);

    int deleteByExample(OrderMainExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(OrderMain record);

    int insertSelective(OrderMain record);

    List<OrderMain> selectByExample(OrderMainExample example);

    OrderMain selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") OrderMain record, @Param("example") OrderMainExample example);

    int updateByExample(@Param("record") OrderMain record, @Param("example") OrderMainExample example);

    int updateByPrimaryKeySelective(OrderMain record);

    int updateByPrimaryKey(OrderMain record);
}