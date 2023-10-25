package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.ActivityControllerAop;
import com.gsxy.core.pojo.Activity;
import com.gsxy.core.pojo.bo.ActiveAddBo;
import com.gsxy.core.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ActivityControllerAopImpl implements ActivityControllerAop {

    @Autowired
    private SystemService systemService;

    /**
     * @author hln
     * 添加task 主要做了鉴权
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.ActivityController.addActive(..))")
    public String addActive(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        ActiveAddBo arg = (ActiveAddBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);

        return null;
    }
}
