package com.gsxy.core.websocket;

import com.gsxy.core.controller.UserAdminController;
import com.gsxy.core.mapper.UserAdminMapper;
import com.gsxy.core.pojo.bo.AdminCheckInStatusInRealTimeBo;
import com.gsxy.core.util.SpringContextUtil;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/websocket/{token}")
@CrossOrigin
@Component
public class TestWebSocketController {

    // 构造函数注入任何需要的依赖项
    private UserAdminController userAdminController = SpringContextUtil.getBean(UserAdminController.class);
    private UserAdminMapper userAdminMapper = SpringContextUtil.getBean(UserAdminMapper.class);

    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) throws IOException {
//        System.out.println("签到已发起"+token);
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
        //拿到用户的id
        String adminIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(adminIdOfStr);

        //通过数据库查content
        String content = userAdminMapper.selectToGetContent(userId);

        //注入对象
        AdminCheckInStatusInRealTimeBo adminCheckInStatusInRealTimeBo = new AdminCheckInStatusInRealTimeBo();
        adminCheckInStatusInRealTimeBo.setToken(token);
        adminCheckInStatusInRealTimeBo.setContent(content);

        //转换格式
        String str = userAdminController.adminCheckInStatusInRealTime(adminCheckInStatusInRealTimeBo);

        return str;
    }


}
