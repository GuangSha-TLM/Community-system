package com.gsxy.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.bo.ActiveAddBo;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.ActiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api(value = "活动板块接口",tags = {"活动板块接口"})
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActiveService activeService;

    /**
     * @auhtor hln 2023-10-24
     *      添加活动功能
     * @param activeAddBo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("添加活动")
    public String addActive(@RequestBody ActiveAddBo activeAddBo){
        if (activeAddBo == null){
            JSONArray.toJSONString( new ResponseVo("参数为null", null, "0x455"));
        }

        return JSONArray.toJSONString(activeService.addActive(activeAddBo));
    }

}
