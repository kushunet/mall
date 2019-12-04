package cn.dnaizn.mall.order.mq;

import cn.dnaizn.mall.pojo.OrderMain;
import cn.dnaizn.mall.service.OrderService;
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

@Component
public class afterSaleListener {
    @Reference
    SellerLocalService sellerLocalService;
    @Autowired
    OrderService orderService;

    @JmsListener(destination = "after_sale")
    public void afterSale(MapMessage mapMessage) {
        try {
            OrderMain orderMain = orderService.findOneOrderMain(mapMessage.getString("id"));
            Map<String, String> map = new HashMap<>();
            map.put("code", "9" + mapMessage.getString("code"));

            map.put("orderId", mapMessage.getString("id"));
            map.put("message", mapMessage.getString("message"));
            map.put("daySn", orderMain.getDaySn().toString());
            Object o = JSONObject.toJSONString(map);
            JSONObject jsonObject = JSON.parseObject(o.toString());
            System.out.println(jsonObject.toJSONString());

            sellerLocalService.send(orderMain.getSellerId(), jsonObject.toJSONString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
