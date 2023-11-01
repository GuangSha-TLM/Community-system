package com.gsxy.core.mapper;

import com.gsxy.core.pojo.Community;
import com.gsxy.core.pojo.bo.CommunityAndUserBo;
import com.gsxy.core.pojo.bo.CommunityPagingToGetDataBo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityMapper {


    /**
     * @author Oh...Yeah!!! 2023-10-30
     *      根据community_id查找社团
     * @param CommunityId
     * @return
     */
    public Community selectByCommunityId(Long CommunityId);



    /**
     * @author zhuxinyu 2023-10-24
     *      添加社团
     * @param community
     * @return
     */
    public Long addcommunity(Community community);

    /**
     * @author zhuxinyu 2023-10-24
     *      删除社团
     * @param id
     * @return
     */
    public Long deleteByIdcommunity(Long id);

    /**
     * @author zhuxinyu 2023-10-24
     *      查找社团
     * @param id
     * @return
     */
    public Community selectByIdcommunity(Long id);

    /**
     * @author zhuxinyu 2023-10-24
     *      更新社团
     * @param community
     * @return
     */
    public Long updateByIdcommunity(Community community);

    /**
     * @author zhuxinyu 2023-10-30
     * 查询社团所有用户
     * @return
     */
    public List<CommunityAndUserBo> communityAndUser();

    /**
     * @author zhuxinyu 2023-10-30
     *      分页获取查询数据
     * @param communityPagingToGetDataBo
     * @return
     */
    public List<Community> communityPagingToGetData(CommunityPagingToGetDataBo communityPagingToGetDataBo);
}
