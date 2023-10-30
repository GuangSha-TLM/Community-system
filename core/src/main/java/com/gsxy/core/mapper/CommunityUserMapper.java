package com.gsxy.core.mapper;

import com.gsxy.core.pojo.CommunityUser;
import com.gsxy.core.pojo.bo.CommunityUserAndUserBo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityUserMapper {
    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户添加
     * @param communityUser
     * @return
     */
    public Long communityUseAdd(CommunityUser communityUser);

    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户删除
     * @param id
     * @return
     */
    public Long communityUserDeleteById(Long id);

    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户查询
     * @param id
     * @return
     */
    public CommunityUser communityUserSelectById(Long id);

    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户修改
     * @param communityUser
     * @return
     */
    public Long communityUserUpdateById(CommunityUser communityUser);

    /**
     * @author zhuxinyu 2023-10-30
     * 查询社团所有用户
     * @return
     */
    public List<CommunityUserAndUserBo> communityUserAndUser();
}
