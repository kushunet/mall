package cn.dnaizn.mall.VO;

import cn.dnaizn.mall.pojo.OrderStatusList;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderVO implements Serializable {

    private OrderMainVO orderMainVO;

    private List<OrderItemVO> orderItemVOList;

    private List<OrdersAdjustmentVO> ordersAdjustmentVOList;

    private List<OrderStatusList> orderStatusListList;
}
