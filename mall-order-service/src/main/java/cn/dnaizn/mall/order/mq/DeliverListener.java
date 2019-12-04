package cn.dnaizn.mall.order.mq;

import cn.dnaizn.mall.service.OrderService;
import cn.dnaizn.mall.service.SellerLocalService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class DeliverListener {

    @Autowired
    OrderService orderService;

    @Reference
    SellerLocalService sellerLocalService;

    @JmsListener(destination = "deliver")
    public void deliver(MapMessage mapMessage) {
        try {
            System.out.println(new Date() + mapMessage.getString("orderId"));
            Object object = orderService.deliver(mapMessage.getString("orderId"), mapMessage.getString("type"));
            JSONObject jsonObject = JSON.parseObject(object.toString());
            Map<String, String> map = new HashMap<>();
            map.put("code", "23");
            map.put("message", "该订单已自动发起配送！！");
            if (jsonObject.getString("code").equals("0")){
                map.put("code", "0");
                map.put("message", jsonObject.getString("msg"));
            }
            map.put("orderId", mapMessage.getString("orderId"));
            Object o = JSONObject.toJSONString(map);
            JSONObject json = JSON.parseObject(o.toString());
            sellerLocalService.send(mapMessage.getString("sellerId"), json.toJSONString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
