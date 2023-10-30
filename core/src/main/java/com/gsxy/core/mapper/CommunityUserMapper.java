package com.gsxy.core.mapper;

import com.gsxy.core.pojo.CommunityUser;
import com.gsxy.core.pojo.bo.CommunityUserAndUserBo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityUserMapper {

    public Long communityUseAdd(CommunityUser communityUser);

    public Long communityUserDeleteById(Long id);

    public CommunityUser communityUserSelectById(Long id);

    public Long communityUserUpdateById(CommunityUser communityUser);
    public List<CommunityUserAndUserBo> communityUserAndUser();
}
