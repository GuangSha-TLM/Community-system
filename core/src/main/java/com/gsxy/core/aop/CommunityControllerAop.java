package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;

public interface CommunityControllerAop {
    /**
     * @author zhuxinyu 2023-10-26
     * 添加社团鉴权
     * @param joinPoint
     * @return
     */
    public String communityAdd(JoinPoint joinPoint);

    /**
     *  @author zhuxinyu 2023-10-26
     *  删除社团鉴权
     * @param joinPoint
     * @return
     */
    public String communityDeleteById(JoinPoint joinPoint);

    /**
     *  @author zhuxinyu 2023-10-26
     *  查找社团鉴权
     * @param joinPoint
     * @return
     */
    public String communitySelectById(JoinPoint joinPoint);

    /**
     *  @author zhuxinyu 2023-10-26
     *  修改社团鉴权
     * @param joinPoint
     * @return
     */
    public String communityUpdateById(JoinPoint joinPoint);
}
