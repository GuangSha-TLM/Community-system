package com.gsxy.core.service;

import com.gsxy.core.pojo.bo.CommunityUserAddBo;
import com.gsxy.core.pojo.bo.CommunityUserDeleteByIdBo;
import com.gsxy.core.pojo.bo.CommunityUserSelectByIdBo;
import com.gsxy.core.pojo.bo.CommunityUserUpdateByIdBo;
import com.gsxy.core.pojo.vo.ResponseVo;

public interface CommunityUserService {

    public ResponseVo communityUseradd(CommunityUserAddBo communityUserAddBo);

    public ResponseVo communityUserDeleteById(CommunityUserDeleteByIdBo communityUserDeleteByIdBo);

    public ResponseVo communityUserSelectById(CommunityUserSelectByIdBo communityUserSelectByIdBo);

    public ResponseVo communityUserUpdateById(CommunityUserUpdateByIdBo communityUserUpdateByIdBo);

    public ResponseVo communityUserAndUser();
}
