package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;

public interface NoticeControllerAop {


    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      查询鉴权
     * @param joinPoint
     * @return void
     */
    public void noticeSelect(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      删除鉴权
     * @param joinPoint
     * @return void
     */
    public void noticeDeleteById(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      添加鉴权
     * @param joinPoint
     * @return void
     */
    public void noticeAdd(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-27
     *      修改鉴权
     * @param joinPoint
     * @return void
     */
    public void noticeUpdateById(JoinPoint joinPoint);


}
