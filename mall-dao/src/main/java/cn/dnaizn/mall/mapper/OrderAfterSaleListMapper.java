package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.OrderAfterSaleList;
import cn.dnaizn.mall.pojo.OrderAfterSaleListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderAfterSaleListMapper {
    int countByExample(OrderAfterSaleListExample example);

    int deleteByExample(OrderAfterSaleListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderAfterSaleList record);

    int insertSelective(OrderAfterSaleList record);

    List<OrderAfterSaleList> selectByExample(OrderAfterSaleListExample example);

    OrderAfterSaleList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderAfterSaleList record, @Param("example") OrderAfterSaleListExample example);

    int updateByExample(@Param("record") OrderAfterSaleList record, @Param("example") OrderAfterSaleListExample example);

    int updateByPrimaryKeySelective(OrderAfterSaleList record);

    int updateByPrimaryKey(OrderAfterSaleList record);
}