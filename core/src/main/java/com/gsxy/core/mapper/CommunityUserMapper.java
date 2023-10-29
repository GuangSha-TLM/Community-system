package com.gsxy.core.mapper;

import com.gsxy.core.pojo.CommunityUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityUserMapper {

    public Long communityUseAdd(CommunityUser communityUser);

    public Long communityUserDeleteById(Long id);

    public CommunityUser communityUserSelectById(Long id);

    public Long communityUserUpdateById(CommunityUser communityUser);
}
