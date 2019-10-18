package cn.dnaizn.mall.order;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;

/**
 * 消息监听类
 * @author Administrator
 */
@Component
public class OrderListener {
    @JmsListener(destination="order_status")
    public void sendOrder(MapMessage mapMessage){
        try {
            System.out.println("code=" + mapMessage.getString("code"));
            System.out.println("message=" + mapMessage.getString("message"));
            System.out.println("Id=" + mapMessage.getString("id"));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
