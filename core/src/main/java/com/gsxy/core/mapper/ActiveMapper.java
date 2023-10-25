package com.gsxy.core.mapper;

import com.gsxy.core.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActiveMapper {

    /**
     * @auhtor hln 2023-10-24
     *      添加活动功能
     * @param activity
     * @return
     */
    Long addActive(Activity activity);

    /**
     * @author hln 2023-10-25
     *      查询所有活动功能
     * @return
     */
    List<Activity> findAll();
}
