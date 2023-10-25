package com.gsxy.core.service;

import com.gsxy.core.pojo.bo.ActiveAddBo;
import com.gsxy.core.pojo.vo.ResponseVo;

public interface ActiveService {

    /**
     * @auhtor hln 2023-10-24
     *      添加活动功能
     * @param activityAddBo
     * @return
     */
    ResponseVo addActive(ActiveAddBo activityAddBo);

    /**
     * @author hln 2023-10-25
     *      查询所有活动功能
     * @return
     */
    ResponseVo findAll();
}
