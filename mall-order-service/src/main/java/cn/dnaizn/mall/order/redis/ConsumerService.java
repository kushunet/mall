package cn.dnaizn.mall.order.redis;

import cn.dnaizn.mall.mq.ActiveMQUtil;
import cn.dnaizn.mall.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService  implements ApplicationRunner{
    @Autowired
    RedisUtil  redisUtil;
    @Autowired
    ActiveMQUtil activeMQUtil;
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        new Thread(new Sub("mall.message",redisUtil,activeMQUtil)).start();
//        Jedis jedis = redisUtil.getJedis();
//        jedis.subscribe(new JedisPubSub() {
//            @Override
//            public void onMessage(String channel, String message) {
//                super.onMessage(channel, message);
//                activeMQService.admq(channel,message);
//            }
//        },"mall.message");
    }

}

