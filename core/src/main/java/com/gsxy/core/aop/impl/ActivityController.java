package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.ActivityControllerAop;
import com.gsxy.core.pojo.Activity;
import com.gsxy.core.pojo.bo.ActivityAddBo;
import com.gsxy.core.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class ActivityController implements ActivityControllerAop {

    @Autowired
    private SystemService systemService;

    /**
     * @author hln
     * 添加task 主要做了鉴权
     * @param joinPoint
     * @return
     */
//    @Override
//    @Before("execution(* com.example.complaint_system.controller.ActivityController.addActivity(..))")
//    public String addActivity(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        ActivityAddBo arg = (ActivityAddBo) args[0];
//        String token = arg.getToken();
//        systemService.auth(token);
//
//        return null;
//    }
}
