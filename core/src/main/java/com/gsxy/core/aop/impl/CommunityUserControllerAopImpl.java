package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.CommunityUserControllerAop;
import com.gsxy.core.pojo.bo.CommunityUserAddBo;
import com.gsxy.core.pojo.bo.CommunityUserDeleteByIdBo;
import com.gsxy.core.pojo.bo.CommunityUserSelectByIdBo;
import com.gsxy.core.pojo.bo.CommunityUserUpdateByIdBo;
import com.gsxy.core.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommunityUserControllerAopImpl implements CommunityUserControllerAop {
    @Autowired
    private SystemService systemService;

    @Override
    public String CommunityUserAdd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        CommunityUserAddBo arg =(CommunityUserAddBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,0);
        return null;
    }

    @Override
    public String CommunityUserDeleteById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        CommunityUserDeleteByIdBo arg = (CommunityUserDeleteByIdBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);
        return null;
    }

    @Override
    public String CommunityUserSelectById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        CommunityUserSelectByIdBo arg = (CommunityUserSelectByIdBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,1);
        return null;
    }

    @Override
    public String CommunityUserUpdateById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        CommunityUserUpdateByIdBo arg = (CommunityUserUpdateByIdBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);
        return null;
    }
}
