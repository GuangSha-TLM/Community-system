package com.gsxy.core.controller;


import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.bo.CommunityAddBo;
import com.gsxy.core.pojo.bo.CommunityDeleteByIdBo;
import com.gsxy.core.pojo.bo.CommunitySelectByIdBo;
import com.gsxy.core.pojo.bo.CommunityUpdateByIdBo;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.CommunityService;
import com.gsxy.core.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zhuxinyu 2023-10-24
 *      社团板块控制器
 */
@CrossOrigin
@Api(value = "社团板块接口" , tags = {"社团板块接口"})
@RestController
@RequestMapping("/community")
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    /**
     * @author zhuxinyu 2023-10-24
     *      添加社团数据
     * @param communityAddByIdBo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("添加社团数据")
    public String Communityadd(@RequestBody CommunityAddBo communityAddByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(communityService.addCommunity(communityAddByIdBo));
    }

    /**
     * @author zhuxinyu 2023-10-24
     *      通过id删除社团数据
     * @param communityDeleteByIdBo
     * @return
     */
    @PostMapping("/delete")
    @ApiOperation("通过id删除社团数据")
    public String CommunityDeleteById(@RequestBody CommunityDeleteByIdBo communityDeleteByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityService.deleteByIdCommunity(communityDeleteByIdBo));
    }

    /**
     * @author zhuxinyu 2023-10-24
     *      通过id查找社团数据
     * @param communitySelectByIdBo
     * @return
     */
    @PostMapping("/select")
    @ApiOperation("通过id查找社团数据")
    public String CommunitySelectById(@RequestBody CommunitySelectByIdBo communitySelectByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityService.selectByIdCommunity(communitySelectByIdBo));
    }

    /**
     * @author zhuxinyu 2023-10-24
     *      通过id修改社团数据
     * @param communityUpdateByIdBo
     * @return
     */
    @PostMapping("/update")
    @ApiOperation("通过id修改社团数据")
    public String CommunityUpdateById(@RequestBody CommunityUpdateByIdBo communityUpdateByIdBo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(communityService.updateByIdCommunity(communityUpdateByIdBo));
    }
}
