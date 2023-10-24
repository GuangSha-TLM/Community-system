package com.gsxy.core.service;

import com.gsxy.core.pojo.bo.OrgAddBo;
import com.gsxy.core.pojo.bo.OrgDeleteByIdBo;
import com.gsxy.core.pojo.bo.OrgSelectByIdBo;
import com.gsxy.core.pojo.bo.OrgUpdateByIdBo;
import com.gsxy.core.pojo.vo.ResponseVo;

/**
 * @author zhuxinyu 2023-10-23
 *  班级业务接口
 */

public interface OrgService {
    /**
     *@author zhuxinyu 2023-10-23
     *      添加Org
     * @param orgAddByIdbo
     * @return
     */
    public ResponseVo orgAdd(OrgAddBo orgAddByIdbo);

    /**
     *@author zhuxinyu 2023-10-23
     *      删除Org
     * @param orgDeleteByIdBo
     * @return
     */
    public ResponseVo orgDeleteById(OrgDeleteByIdBo orgDeleteByIdBo);

    /**
     *@author zhuxinyu 2023-10-23
     *      查询Org
     * @param orgSelectByIdBo
     * @return
     */
    public ResponseVo orgSelectById(OrgSelectByIdBo orgSelectByIdBo);


    /**
     *@author zhuxinyu 2023-10-23
     *      修改Org
     * @param orgUpdateByIdBo
     * @return
     */
    public ResponseVo orgUpdateById(OrgUpdateByIdBo orgUpdateByIdBo);
}