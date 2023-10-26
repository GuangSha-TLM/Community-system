package com.gsxy.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

public interface ImgControllerAop {

    /**
     * @author Oh...Yeah!!!  2023-10-25
     *      Img查询鉴权
     * @param joinPoint
     * @return String.class
     */
    public void imgSelect(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      对Img删除鉴权
     * @param joinPoint
     * @return String.class
     */
    public void imgDeleteById(JoinPoint joinPoint);



    /**
     * @author Oh...Yeah!!!  2023-10-25
     *      Img增加鉴权
     * @param joinPoint
     * @return String.class
     */
    public void imgAdd(JoinPoint joinPoint);

    /**
     * @author Oh...Yeah!!!  2023-10-26
     *      Img修改鉴权
     * @param joinPoint
     * @return String.class
     */
    public void imgUpdateById(JoinPoint joinPoint);
















}
