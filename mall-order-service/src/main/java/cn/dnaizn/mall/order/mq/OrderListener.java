package cn.dnaizn.mall.order.mq;

import cn.dnaizn.mall.pojo.OrderMain;
import cn.dnaizn.mall.pojo.SellerBrief;
import cn.dnaizn.mall.service.OrderService;
import cn.dnaizn.mall.service.SellerBriefService;
import cn.dnaizn.mall.service.SellerLocalService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.MapMessage;
import java.util.HashMap;
import java.util.Map;


/**
 * 消息监听类
 *
 * @author Administrator
 */
@Component
public class OrderListener {
    @Reference
    SellerLocalService sellerLocalService;
    @Autowired
    OrderService orderService;
    @Reference
    SellerBriefService sellerBriefService;

    @JmsListener(destination = "order_status")
    public void orderStatus(MapMessage mapMessage) {
        try {
            OrderMain orderMain = orderService.findOneOrderMain(mapMessage.getString("id"));
            SellerBrief sellerBrief = sellerBriefService.findOne(orderMain.getSellerId());
            if (sellerBrief.getAutoStatus().equals(1)) {
                orderService.genDeliver(orderMain.getOrderId());
            }
            Map<String, String> map = new HashMap<>();
            map.put("code", mapMessage.getString("code"));
            map.put("message", mapMessage.getString("message"));
            map.put("id", mapMessage.getString("id"));
            Object o = JSONObject.toJSONString(map);
            JSONObject jsonObject = JSON.parseObject(o.toString());
            System.out.println(jsonObject.toJSONString());
            sellerLocalService.send(orderMain.getSellerId(), jsonObject.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
