package com.gsxy.core.service;

import com.gsxy.core.pojo.bo.CommunityAddBo;
import com.gsxy.core.pojo.bo.CommunityDeleteByIdBo;
import com.gsxy.core.pojo.bo.CommunitySelectByIdBo;
import com.gsxy.core.pojo.bo.CommunityUpdateByIdBo;
import com.gsxy.core.pojo.vo.ResponseVo;

/**
 * @author zhuxinyu 2023-10-24
 * 社团业务接口
 *
 */
public interface CommunityService {
    /**
     * @author zhuxinyu 2023-10-24
     *      添加社团
     * @param communityAddByIdBo
     * @return
     */
    public ResponseVo addCommunity(CommunityAddBo communityAddByIdBo);

    /**
     * @author zhuxinyu 2023-10-24
     *      删除社团
     * @param communityDeleteByIdBo
     * @return
     */
    public ResponseVo deleteByIdCommunity(CommunityDeleteByIdBo communityDeleteByIdBo);

    /**
     * @author zhuxinyu 2023-10-24
     *      查找社团
     * @param communitySelectByIdBo
     * @return
     */
    public ResponseVo selectByIdCommunity(CommunitySelectByIdBo communitySelectByIdBo);

    /**
     *@author zhuxinyu 2023-10-24
     *      修改社团
     * @param communityUpdateByIdBo
     * @return
     */
    public ResponseVo updateByIdCommunity(CommunityUpdateByIdBo communityUpdateByIdBo);

    public ResponseVo communityAndUser();
}
