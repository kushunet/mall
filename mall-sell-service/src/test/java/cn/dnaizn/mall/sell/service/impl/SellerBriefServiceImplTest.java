package cn.dnaizn.mall.sell.service.impl;

import cn.dnaizn.mall.mapper.SellerBriefMapper;
import cn.dnaizn.mall.pojo.SellerBrief;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerBriefServiceImplTest {
    @Autowired
    SellerBriefMapper sellerBriefMapper;
    @Test
    public void add() {
        SellerBrief sellerBrief = new SellerBrief();
        sellerBrief.setSellerId("51sx2356wqw");
        sellerBrief.setDeliveryStatus(1);
        sellerBriefMapper.insertSelective(sellerBrief);
    }
}