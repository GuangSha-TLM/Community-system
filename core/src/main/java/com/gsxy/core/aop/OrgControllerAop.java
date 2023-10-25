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

    public String OrgDeleteById(JoinPoint joinPoint);

    public String OrgSelectById(JoinPoint joinPoint);

    public String OrgUpdateById(JoinPoint joinPoint);

}
