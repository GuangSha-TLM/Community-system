package com.gsxy.core.service;

import com.gsxy.core.pojo.bo.OrgAddBo;
import com.gsxy.core.pojo.bo.OrgDeleteByIdBo;
import com.gsxy.core.pojo.bo.OrgSelectByIdBo;
import com.gsxy.core.pojo.bo.OrgUpdateByIdBo;
import com.gsxy.core.pojo.vo.ResponseVo;



public interface OrgService {
    /**
     *
     * @param orgAddByIdbo
     * @return
     */
    public ResponseVo orgAdd(OrgAddBo orgAddByIdbo);

    /**
     *
     * @param orgDeleteByIdBo
     * @return
     */
    public ResponseVo orgDeleteById(OrgDeleteByIdBo orgDeleteByIdBo);

    /**
     *
     * @param orgSelectByIdBo
     * @return
     */
    public ResponseVo orgSelectById(OrgSelectByIdBo orgSelectByIdBo);


    /**
     *
     * @param orgUpdateByIdBo
     * @return
     */
    public ResponseVo orgUpdateById(OrgUpdateByIdBo orgUpdateByIdBo);
}
