package cn.dnaizn.mall.order.service.impl;

import cn.dnaizn.mall.mapper.OrderMainMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {
    @Autowired
    OrderMainMapper orderMapper;
    @Test
    public void findAll() {
        orderMapper.selectByExample(null);
        System.out.println("---------------------------");
    }
}