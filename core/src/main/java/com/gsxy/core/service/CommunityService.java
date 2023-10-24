package com.gsxy.core.service;

import com.gsxy.core.pojo.bo.CommunityAddBo;
import com.gsxy.core.pojo.bo.CommunityDeleteByIdBo;
import com.gsxy.core.pojo.bo.CommunitySelectByIdBo;
import com.gsxy.core.pojo.bo.CommunityUpdateByIdBo;
import com.gsxy.core.pojo.vo.ResponseVo;

public interface CommunityService {

    public ResponseVo addCommunity(CommunityAddBo communityAddByIdBo);

    public ResponseVo deleteByIdCommunity(CommunityDeleteByIdBo communityDeleteByIdBo);

    public ResponseVo selectByIdCommunity(CommunitySelectByIdBo communitySelectByIdBo);

    public ResponseVo updateByIdCommunity(CommunityUpdateByIdBo communityUpdateByIdBo);
}
