package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.OrgMapper;
import com.gsxy.core.pojo.Org;
import com.gsxy.core.pojo.bo.OrgAddBo;
import com.gsxy.core.pojo.bo.OrgDeleteByIdBo;
import com.gsxy.core.pojo.bo.OrgSelectByIdBo;
import com.gsxy.core.pojo.bo.OrgUpdateByIdBo;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.OrgService;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhuxinyu 2023-10-23
 *      班级业务实体类接口
 */
@Service
public class OrgServiceImpl implements OrgService {
    @Autowired
    private OrgMapper orgMapper;

    /**
     * @author zhuxinyu 2023-10-23
     *     添加Org
     * @param orgAddByIdBo
     * @return
     */
    @Override
    public ResponseVo orgAdd(OrgAddBo orgAddByIdBo){
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);
        Long  aLong = orgMapper.addOrg(orgAddByIdBo.getOrg());
        if (aLong.longValue() == 0L) {
            return new ResponseVo("增加失败",  null, "0x500");
        }

        return new ResponseVo("增加成功", null, "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-23
     *      通过id删除Org
     * @param orgDeleteByIdBo
     * @return
     */

    @Override
    public ResponseVo orgDeleteById(OrgDeleteByIdBo orgDeleteByIdBo){
        Long id = orgDeleteByIdBo.getId();

        Long aLong = orgMapper.deleteByIdOrg(id);
        if (aLong.longValue() != 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",id, "0x200");
    }

    /**
     * @author zhuxinyu 2023-10-23
     *      通过id查找Org
     * @param orgSelectByIdBo
     * @return
     */
    @Override
    public ResponseVo orgSelectById(OrgSelectByIdBo orgSelectByIdBo) {

         Org org = orgMapper.selectByIdOrg(orgSelectByIdBo.getId());

        if (org == null) {
            return new ResponseVo("查询的数据不存在,", null, "0x500");
        }

        return new ResponseVo("查询成功",org,"0x200");
    }

    /**
     *@author zhuxinyu 2023-10-23
     *      通过id修改Org
     * @param orgUpdateByIdBo
     * @return
     */
    @Override
    public ResponseVo orgUpdateById(OrgUpdateByIdBo orgUpdateByIdBo){
        String orgIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long orgId = Long.valueOf(orgIdOfStr);

        Org org = orgUpdateByIdBo.getOrg();
        Long aLong = orgMapper.updateByIdOrg(org);

        if (aLong.longValue() == 0L) {
            return new ResponseVo("更新失败", null, "0x500");
        }
        return new ResponseVo("更新成功", org.getId(), "0x200");
    }

}
