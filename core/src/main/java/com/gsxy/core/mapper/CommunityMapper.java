package com.gsxy.core.mapper;

import com.gsxy.core.pojo.Community;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityMapper {
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
}
