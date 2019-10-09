package cn.dnaizn.mall.sell.service.Impl;

import cn.dnaizn.mall.pojo.Admin;
import cn.dnaizn.mall.service.AdminService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDetailsServiceImplTest {
    @Reference
    AdminService adminService;
    @Test
    public void  findAll(){
        Admin admin = adminService.findOne("admin");
        Assert.assertEquals(admin,0);
    }
}