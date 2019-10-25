package cn.dnaizn.mall.sell.service;

import cn.dnaizn.mall.sell.Jwt.JwtTokenUtils;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@ServerEndpoint(value = "/socket/{token}")
public class WebSocketServer {


    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static AtomicInteger online = new AtomicInteger();

    //concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
    private static Map<String, Map<String, Session>> sessionPools = new HashMap<>();

    /**
     * 发送消息方法
     *
     * @param session 客户端与socket建立的会话
     * @param message 消息
     * @throws IOException
     */
    public void sendMessage(Session session, String message) throws IOException {
        if (session != null) {
            session.getBasicRemote().sendText(message);
        }
    }

    /**
     * 连接建立成功调用
     *
     * @param session 客户端与socket建立的会话
     * @param token   客户端的token
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "token") String token) {
        String sellerId = JwtTokenUtils.getUsername(token);
        if (sessionPools.get(sellerId) == null) {
            Map<String, Session> sessionList = new HashMap<>();
            sessionPools.put(sellerId, sessionList);
        }
        Map<String, Session> sessionList = sessionPools.get(sellerId);

        sessionList.put(token, session);
        sessionPools.put(sellerId, sessionList);
        addOnlineCount();
        System.out.println(sellerId + "加入webSocket！当前人数为" + online);
        try {
            sendMessage(session, "欢迎" + sellerId + "加入连接！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接时调用
     *
     * @param token 关闭连接的客户端的姓名
     */
    @OnClose
    public void onClose(@PathParam(value = "token") String token) {
        String sellerId = JwtTokenUtils.getUsername(token);
        sessionPools.get(sellerId).remove(token);
        subOnlineCount();
        System.out.println(sellerId + "断开webSocket连接！当前人数为" + online);
    }

    /**
     * 收到客户端消息时触发（群发）
     *
     * @param message
     * @throws IOException
     */
    @OnMessage
    public void onMessage(Session session ,String message) throws IOException {
//        for (Map<String, Session> sessionList : sessionPools.values()) {
//            for (Session session : sessionList.values()) {
                try {
                    sendMessage(session, message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
//            }
//        }
    }

    /**
     * 发生错误时候
     *
     * @param session
     * @param throwable
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("发生错误");
        for (Map<String, Session> sessionMap : sessionPools.values()) {
            for (Map.Entry<String, Session> item : sessionMap.entrySet()) {
                if (item.getValue() == session) {
                    sessionMap.remove(item.getKey());
                }
            }
        }
        throwable.printStackTrace();
    }

    /**
     * 给指定用户发送消息
     *
     * @param userName 用户名
     * @param message  消息
     * @throws IOException
     */
    public void sendInfo(String userName, String message) {
        Map<String, Session> sessionList = sessionPools.get(userName);
        try {
            for (Session item : sessionList.values()) {
                sendMessage(item, message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addOnlineCount() {
        online.incrementAndGet();
    }

    public static void subOnlineCount() {
        online.decrementAndGet();
    }
}
