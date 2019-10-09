package cn.dnaizn.mall.order;

import cn.dnaizn.mall.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

@Component
public class ConsumerService implements Runnable{
    @Autowired
    RedisUtil  redisUtil;

    @Override
    public void run() {
        Jedis jedis = redisUtil.getJedis();
        System.out.println("-----------消费者------------");
        jedis.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                super.onMessage(channel, message);
                System.out.println(message);
            }
        },"mall.message");
        System.out.println("-----------消费者------------");
    }
}

