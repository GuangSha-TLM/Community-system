package com.gsxy.core.controller;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/websocket")
public class WebSocketController {

    private static Set<Session> sessions = new HashSet<>();

    @OnOpen
    public void onOpen(Session session){
        System.out.println("WebSocket连接已建立");
    }

    @OnMessage
    public void onMessage(String message,Session session) throws IOException {
        System.out.println("收到消息: " + message);

        //处理签到请求
        //假设签到请求格式为: "签到: 用户名"
        if(message.startsWith("签到: ")){
            String username = message.substring(5);
            //记录签到信息，可以将签到信息存储在数据库中
            System.out.println(username + "已签到!");

            //发送签到响应
            String response = "你已签到" + username;
            session.getBasicRemote().sendText(response);

            //向所有连接的客户端广播签到信息
            broadcast(username + "已签到!");
        }

    }

    @OnClose
    public void onClose(Session session){
        System.out.println("WebSocket连接已关闭");
    }

    @OnError
    public void onError(Throwable error){
        System.out.println("WebSocket错误: " + error.getMessage());
    }

    //回显用户签到信息到客户端
    private void broadcast(String message){
        for (Session session : sessions) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
