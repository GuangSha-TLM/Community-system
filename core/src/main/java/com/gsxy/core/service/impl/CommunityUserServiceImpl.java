package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.CommunityUserMapper;
import com.gsxy.core.pojo.CommunityUser;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.CommunityUserService;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommunityUserServiceImpl implements CommunityUserService {
    @Autowired
    private CommunityUserMapper communityUserMapper;

    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户添加
     * @param communityUserAddBo
     * @return
     */
    @Override
    public ResponseVo communityUseradd(CommunityUserAddBo communityUserAddBo) {
        String communityUserIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityUserId = Long.valueOf(communityUserIdOfStr);
        communityUserAddBo.getCommunityUser().setCommunityId(communityUserId);
        communityUserAddBo.getCommunityUser().setCreateBy(communityUserId);
        communityUserAddBo.getCommunityUser().setCreateTime(new Date());
        Long aLong = communityUserMapper.communityUseAdd(communityUserAddBo.getCommunityUser());
        if (aLong.longValue() == 0L) {
            return new ResponseVo("增加失败",  null, "0x500");
        }

        return new ResponseVo("增加成功", communityUserId, "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户删除
     * @param communityUserDeleteByIdBo
     * @return
     */
    @Override
    public ResponseVo communityUserDeleteById(CommunityUserDeleteByIdBo communityUserDeleteByIdBo) {
        String communityUserIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityUserId = Long.valueOf(communityUserIdOfStr);
        if(communityUserId == null || communityUserId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }
        Long id = communityUserDeleteByIdBo.getId();
        Long aLong = communityUserMapper.communityUserDeleteById(id);
        if (aLong.longValue() == 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",id, "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户查询
     * @param communityUserSelectByIdBo
     * @return
     */
    @Override
    public ResponseVo communityUserSelectById(CommunityUserSelectByIdBo communityUserSelectByIdBo) {
        String communityUserIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityUserId = Long.valueOf(communityUserIdOfStr);
        Long id = communityUserSelectByIdBo.getId();
        CommunityUser communityUser = communityUserMapper.communityUserSelectById(id);
        if (communityUser == null) {
            return new ResponseVo("查询的数据不存在,", communityUserId, "0x500");
        }

        return new ResponseVo("查询成功",communityUser,"0x200");

    }

    /**
     * @author zhuxinyu 2023-10-30
     * 社团用户修改
     * @param communityUserUpdateByIdBo
     * @return
     */
    @Override
    public ResponseVo communityUserUpdateById(CommunityUserUpdateByIdBo communityUserUpdateByIdBo) {
        String communityUserIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityUserId = Long.valueOf(communityUserIdOfStr);
        communityUserUpdateByIdBo.getCommunityUser().setUserId(communityUserId);
        communityUserUpdateByIdBo.getCommunityUser().setUpdateBy(communityUserId);
        communityUserUpdateByIdBo.getCommunityUser().setUpdateTime(new Date());
        CommunityUser communityUser = communityUserUpdateByIdBo.getCommunityUser();
        Long aLong = communityUserMapper.communityUserUpdateById(communityUser);
        if (aLong.longValue() == 0L) {
            return new ResponseVo("更新失败", null, "0x500");
        }
        return new ResponseVo("更新成功", communityUser.getId(), "0x200");
    }

    /**
     * @author zhuxinyu 2023-11-03
     *      删除社员
     * @param communityUserdeleteUserBo
     * @return
     */
    @Override
    public ResponseVo communityUserdeleteUser(CommunityUserdeleteUserBo communityUserdeleteUserBo) {
        String communityUserIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long communityUserId = Long.valueOf(communityUserIdOfStr);
        if(communityUserId == null || communityUserId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }
        Long userId = communityUserdeleteUserBo.getUserId();
        if (userId == 0L ) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",userId, "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-30
     * 查询社团所有用户
     * @return
     */
    @Override
    public ResponseVo communityUserAndUser() {
        List <CommunityUserAndUserBo> list = communityUserMapper.communityUserAndUser();
        return new ResponseVo("查询成功",list,"0x200");
    }
}
