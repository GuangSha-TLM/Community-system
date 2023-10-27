package com.gsxy.core.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.mapper.UserAdminMapper;
import com.gsxy.core.pojo.User;
import com.gsxy.core.pojo.UserAdmin;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.UserAdminService;
import com.gsxy.core.util.RoleUtil;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  2023-10-23
 *  管理员业务接口实现类
 */
@Service
public class UserAdminServiceImpl implements UserAdminService {

    @Autowired
    private UserAdminMapper userAdminMapper;

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      根据id查询数据.
     * @param userAdminSelectByIdBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo userAdminSelectById(UserAdminSelectByIdBo userAdminSelectByIdBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        //进行权限判定，只有管理员和超级管理员才可以操作管理员面板
        UserAdmin admin = RoleUtil.hashMap.get(userId);
        if (admin == null ||admin.getRole()  < 2 ){
            return new ResponseVo<>("用户权限不足,不能执行此操作",null,"507");
        }

        UserAdmin userAdmin = userAdminMapper.selectByIdUserAdmin(userAdminSelectByIdBo.getId());

        if (userAdmin == null) {
            return new ResponseVo("查询的数据不存在,", null, "0x500");
        }

        return new ResponseVo("查询成功", userAdmin, "0x200");
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      通过id删除UserAdmin数据.
     * @param userAdminDeleteByIdBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo userAdminDeleteById(UserAdminDeleteByIdBo userAdminDeleteByIdBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        //进行权限判定，只有管理员和超级管理员才可以操作管理员面板
        UserAdmin admin = RoleUtil.hashMap.get(userId);
        if (admin == null ||admin.getRole()  < 2 ){
            return new ResponseVo<>("用户权限不足,不能执行此操作",null,"507");
        }

        Long id = userAdminDeleteByIdBo.getId();
        Long numbersOfOpetion = userAdminMapper.deleteByIdUserAdmin(id);

        if (numbersOfOpetion.longValue() == 0L) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",null, "0x200");

    }


    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      增加新数据.
     * @param userAdminAddByBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo userAdminAdd(UserAdminAddByBo userAdminAddByBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        //进行权限判定，只有管理员和超级管理员才可以操作管理员面板
        UserAdmin admin = RoleUtil.hashMap.get(userId);
        if (admin == null ||admin.getRole()  < 2 ){
            return new ResponseVo<>("用户权限不足,不能执行此操作",null,"507");
        }

        Long aLong = userAdminMapper.addUserAdmin(userAdminAddByBo.getUserAdmin());

        if (aLong.longValue() == 0){
            return new ResponseVo("增加失败",  null, "0x500");
        }
        return new ResponseVo("增加成功", null, "0x200");
    }


    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      通过id更新userAdmin数据.
     * @param userAdminUpdateByIdBo
     * @return ResponseVo.class
     */
    @Override
    public ResponseVo userAdminUpdateById(UserAdminUpdateByIdBo userAdminUpdateByIdBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }


        //进行权限判定，只有管理员和超级管理员才可以操作管理员面板
        UserAdmin admin = RoleUtil.hashMap.get(userId);
        if (admin == null ||admin.getRole()  < 2 ){
            return new ResponseVo<>("用户权限不足,不能执行此操作",null,"507");
        }

        UserAdmin userAdmin = userAdminUpdateByIdBo.getUserAdmin();
        Long numbersOfOpertion = userAdminMapper.updateByIdUserAdmin(userAdmin);

        if (numbersOfOpertion.longValue() == 0L){
            return new ResponseVo("更新失败", null, "0x500");
        }

        return new ResponseVo("更新成功", null, "0x200");

    }


    /**
     * @author Oh...Yeah!!! 2023-10-26
     *      权限认证
     * @param user
     * @return UserAdmin.class
     */
    @Override
    public UserAdmin selectUserAdminByUserId(User user) {

        return userAdminMapper.selectUserAdminByUserId(user.getId());

    }



}
