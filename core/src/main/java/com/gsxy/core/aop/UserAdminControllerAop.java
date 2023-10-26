package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;

public interface UserAdminControllerAop {

    /**
     * @author Oh...Yeah!!!  2023-10-25
     *      UserAdmin查询鉴权
     * @param joinPoint
     * @return void
     */
    public void userAdminSelect(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      UserAdmin删除鉴权
     * @param joinPoint
     * @return void
     */
    public void userAdminDeleteById(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      UserAdmin添加鉴权
     * @param joinPoint
     * @return void
     */
    public void userAdminAdd(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      UserAdmin修改鉴权
     * @param joinPoint
     * @return void
     */
    public void userAdminUpdateById(JoinPoint joinPoint);



}
