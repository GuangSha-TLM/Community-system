package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;

public interface CommunityUserControllerAop {
    /**
     * @author zhuxinyu 2023-10-30
     *      社团用户添加鉴权
     * @param joinPoint
     * @return
     */
    public String CommunityUserAdd(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-10-30
     *      社团用户删除鉴权
     * @param joinPoint
     * @return
     */
    public String CommunityUserDeleteById(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-10-30
     *      社团用户查询鉴权
     * @param joinPoint
     * @return
     */
    public String CommunityUserSelectById(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-10-30
     *      社团用户修改鉴权
     * @param joinPoint
     * @return
     */
    public String CommunityUserUpdateById(JoinPoint joinPoint);

    public String CommunityUserdeleteUser(JoinPoint joinPoint);
}
