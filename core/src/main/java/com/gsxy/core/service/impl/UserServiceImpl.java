package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.UserMapper;
import com.gsxy.core.pojo.User;
import com.gsxy.core.pojo.bo.UserDeleteByIdBo;
import com.gsxy.core.pojo.bo.UserLoginBo;
import com.gsxy.core.pojo.bo.UserSelectByUserIdBo;
import com.gsxy.core.pojo.bo.UserUpdateByUserIdBo;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.SystemService;
import com.gsxy.core.service.UserAdminService;
import com.gsxy.core.service.UserService;
import com.gsxy.core.util.JwtUtil;
import com.gsxy.core.util.RoleUtil;
import com.gsxy.core.util.ThreadLocalUtil;
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

        //此处对用户的权限进行判定
        systemService.auth(jwt);
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);
        RoleUtil.hashMap.put(userId,userAdminService.selectUserAdminByUserId(user));

        //记录用户当前的登录时间
        Date nowTime = new Date();

        //使用map将jwt和nowTime返回给前端
        HashMap<String, Date> map = new HashMap<>();
        map.put(jwt,nowTime);

        return new ResponseVo("登录成功",map,"0x200");
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

}
