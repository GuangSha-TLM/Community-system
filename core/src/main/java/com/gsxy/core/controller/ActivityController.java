package com.gsxy.core.controller;

import com.gsxy.core.service.ActivityService;
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
    private ActivityService activityService;

//    @PostMapping("/add")
//    @ApiOperation("添加活动")
//    public String addActivity(@RequestBody ){
//
//    }

}
