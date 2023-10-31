package com.gsxy.core.controller;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/websocket")
public class WebSocketController {

    @OnOpen
    public void onOpen(Session session){
        System.out.println("WebSocket连接已建立");
    }

    @OnMessage
    public void onMessage(String message,Session session) throws IOException {
        System.out.println("收到消息: " + message);
        session.getBasicRemote().sendText("服务器收到消息: " + message);
    }

    @OnClose
    public void onClose(Session session){
        System.out.println("WebSocket连接已关闭");
    }

    @OnError
    public void onError(Throwable error){
        System.out.println("WebSocket错误: " + error.getMessage());
    }

}
