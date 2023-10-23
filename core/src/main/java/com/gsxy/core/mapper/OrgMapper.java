package com.gsxy.core.mapper;

import com.gsxy.core.pojo.Org;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhuxinyu 2023-10-23
 *      班级持久层
 */
@Mapper
public interface OrgMapper {
    /**
     * @author zhuxinyu 2023-10-23
     *      添加Org
     * @param org
     * @return
     */
    public Long addOrg(Org org);

    /**
     *  @author zhuxinyu 2023-10-23
     *      删除Org
     * @param id
     * @return
     */
    public Long deleteByIdOrg(Long id);

    /**
     * @author zhuxinyu 2023-10-23
     *      查找Org
     * @param id
     * @return
     */
    public Org selectByIdOrg(Long id);

    /**
     * @author zhuxinyu 2023-10-23
     *      更新Org
     * @param org
     * @return
     */
    public Long updateByIdOrg(Org org);




}
