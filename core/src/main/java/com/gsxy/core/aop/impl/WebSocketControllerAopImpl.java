package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.WebSocketControllerAop;
import com.gsxy.core.pojo.bo.SignInAdminWebSocketBo;
import com.gsxy.core.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class WebSocketControllerAopImpl implements WebSocketControllerAop {

    @Autowired
    private SystemService systemService;

    /**
     * @author hln 2023-11-06
     *      管理员发布签到内容
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.WebSocketController.signIn(..))")
    public String signIn(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        SignInAdminWebSocketBo arg = (SignInAdminWebSocketBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);

        return null;
    }
}
