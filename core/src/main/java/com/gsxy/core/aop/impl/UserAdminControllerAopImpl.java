package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.UserAdminControllerAop;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserAdminControllerAopImpl implements UserAdminControllerAop {

    @Autowired
    private SystemService systemService;

    /**
     * @author Oh...Yeah!!!  2023-10-25
     *      UserAdmin查询鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserAdminController.userAdminSelect(..))")
    public void userAdminSelect(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserAdminSelectByIdBo userAdminSelectByIdBo = (UserAdminSelectByIdBo) args[0];
        String token = userAdminSelectByIdBo.getToken();
        systemService.auth(token);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      UserAdmin删除鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserAdminController.userAdminDeleteById(..))")
    public void userAdminDeleteById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserAdminDeleteByIdBo userAdminDeleteByIdBo = (UserAdminDeleteByIdBo) args[0];
        String token = userAdminDeleteByIdBo.getToken();
        systemService.auth(token);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      UserAdmin添加鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserAdminController.userAdminAdd(..))")
    public void userAdminAdd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserAdminAddByBo userAdminAddByBo = (UserAdminAddByBo) args[0];
        String token = userAdminAddByBo.getToken();
        systemService.auth(token);
    }

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      UserAdmin修改鉴权
     * @param joinPoint
     * @return void
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserAdminController.userAdminUpdateById(..))")
    public void userAdminUpdateById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserAdminUpdateByIdBo userAdminUpdateByIdBo = (UserAdminUpdateByIdBo) args[0];
        String token = userAdminUpdateByIdBo.getToken();
        systemService.auth(token);
    }


}
