package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;

public interface WebSocketControllerAop {

    /**
     * @author hln 2023-11-06
     *      管理员发布签到内容
     * @param joinPoint
     * @return
     */
    public String signIn(JoinPoint joinPoint);

}
