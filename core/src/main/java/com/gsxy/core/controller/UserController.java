package com.gsxy.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.User;
import com.gsxy.core.pojo.bo.UserDeleteByIdBo;
import com.gsxy.core.pojo.bo.UserLoginBo;
import com.gsxy.core.pojo.bo.UserSelectByUserIdBo;
import com.gsxy.core.pojo.bo.UserUpdateByUserIdBo;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.UserService;
import com.gsxy.core.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 2023-10-23
 *  用户控制器
 */
@CrossOrigin
@Api(value = "用户板块接口",tags = {"用户板块接口"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @author hln 2023-10-23
     *      用户注册
     * @param user
     * @return
     */
    @PostMapping("/userReg")
    @ApiOperation("用户注册")
    public String userReg(@RequestBody User user){
        if(user != null){
            JSONArray.toJSONString(new ResponseVo("参数为null",null,"0x455"));
        }

        return JSONArray.toJSONString(userService.userReg(user));
    }

    /**
     * @author hln 2023-10-23
     *      用户登录
     * @param userLoginBo
     * @return
     */
    @PostMapping("/Login")
    @ApiOperation("用户登录")
    public String userLogin(@RequestBody UserLoginBo userLoginBo){
        if(userLoginBo == null){
            JSONArray.toJSONString(new ResponseVo("参数为null",null,"0x455"));
        }

        return JSONArray.toJSONString(userService.userLogin(userLoginBo));
    }

    /**
     * @author hln 2023-10-23
     *      通过id查找用户
     * @param userSelectByUserIdBo
     * @return
     */
    @PostMapping("/select")
    @ApiOperation("通过id查找用户")
    public String selectByUserId(@RequestBody UserSelectByUserIdBo userSelectByUserIdBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(userService.selectByUserId(userSelectByUserIdBo));
    }

    /**
     * @author hln 2023-10-23
     *      通过id删除用户
     * @param userDeleteByIdBo
     * @return
     */
    @PostMapping("/delete")
    @ApiOperation("通过id删除用户")
    public String deleteByUserId(@RequestBody UserDeleteByIdBo userDeleteByIdBo){
        return JSONArray.toJSONString(userService.deleteByUserId(userDeleteByIdBo));
    }

    /**
     * @author hln 2023-10-23
     *      通过id修改用户
     * @param userUpdateByUserIdBo
     * @return
     */
    @PostMapping("/update")
    @ApiOperation("通过id修改用户")
    public String updateByUserId(@RequestBody UserUpdateByUserIdBo userUpdateByUserIdBo){
        return JSONArray.toJSONString(userService.updateByUserId(userUpdateByUserIdBo));
    }

    /**
     * @author hln 2023-10-23
     *      查找所有信息
     * @return
     */
    @PostMapping("/findAll")
    @ApiOperation("查询所有用户信息")
    public String userFindAll(){
        return JSONArray.toJSONString(userService.userFindAll());
    }

}

