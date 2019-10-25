package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.DeliveryOrder;
import cn.dnaizn.mall.pojo.DeliveryOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeliveryOrderMapper {
    int countByExample(DeliveryOrderExample example);

    int deleteByExample(DeliveryOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DeliveryOrder record);

    int insertSelective(DeliveryOrder record);

    List<DeliveryOrder> selectByExample(DeliveryOrderExample example);

    DeliveryOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DeliveryOrder record, @Param("example") DeliveryOrderExample example);

    int updateByExample(@Param("record") DeliveryOrder record, @Param("example") DeliveryOrderExample example);

    int updateByPrimaryKeySelective(DeliveryOrder record);

    int updateByPrimaryKey(DeliveryOrder record);
}