package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.UserAdminMapper;
import com.gsxy.core.pojo.SignInAdmin;
import com.gsxy.core.pojo.UserAdmin;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.pojo.vo.UserAdminPagingToGetDataVo;
import com.gsxy.core.service.UserAdminService;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *  @author Oh...Yeah!!! 2023-10-28
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

        UserAdmin userAdmin = userAdminUpdateByIdBo.getUserAdmin();
        Long numbersOfOpertion = userAdminMapper.updateByIdUserAdmin(userAdmin);
        if (numbersOfOpertion.longValue() == 0L){
            return new ResponseVo("更新失败", null, "0x500");
        }

        return new ResponseVo("更新成功", null, "0x200");

    }

    /**
     * @author Oh...Yeah!!! 2023-10-28
     *    分页获取数据
     * @param userAdminPagingToGetDataBo
     * @return String.class
     */
    @Override
    public Object pagingToGetUserAdminData(UserAdminPagingToGetDataBo userAdminPagingToGetDataBo) {

        List<UserAdmin> list = userAdminMapper.userAdminPagingToGetData(userAdminPagingToGetDataBo);
        UserAdminPagingToGetDataVo userAdminPagingToGetDataVo = new UserAdminPagingToGetDataVo();
        userAdminPagingToGetDataVo.setCount(list.size());
        userAdminPagingToGetDataVo.setList(list);

        return new ResponseVo<>(null,userAdminPagingToGetDataVo,"0x200");

    }

    /**
     * @author hln 2023-10-31
     *      管理员发起签到
     * @param signInAdminBo
     * @return
     */
    @Override
    public ResponseVo userAdminSignIn(SignInAdminBo signInAdminBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long adminId = Long.valueOf(userIdOfStr);

        if (adminId == null || adminId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        SignInAdmin signInAdmin = new SignInAdmin();
        signInAdmin.setAdminId(adminId);
        signInAdmin.setCreateTime(new Date());

        //插入发起签到信息到sign_in_admin表中
        userAdminMapper.insertSignInAdmin(signInAdmin);

        //查找社团id
        SignInAdmin signInAdmin1 = userAdminMapper.selectToGetCommunityId(signInAdmin);

        if (signInAdmin1 != null){
            userAdminMapper.deleteByIdSignIn(signInAdmin1);
            userAdminMapper.insertSignInAdmin(signInAdmin1);
        }

        //根据admin_id查询sign_in_admin表中相应数据
        Long id = userAdminMapper.selectToGetByAdminId(signInAdmin1);

        if (id == null){
            return new ResponseVo("签到发起失败",null,"0x500");
        }

        signInAdminBo.setSignInAdmin(signInAdmin1);

        //- ------------
        //插入最终实体数据到sign_in_user_status表中
        UserSignInStatusBo userSignInStatusBo = new UserSignInStatusBo();

        //获取需要使用的user表中字段
        UserSignBo userSignBo = new UserSignBo();
        userSignBo.setUserId(adminId);

        //映射user和signInAdmin中需要的字段值到userSignInStatusBo中
        userSignInStatusBo.setAdminId(signInAdmin1.getAdminId());
        userSignInStatusBo.setCommunityId(signInAdmin1.getCommunityId());
        userSignInStatusBo.setCreateTime(signInAdmin1.getCreateTime());

        //先将sign_in_admin中查找出的字段放到sign_in_user_status表中
        userAdminMapper.insertSignInUserStatus(userSignInStatusBo);//bug

        //查询实体类所需返回全部字段
        UserSignInStatusBo userSignInStatusBo1 = userAdminMapper.selectToGetUserBo(userSignInStatusBo);

        if (userSignInStatusBo1 != null) {
            //删除实体类中的不全信息
            userAdminMapper.deleteBYIdToStatus(userSignInStatusBo1);

            //插入所有的实体类信息
            userAdminMapper.insertSignInUserStatusAll(userSignInStatusBo1);
        }
// ---------------------

        return new ResponseVo("签到已发起",signInAdminBo,"0x200");
    }

    /**
     * @author hln 2023-11-01
     *      管理员查看所有签到状态
     * @return
     */
    @Override
    public ResponseVo findAllSignInStatus() {
        List<UserSignInStatusBo> list = userAdminMapper.findAllSignInStatus();

        if(list == null){
            return new ResponseVo("查询失败",null,"0x500");
        }

        return new ResponseVo("查询成功",list,"0x200");
    }

}
