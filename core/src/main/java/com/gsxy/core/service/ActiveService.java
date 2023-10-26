package com.gsxy.core.service;

import com.gsxy.core.pojo.bo.ActiveAddBo;
import com.gsxy.core.pojo.bo.ActiveDeleteByIdBo;
import com.gsxy.core.pojo.bo.ActiveSelectByIdBo;
import com.gsxy.core.pojo.bo.ActiveUpdateByIdBo;
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

    /**
     * @author hln 2023-10-26
     *      根据id删除活动
     * @param activeDeleteByIdBo
     * @return
     */
    ResponseVo deleteActive(ActiveDeleteByIdBo activeDeleteByIdBo);

    /**
     * @author hln 2023-10-26
     *      根据id查询活动
     * @param activeSelectByIdBo
     * @return
     */
    ResponseVo selectActive(ActiveSelectByIdBo activeSelectByIdBo);

    /**
     * @author hln 2023-10-26
     *      根据id修改活动
     * @param activeUpdateByIdBo
     * @return
     */
    ResponseVo updateActive(ActiveUpdateByIdBo activeUpdateByIdBo);
}
