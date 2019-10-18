package cn.dnaizn.mall.order;

import cn.dnaizn.mall.mq.ActiveMQUtil;
import cn.dnaizn.mall.util.RedisUtil;
import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import javax.jms.*;

public class Sub implements Runnable  {

    private String channelName;
    private RedisUtil redisUtil;
    private ActiveMQUtil activeMQUtil;

    public Sub(String channelName, RedisUtil redisUtil, ActiveMQUtil activeMQUtil) {
        super();
        this.channelName = channelName;
        this.redisUtil = redisUtil;
        this.activeMQUtil = activeMQUtil;
    }

    @Override
    public void run() {
        Jedis jedis = redisUtil.getJedis();
        jedis.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                super.onMessage(channel, message);
                System.out.println(String.format("频道  %s,消息 %s",channel,message));
                JSONObject jsonObject = JSONObject.parseObject(message);
                JSONObject data = JSONObject.parseObject(jsonObject.getString("data"));
                //发送短信内容MQ
                ConnectionFactory connectionFactory = activeMQUtil.getConnectionFactory();
                try {
                    Connection connection = connectionFactory.createConnection();
                    connection.start();
                    //第一个值表示是否使用事务，如果选择true，第二个值相当于选择0
                    Session session = connection.createSession(true, Session.SESSION_TRANSACTED);//开启事务
                    Queue queue = session.createQueue(data.getString("type"));
                    MessageProducer producer = session.createProducer(queue);
                    MapMessage mapMessage = session.createMapMessage();
                    mapMessage.setString("code",jsonObject.getString("status"));
                    mapMessage.setString("id",data.getString("id"));
                    mapMessage.setString("message",data.getString("status_cn"));
                    producer.setDeliveryMode(DeliveryMode.PERSISTENT);
                    producer.send(mapMessage);
                    session.commit();//提交事务
                    connection.close();//关闭事务
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        },channelName);
    }
}
