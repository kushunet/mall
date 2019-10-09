package cn.dnaizn.mall.redisson.redissontest;

import cn.dnaizn.mall.util.RedisUtil;
import jodd.util.StringUtil;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

@Controller
public class RedissonControlller {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    RedissonClient redissonClient;
    @RequestMapping("/testRedisson")
    @ResponseBody
    public String testRedisson(){
        Jedis jedis = redisUtil.getJedis();
        RLock lock = redissonClient.getLock("lock");//声明锁
        lock.lock();//上锁
        try {

            String v = jedis.get("k");
            if (StringUtil.isBlank(v)){
                v="1";
            }
            System.out.println(v);
            jedis.set("k",(Integer.parseInt(v)+1)+"");
            jedis.close();
        } finally {
            lock.unlock();
        }

        return "success";
    }
}
