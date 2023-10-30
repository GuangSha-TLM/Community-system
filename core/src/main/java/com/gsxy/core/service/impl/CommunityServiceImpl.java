package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.CommunityMapper;
import com.gsxy.core.pojo.Community;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.CommunityService;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zhuxinyu 2023-10-24
 *    社团业务实体类接口
 */
@Service
public class CommunityServiceImpl implements CommunityService {
    @Autowired
    private CommunityMapper communityMapper;
    /**
     * @author zhuxinyu 2023-10-24
     *      添加社团
     * @param communityAddByIdBo
     * @return
     */
    @Override
    public ResponseVo addCommunity(CommunityAddBo communityAddByIdBo) {
        String communityIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityId = Long.valueOf(communityIdOfStr);
        communityAddByIdBo.getCommunity().setCommunityId(communityId);
        communityAddByIdBo.getCommunity().setCreateBy(communityId);
        communityAddByIdBo.getCommunity().setCreateTime(new Date());
        Long aLong = communityMapper.addcommunity(communityAddByIdBo.getCommunity());
        if (aLong.longValue() == 0L) {
            return new ResponseVo("增加失败",  null, "0x500");
        }

        return new ResponseVo("增加成功", communityId, "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-24
     *      通过id删除社团数据
     * @param communityDeleteByIdBo
     * @return
     */
    @Override
    public ResponseVo deleteByIdCommunity(CommunityDeleteByIdBo communityDeleteByIdBo) {
        String communityIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityId = Long.valueOf(communityIdOfStr);
        if(communityId == null || communityId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        Long id = communityDeleteByIdBo.getId();
        Long aLong = communityMapper.deleteByIdcommunity(id);
        if (aLong.longValue() == 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",id, "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-24
     *      通过id查找社团数据
     * @param communitySelectByIdBo
     * @return
     */
    @Override
    public ResponseVo selectByIdCommunity(CommunitySelectByIdBo communitySelectByIdBo) {
        String communityIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityId = Long.valueOf(communityIdOfStr);
        Long id = communitySelectByIdBo.getId();
        Community community = communityMapper.selectByIdcommunity(id);
        if (community == null) {
            return new ResponseVo("查询的数据不存在,", communityId, "0x500");
        }

        return new ResponseVo("查询成功",community,"0x200");
    }

    /**
     * @author zhuxinyu 2023-10-24
     *      通过id更新社团数据
     * @param communityUpdateByIdBo
     * @return
     */
    @Override
    public ResponseVo updateByIdCommunity(CommunityUpdateByIdBo communityUpdateByIdBo) {
        String communityIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityId = Long.valueOf(communityIdOfStr);
        communityUpdateByIdBo.getCommunity().setCommunityId(communityId);
        communityUpdateByIdBo.getCommunity().setUpdateBy(communityId);
        communityUpdateByIdBo.getCommunity().setUpdateTime(new Date());
        Community community = communityUpdateByIdBo.getCommunity();
        Long aLong = communityMapper.updateByIdcommunity(community);
        if (aLong.longValue() == 0L) {
            return new ResponseVo("更新失败", null, "0x500");
        }
        return new ResponseVo("更新成功", community.getId(), "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-30
     *  查询用户的所有信息
     * @return
     */
    @Override
    public ResponseVo communityAndUser() {
        List<CommunityAndUserBo> list = communityMapper.communityAndUser();
        return new ResponseVo<>("查询成功",list,"0x200");
    }

}
