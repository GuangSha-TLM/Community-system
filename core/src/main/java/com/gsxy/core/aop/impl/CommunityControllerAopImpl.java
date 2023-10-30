package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.CommunityControllerAop;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommunityControllerAopImpl implements CommunityControllerAop {
    @Autowired
    private SystemService systemService;

    /**
     * @author zhuxinyu 2023-10-26
     *      添加权限验证
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.CommunityController.Communityadd(..))")
    public String communityAdd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        CommunityAddBo arg = (CommunityAddBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);
        return null;
    }

    /**
     * @author zhuxinyu 2023-10-26
     *      删除权限验证
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.CommunityController.CommunityDeleteById(..))")
    public String communityDeleteById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        CommunityDeleteByIdBo arg = (CommunityDeleteByIdBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);
        return null;
    }

    /**
     * @author zhuxinyu 2023-10-26
     *      查找权限验证
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.CommunityController.CommunitySelectById(..))")
    public String communitySelectById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        CommunitySelectByIdBo arg = (CommunitySelectByIdBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,1);
        return null;
    }

    /**
     * @author zhuxinyu 2023-10-26
     *      修改权限验证
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.CommunityController.CommunityUpdateById(..))")
    public String communityUpdateById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        CommunityUpdateByIdBo arg = (CommunityUpdateByIdBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);
        return null;
    }
    /**
     * @author zhuxinyu 2023-10-30
     *      community分页查询鉴权
     * @param joinPoint
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.CommunityController.CommunityPagingToGetData(..))")
    public void communityPagingToGetData(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        CommunityPagingToGetDataBo communityPagingToGetDataBo = (CommunityPagingToGetDataBo) args[0];
        String token = communityPagingToGetDataBo.getToken();
        systemService.auth(token);
    }
}
