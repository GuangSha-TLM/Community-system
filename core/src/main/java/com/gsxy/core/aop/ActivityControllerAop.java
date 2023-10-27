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
    public String addActive(JoinPoint joinPoint);

    public String deleteActive(JoinPoint joinPoint);

    public String selectActive(JoinPoint joinPoint);

    public String updateActive(JoinPoint joinPoint);

    public String pagingQuery(JoinPoint joinPoint);

}
