package com.gsxy.core.controller;

import com.gsxy.core.pojo.bo.SignInAdminWebSocketBo;
import com.gsxy.core.pojo.bo.SignInWebSocketBo;
import com.gsxy.core.service.UserAdminService;
import com.gsxy.core.service.UserService;
import com.gsxy.core.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/websocket")
@CrossOrigin
@Component
@EnableScheduling
public class WebSocketController {

    private Set<Session> sessions = new HashSet<>();

    //    private UserAdminService userAdminService = SpringContextUtil.getBean(UserAdminService.class);
//    private UserService userService = SpringContextUtil.getBean(UserService.class);
    @Autowired
    private UserAdminService userAdminService;
    @Autowired
    private UserService userService;

    @OnOpen
    public void onOpen(Session session, @PathParam("signInAdminWebSocketBo") SignInAdminWebSocketBo signInAdminWebSocketBo) {
        sessions.add(session);
        userAdminService.adminSignInWeb(signInAdminWebSocketBo);
        System.out.println("签到已发起");
    }

    @OnMessage
    public void onMessage(String message, Session session, @PathParam("signInWebSocketBo") SignInWebSocketBo signInWebSocketBo) throws IOException {

        //处理签到请求
        if (message.startsWith("签到: ")) {
            String username = message.substring(5);

            //记录签到信息，可以将签到信息存储在数据库中
            userService.userSignInWebSocket(signInWebSocketBo);
            System.out.println(username + "已签到!");
            //发送签到响应
            String response = "你已签到" + username;
            session.getBasicRemote().sendText(response);

            //向所有连接的客户端广播签到信息
            broadcast(username + "已签到!");
        }

    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("WebSocket连接已关闭");
    }

    @OnError
    public void onError(Throwable error) {
        System.out.println("WebSocket错误: " + error.getMessage());
    }

    //回显用户签到信息到客户端
    private void broadcast(String message) {
        for (Session session : sessions) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
