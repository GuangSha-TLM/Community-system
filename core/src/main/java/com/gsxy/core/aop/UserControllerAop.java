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
    @Before("execution(* com.gsxy.core.controller.UserController.selectByUserId(..))")
    public String selectByUserId(JoinPoint joinPoint);

    @Before("execution(* com.gsxy.core.controller.UserController.updateByUserId(..))")
    public String updateByUserId(JoinPoint joinPoint);

    @Before("execution(* com.gsxy.core.controller.UserController.deleteByUserId(..))")
    public String deleteByUserId(JoinPoint joinPoint);

}
