package cn.dnaizn.mall.order.service.impl;

import cn.dnaizn.mall.mq.ActiveMQUtil;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMQServiceImplTest {
    @Autowired
    ActiveMQUtil activeMQUtil;
    private String channel="123";
    private String message="123";
    @Test
    public void admq() {
        //发送短信内容MQ
        ConnectionFactory connectionFactory = activeMQUtil.getConnectionFactory();
        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();
            //第一个值表示是否使用事务，如果选择true，第二个值相当于选择0
            Session session = connection.createSession(true, Session.SESSION_TRANSACTED);//开启事务
            Queue queue = session.createQueue(channel);
            MessageProducer producer = session.createProducer(queue);
            ObjectMessage objectMessage = session.createObjectMessage();
            objectMessage.setObject(message);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            producer.send(objectMessage);
            session.commit();//提交事务
            connection.close();//关闭事务
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}