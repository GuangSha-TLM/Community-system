package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

public interface UserControllerAop {

    /**
     * @author hln
     * 添加user 主要做了鉴权
     * @param joinPoint
     * @return
     */
    public String selectByUserId(JoinPoint joinPoint);

    public String updateByUserId(JoinPoint joinPoint);

    public String deleteByUserId(JoinPoint joinPoint);

    public String pagingToGetUserData(JoinPoint joinPoint);

}
