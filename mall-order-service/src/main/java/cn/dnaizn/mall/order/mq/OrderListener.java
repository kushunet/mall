package cn.dnaizn.mall.order.mq;

import cn.dnaizn.mall.mq.ActiveMQUtil;
import cn.dnaizn.mall.pojo.OrderMain;
import cn.dnaizn.mall.pojo.SellerBrief;
import cn.dnaizn.mall.service.OrderService;
import cn.dnaizn.mall.service.SellerBriefService;
import cn.dnaizn.mall.service.SellerLocalService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.activemq.ScheduledMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.util.Arrays;
import java.util.Date;
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

    @Autowired
    ActiveMQUtil activeMQUtil;

    @JmsListener(destination = "order_status")
    public void orderStatus(MapMessage mapMessage) {
        Integer[] arr = new Integer[]{5, 6, 10, 11, 13};
        try {
            if (Arrays.asList(arr).contains(Integer.parseInt(mapMessage.getString("code")))) {
                OrderMain orderMain = orderService.findOneOrderMain(mapMessage.getString("id"));
                SellerBrief sellerBrief = sellerBriefService.findOne(orderMain.getSellerId());
                Map<String, String> map = new HashMap<>();
                map.put("code", mapMessage.getString("code"));
                map.put("message", mapMessage.getString("message"));
                map.put("orderId", mapMessage.getString("id"));
                map.put("daySn", orderMain.getDaySn().toString());
                Object o = JSONObject.toJSONString(map);
                JSONObject jsonObject = JSON.parseObject(o.toString());
                System.out.println(jsonObject.toJSONString());
                if (sellerBrief.getAutoStatus().toString().equals("1") && orderMain.getStatus().toString().equals("13")) {
                    System.out.println("-----------------------");
                    orderService.gen(orderMain.getOrderId());
                    //发送短信内容MQ
                    ConnectionFactory connectionFactory = activeMQUtil.getConnectionFactory();
                    try {
                        Connection connection = connectionFactory.createConnection();
                        connection.start();
                        //第一个值表示是否使用事务，如果选择true，第二个值相当于选择0
                        Session session = connection.createSession(true, Session.SESSION_TRANSACTED);//开启事务
                        Queue queue = session.createQueue("deliver");
                        MessageProducer producer = session.createProducer(queue);
                        MapMessage message = session.createMapMessage();
                        message.setString("orderId", orderMain.getOrderId());
                        message.setString("sellerId", sellerBrief.getSellerId());
                        message.setString("type", "send");
                        System.out.println(new Date());
                        message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, ((long) sellerBrief.getPrepare() * 60L * 1000L));
                        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
                        producer.send(message);
                        session.commit();//提交事务
                        connection.close();//关闭事务
                        orderService.create(orderMain.getOrderId(), sellerBrief.getSellerId());
                        orderService.printing(orderMain.getOrderId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                sellerLocalService.send(orderMain.getSellerId(), jsonObject.toJSONString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
