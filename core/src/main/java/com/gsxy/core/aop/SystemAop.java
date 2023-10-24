package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;

/**
 * @author zhuxinyu
 */
public interface SystemAop {
    /**
     * @author zhuxinyu
     * 清理ThreadLocal 防止内存泄露
     * @param joinpoint
     * @throws Exception
     */
    public void removeAllThreadLocal(JoinPoint joinpoint) throws Exception;
}
