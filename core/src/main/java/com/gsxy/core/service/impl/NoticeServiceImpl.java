package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.NoticeMapper;
import com.gsxy.core.pojo.Notice;
import com.gsxy.core.pojo.UserAdmin;
import com.gsxy.core.pojo.bo.NoticeAddByBo;
import com.gsxy.core.pojo.bo.NoticeDeleteByIdBo;
import com.gsxy.core.pojo.bo.NoticeSelectByIdBo;
import com.gsxy.core.pojo.bo.NoticeUpdateByIdBo;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.NoticeService;
import com.gsxy.core.util.RoleUtil;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      用户查看通知.
     * @param noticeSelectByIdBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo noticeSelectById(NoticeSelectByIdBo noticeSelectByIdBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if (userId == null || userId == 0L) {
            return new ResponseVo("token解析失败", null, "0x501");
        }

        List<Notice> list = noticeMapper.selectByIdNotice(userId);

        if (list == null) {
            return new ResponseVo("查询的数据不存在,", null, "0x500");
        }

        return new ResponseVo("查询成功", list, "0x200");

    }

    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      通过id删除数据.
     * @param noticeDeleteByIdBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo noticeDeleteById(NoticeDeleteByIdBo noticeDeleteByIdBo) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }


        //只有管理员才可以操作通知面板
        UserAdmin admin = RoleUtil.hashMap.get(userId);
        if (admin == null ||admin.getRole()  < 2 ){
            return new ResponseVo<>("用户权限不足,不能执行此操作",null,"507");
        }

        Long id = noticeDeleteByIdBo.getId();
        Long numbersOfOpetion = noticeMapper.deleteByIdNotice(id);

        if (numbersOfOpetion.longValue() == 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",null, "0x200");
    }



    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      增加新数据.
     * @param noticeAddByBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo noticeAdd(NoticeAddByBo noticeAddByBo) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        //只有管理员才可以操作通知面板
        UserAdmin admin = RoleUtil.hashMap.get(userId);
        if (admin == null ||admin.getRole()  < 2 ){
            return new ResponseVo<>("用户权限不足,不能执行此操作",null,"507");
        }


        Long aLong = noticeMapper.addNotice(noticeAddByBo.getNotice());

        if (aLong.longValue() == 0){
            return new ResponseVo("增加失败",  null, "0x500");
        }
        return new ResponseVo("增加成功", null, "0x200");

    }

    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      通过id更新数据.
     * @param noticeUpdateByIdBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo userAdminUpdateById(NoticeUpdateByIdBo noticeUpdateByIdBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        //只有管理员才可以操作通知面板
        UserAdmin admin = RoleUtil.hashMap.get(userId);
        if (admin == null ||admin.getRole()  < 2 ){
            return new ResponseVo<>("用户权限不足,不能执行此操作",null,"507");
        }

        Notice notice = noticeUpdateByIdBo.getNotice();
        Long numbersOfOpertion = noticeMapper.updateByIdNotice(notice);

        if (numbersOfOpertion.longValue() == 0L){
            return new ResponseVo("更新失败", null, "0x500");
        }

        return new ResponseVo("更新成功", null, "0x200");

    }


}

