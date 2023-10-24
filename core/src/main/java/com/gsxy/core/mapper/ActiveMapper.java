package com.gsxy.core.mapper;

import com.gsxy.core.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActiveMapper {

    /**
     * @auhtor hln 2023-10-24
     *      添加活动功能
     * @param activity
     * @return
     */
    Long addActive(Activity activity);

}
