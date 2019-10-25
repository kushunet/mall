package cn.dnaizn.mall.sell.service.Impl;

import cn.dnaizn.mall.sell.service.WebSocketServer;
import cn.dnaizn.mall.service.SellerLocalService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SellerLocalServiceImpl implements SellerLocalService {

    @Autowired
    WebSocketServer webSocketServer;

    @Override
    public void send(String sellerId, String message) {
        webSocketServer.sendInfo(sellerId,message);
    }
}
