package com.gsxy.core.controller;

import com.gsxy.core.mapper.UserAdminMapper;
import com.gsxy.core.mapper.UserMapper;
import com.gsxy.core.pojo.SignInAdminWebSocket;
import com.gsxy.core.pojo.bo.SignInAdminWebSocketBo;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/websocket")
@CrossOrigin
@Component
public class WebSocketController {

    private static Set<Session> sessions = new HashSet<>();
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserAdminMapper userAdminMapper;
    private SignInAdminWebSocketBo socketBo =  new SignInAdminWebSocketBo();

    @OnOpen
    public void onOpen(Session session){
        System.out.println("签到已发起");
        userAdminMapper.insertSignInAdminWebSocket(socketBo);
    }

    /**
     * @author hln 2023-11-06
     *      管理员发送签到内容存储到数据库并返回
     * @param content
     * @param socketBo
     * @return
     */
    @MessageMapping("/signin")
    @SendTo("/topic/signin-content")
    public String signIn(@PathParam("content") String content, @RequestBody SignInAdminWebSocketBo socketBo){
        //拿到发布人的id
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long adminId = Long.valueOf(userIdOfStr);

        //将签到内容保存到数据库或其他地方
        this.socketBo = userAdminMapper.selectToGetWebByAdminId(adminId);
        this.socketBo.setContent(content);

        //返回签到内容给客户端
        return content;
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
