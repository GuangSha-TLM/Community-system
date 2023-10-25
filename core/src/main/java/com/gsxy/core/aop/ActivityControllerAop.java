package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

public interface ActivityControllerAop {

    /**
     * @author zhuxinyu 2023-10-24
     * 添加org 主要做了鉴权
     * @param joinPoint
     * @return
     */
    @Before("execution(* com.example.complaint_system.controller.ActivityController.addActivity(..))")
    public String addActivity(JoinPoint joinPoint);


}
