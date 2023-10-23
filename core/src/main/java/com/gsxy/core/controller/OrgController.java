package com.gsxy.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.bo.OrgAddBo;
import com.gsxy.core.pojo.bo.OrgDeleteByIdBo;
import com.gsxy.core.pojo.bo.OrgSelectByIdBo;
import com.gsxy.core.pojo.bo.OrgUpdateByIdBo;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.OrgService;
import com.gsxy.core.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@Api(value = "班级版块接口", tags = {"班级板块接口"})
@RestController
@RequestMapping("/org")
public class OrgController {

    @Autowired
    private OrgService orgService;

    @PostMapping("/add")
    @ApiOperation("添加Org数据")
    public String orgAdd(@RequestBody OrgAddBo orgAddByIdbo){
        Map<String , String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(orgService.orgAdd(orgAddByIdbo));
    }

    @PostMapping("/delete")
    @ApiOperation("通过id删除Org数据")
    public String orgDeleteById(@RequestBody OrgDeleteByIdBo orgDeleteByIdBo){
        return JSONArray.toJSONString(orgService.orgDeleteById(orgDeleteByIdBo));
    }

    @PostMapping("/select")
    @ApiOperation("根据userId查询Org数据")
    public String orgSelectById(@RequestBody OrgSelectByIdBo orgSelectByIdBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(orgService.orgSelectById(orgSelectByIdBo));
    }

    @PostMapping("/update")
    @ApiOperation("通过id修改Org数据")
    public String orgUpdateById(@RequestBody OrgUpdateByIdBo orgUpdateByIdBo){
        return JSONArray.toJSONString(orgService.orgUpdateById(orgUpdateByIdBo));
    }
}
