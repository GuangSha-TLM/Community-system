package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.UserMapper;
import com.gsxy.core.pojo.Active;
import com.gsxy.core.pojo.CommunityUser;
import com.gsxy.core.pojo.User;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.PagingToGetUserDataVo;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.SystemService;
import com.gsxy.core.service.UserAdminService;
import com.gsxy.core.service.UserService;
import com.gsxy.core.util.JwtUtil;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserAdminService userAdminService;
    @Autowired
    private SystemService systemService;


    /**
     * @author hln 2023-10-23
     *      用户注册
     * @param user
     * @return
     */
    public ResponseVo userReg(User user){
        User username = userMapper.findByUsername(user.getUsername());

        if(username != null){
            return new ResponseVo("该username已经存在",null,"0x202");
        }

        user.setCreateTime(new Date());

        Long aLong = userMapper.userReg(user);

        if(aLong.longValue() == 0L){
            return new ResponseVo("注册失败",null,"0x500");
        }

        return new ResponseVo("注册成功",null,"0x200");
    }

    /**
     * @author hln 2023-10-23
     *      用户登录
     * @param userLoginBo
     * @return
     */
    public ResponseVo userLogin(UserLoginBo userLoginBo){
        //通过username去获取用户
        User user = userMapper.userLogin(userLoginBo);

        //比较用户密码和数据库中密码是否一致
        if(user == null || !user.getPassword().equals(userLoginBo.getPassword())){
            return new ResponseVo("登录失败",null,"0x500");
        }

        String jwt = JwtUtil.createJWT(user);

        //记录用户当前的登录时间
        user.setLoginTime(new Date());

        //返回数据库中 user 和 userAdmin 中前端想获取的数据
        int role = userMapper.selectByUserAndUserAdminId(user.getId());

        UserAndUserAdminSelectByIdBo userAndUserAdminSelectByIdBo = new UserAndUserAdminSelectByIdBo();
        BeanUtils.copyProperties(user,userAndUserAdminSelectByIdBo);
        userAndUserAdminSelectByIdBo.setRole(role);
        userAndUserAdminSelectByIdBo.setToken(jwt);

        return new ResponseVo("登录成功",userAndUserAdminSelectByIdBo,"0x200");
    }

    /**
     * @author hln 2023-10-23
     *      通过id查找用户信息
     * @param userSelectByUserIdBo
     * @return
     */
    @Override
    public ResponseVo selectByUserId(UserSelectByUserIdBo userSelectByUserIdBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        User user = userMapper.selectByUserId(userSelectByUserIdBo.getId());

        if(user == null){
            return new ResponseVo("查询条件不存在",null,"0x500");
        }

        return new ResponseVo("查找成功",user,"0x200");
    }

    /**
     * @author hln 2023-10-23
     *      通过id删除用户
     * @param userDeleteByIdBo
     * @return
     */
    @Override
    public ResponseVo deleteByUserId(UserDeleteByIdBo userDeleteByIdBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        Long aLong = userMapper.deleteByUserId(userDeleteByIdBo.getId());

        if(aLong == null || aLong.longValue() == 0L){
            return new ResponseVo("删除失败",null,"0x500");
        }

        return new ResponseVo("删除成功",aLong,"0x200");
    }

    /**
     * @author hln 2023-10-23
     *      通过id修改用户
     * @param userUpdateByUserIdBo
     * @return
     */
    @Override
    public ResponseVo updateByUserId(UserUpdateByUserIdBo userUpdateByUserIdBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        userUpdateByUserIdBo.getUser().setUpdateBy(userId);
        userUpdateByUserIdBo.getUser().setUpdateTime(new Date());
        User user = userUpdateByUserIdBo.getUser();
        Long aLong = userMapper.updateByUserId(user);

        if(aLong == null || aLong.longValue() == 0L){
            return new ResponseVo("修改失败",null,"0x500");
        }

        return new ResponseVo("修改成功",user.getId(),"0x200");
    }

    /**
     * @author hln 2023-10-23
     *      查找所有信息
     * @return
     */
    @Override
    public ResponseVo userFindAll() {
        List<User> list = userMapper.userFindAll();

        return new ResponseVo("查询成功",list,"0x200");
    }

    /**
     * @author hln 2023-10-27
     *      分页查询
     * @param pagingToGetUserDataBo
     * @return
     */
    @Override
    public ResponseVo pagingToGetUserData(PagingToGetUserDataBo pagingToGetUserDataBo) {

        //获取所有活动的数据
        List<User> userList = userMapper.pagingToGetUserData(pagingToGetUserDataBo);

        //获取活动总数
        Long count = userMapper.pagingToGetCountOfUserData(pagingToGetUserDataBo);

        PagingToGetUserDataVo pagingToGetUserDataVo = new PagingToGetUserDataVo();
        pagingToGetUserDataVo.setCount(count);
        pagingToGetUserDataVo.setList(userList);

        return new ResponseVo(null,pagingToGetUserDataVo,"0x200");
    }

    /**
     * @quthor hln 2023-10-30
     *      用户签到
     * @param userSignInBo
     * @return
     */
    @Override
    public ResponseVo userSignIn(UserSignInBo userSignInBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);//用户id

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        userSignInBo.setUserId(userId);
        userSignInBo.setCreateTime(new Date());
        userSignInBo.setStatus(1);
        //插入sign_in表中
        userMapper.userSignIn(userSignInBo);

        //根据user_id获取社团id
        UserSignInBo userSignInBo1 = userMapper.selectToGetCommunityIdByUserId(userSignInBo);

        if (userSignInBo1.getCommunityId() == null || userSignInBo1.getCommunityId() == 0L){
            userMapper.deleteSignIn(userSignInBo1);
            return new ResponseVo("签到失败",null,"0x500");
        }

        return new ResponseVo("签到成功",userSignInBo1,"0x200");
    }

}
