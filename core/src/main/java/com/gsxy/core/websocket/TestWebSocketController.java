package com.gsxy.core.websocket;

import com.gsxy.core.controller.UserAdminController;
import com.gsxy.core.mapper.UserAdminMapper;
import com.gsxy.core.util.SpringContextUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;

@ServerEndpoint("/websocket/{token}")
@CrossOrigin
@Component
public class TestWebSocketController {

    // 构造函数注入任何需要的依赖项
    private String token;//前端传输的token信息
    private UserAdminController userAdminController = SpringContextUtil.getBean(UserAdminController.class);

    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) throws IOException {
        System.out.println("签到已发起"+token);
        this.token = token;
        String s = this.serviceFunction(token, session);
        session.getBasicRemote().sendText(s);
    }

    // 其他方法...
    @OnMessage
    public void onMessage(String token, Session session) throws IOException {

        //实现用户签到信息的实时查看
        String s = this.serviceFunction(token, session);
        session.getBasicRemote().sendText(s);

    }


    public String serviceFunction(String token, Session session) throws IOException {
        String str = userAdminController.adminCheckInStatusInRealTime(token);
         return str;
    }


}
