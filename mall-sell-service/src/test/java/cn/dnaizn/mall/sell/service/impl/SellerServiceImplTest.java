package cn.dnaizn.mall.sell.service.impl;

import cn.dnaizn.mall.mapper.PrinterMapper;
import cn.dnaizn.mall.mapper.SellerMapper;
import cn.dnaizn.mall.pojo.Printer;
import cn.dnaizn.mall.pojo.Seller;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerServiceImplTest {
    @Autowired
    PrinterMapper printerMapper;
    @Test
    public void findAll() {
        Printer printer = new Printer();
        printer.setSellerId("admin");
        printer.setPrinterId("111111111111");
        printerMapper.insert(printer);
        return;
    }
}