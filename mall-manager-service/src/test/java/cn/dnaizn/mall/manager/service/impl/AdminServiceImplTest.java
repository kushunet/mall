package cn.dnaizn.mall.manager.service.impl;

import cn.dnaizn.mall.mapper.AdminMapper;
import cn.dnaizn.mall.pojo.Admin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminServiceImplTest {
    @Autowired
    AdminMapper adminMapper;
    @Test
    public void findOne() {
        Admin admin = adminMapper.selectByPrimaryKey("admin");
        Assert.assertEquals(admin,0);
    }
}