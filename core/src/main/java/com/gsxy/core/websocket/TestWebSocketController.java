package com.gsxy.core.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/websocket/{contest_id}")
@CrossOrigin
@Component
public class TestWebSocketController {

    // 构造函数注入任何需要的依赖项

    @OnOpen
    public void onOpen(Session session, @PathParam("contest_id") Long contestId)
    {
        System.out.println("签到已发起");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("???");
    }

    // 其他方法...

}
