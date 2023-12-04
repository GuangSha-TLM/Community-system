package com.gsxy.core.websocket;

import com.gsxy.core.controller.UserAdminController;
import com.gsxy.core.mapper.UserAdminMapper;
import com.gsxy.core.pojo.bo.AdminCheckInStatusInRealTimeBo;
import com.gsxy.core.util.SpringContextUtil;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/websocket/{id}")
@CrossOrigin
@Component
public class TestWebSocketController {

    // 构造函数注入任何需要的依赖项
    private UserAdminController userAdminController = SpringContextUtil.getBean(UserAdminController.class);
//    private UserAdminMapper userAdminMapper = SpringContextUtil.getBean(UserAdminMapper.class);

    @OnOpen
    public void onOpen(Session session, @PathParam("id") Long id) throws IOException {
        String s = this.serviceFunction(id, session);
        session.getBasicRemote().sendText(s);
    }

    // 其他方法...
    @OnMessage
    public void onMessage(Long id, Session session) throws IOException {

        //实现用户签到信息的实时查看
        String s = this.serviceFunction(id, session);
        session.getBasicRemote().sendText(s);

    }


    public String serviceFunction(Long id, Session session) throws IOException {
        //转换格式
        String str = userAdminController.adminCheckInStatusInRealTimeLast(id);

        return str;
    }

//    @OnClose
//    public void onClose(Session session) {
//        // 处理关闭事件
//        System.out.println("WebSocket closed for session: " + session.getId());
//    }

}
