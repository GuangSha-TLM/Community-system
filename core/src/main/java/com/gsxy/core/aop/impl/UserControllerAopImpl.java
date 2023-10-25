package com.gsxy.core.aop.impl;

import com.gsxy.core.aop.UserControllerAop;
import com.gsxy.core.pojo.bo.UserDeleteByIdBo;
import com.gsxy.core.pojo.bo.UserSelectByUserIdBo;
import com.gsxy.core.pojo.bo.UserUpdateByUserIdBo;
import com.gsxy.core.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserControllerAopImpl implements UserControllerAop {

    @Autowired
    private SystemService systemService;

    /**
     * @author hln 2023-10-25
     *      做了权限验证
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserController.selectByUserId(..))")
    public String selectByUserId(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserSelectByUserIdBo userSelectByUserIdBo = (UserSelectByUserIdBo) args[0];
        String token = userSelectByUserIdBo.getToken();
        systemService.auth(token);

        return null;
    }

    /**
     * @author hln 2023-10-25
     *      做了权限验证
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserController.updateByUserId(..))")
    public String updateByUserId(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserUpdateByUserIdBo userUpdateByUserIdBo = (UserUpdateByUserIdBo) args[0];
        String token = userUpdateByUserIdBo.getToken();
        systemService.auth(token);

        return null;
    }

    /**
     * @author hln 2023-10-25
     *      做了权限验证
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.gsxy.core.controller.UserController.deleteByUserId(..))")
    public String deleteByUserId(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserDeleteByIdBo userDeleteByIdBo = (UserDeleteByIdBo) args[0];
        String token = userDeleteByIdBo.getToken();
        systemService.auth(token);

        return null;
    }
}
