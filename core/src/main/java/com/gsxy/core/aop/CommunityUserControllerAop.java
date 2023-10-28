package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;

public interface CommunityUserControllerAop {

    public String CommunityUserAdd(JoinPoint joinPoint);

    public String CommunityUserDeleteById(JoinPoint joinPoint);

    public String CommunityUserSelectById(JoinPoint joinPoint);

    public String CommunityUserUpdateById(JoinPoint joinPoint);
}
