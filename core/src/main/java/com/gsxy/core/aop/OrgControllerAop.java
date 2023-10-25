package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;

public interface OrgControllerAop {
    /**
     * @author zhuxinyu 2023-10-24
     * 添加org 主要做了鉴权
     * @param joinPoint
     * @return
     */
    public String OrgAdd(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-10-24
     * 添加org 主要做了鉴权
     * @param joinPoint
     * @return
     */
    public String OrgDeleteById(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-10-24
     * 添加org 主要做了鉴权
     * @param joinPoint
     * @return
     */
    public String OrgSelectById(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-10-24
     * 添加org 主要做了鉴权
     * @param joinPoint
     * @return
     */
    public String OrgUpdateById(JoinPoint joinPoint);
}
