package com.gsxy.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.CommunityUserService;
import com.gsxy.core.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@Api(value = "社团用户板块接口" , tags = {"社团用户板块接口"})
@RequestMapping("/communityUser")
@RestController
public class CommunityUserController {
    @Autowired
    private CommunityUserService communityUserService;

    @PostMapping("/communityUserAdd")
    @ApiOperation("社团用户添加数据")
    public String CommunityUserAdd(@RequestBody CommunityUserAddBo communityUserAddBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityUserService.communityUseradd(communityUserAddBo));
    }
    @PostMapping("/communityUserDeleteById")
    @ApiOperation("社团用户删除数据")
    public String CommunityUserDeleteById(@RequestBody CommunityUserDeleteByIdBo communityUserDeleteByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityUserService.communityUserDeleteById(communityUserDeleteByIdBo));
    }

    @PostMapping("/communityUserSelectById")
    @ApiOperation("社团用户删除数据")
    public String CommunityUserSelectById(@RequestBody CommunityUserSelectByIdBo communityUserSelectByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityUserService.communityUserSelectById(communityUserSelectByIdBo));
    }

    @PostMapping("/communityUserUpdateById")
    @ApiOperation("社团用户删除数据")
    public String CommunityUserUpdateById(@RequestBody CommunityUserUpdateByIdBo communityUserUpdateByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityUserService.communityUserUpdateById(communityUserUpdateByIdBo));
    }
}
