package com.gsxy.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.service.UserAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  2023-10-24
 *  管理员板块接口
 */
@CrossOrigin
@Api(value = "管理员版块接口",tags = {"管理员版块接口"})
@RestController
@RequestMapping("/user_admin")
public class UserAdminController {

    @Autowired
    private UserAdminService userAdminService;

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      根据id查询数据.
     * @param userAdminSelectByIdBo
     * @return String.class
     */
    @PostMapping("/select")
    @ApiOperation("根据id查询UserAdmin数据")
    public String userAdminSelect(@RequestBody UserAdminSelectByIdBo userAdminSelectByIdBo){
        return JSONArray.toJSONString(userAdminService.userAdminSelectById(userAdminSelectByIdBo));
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      通过id删除UserAdmin数据.
     * @param userAdminDeleteByIdBo
     * @return String.class
     */
    @PostMapping("/delete")
    @ApiOperation("通过id删除UserAdmin数据")
    public String userAdminDeleteById(@RequestBody UserAdminDeleteByIdBo userAdminDeleteByIdBo){
        return JSONArray.toJSONString(userAdminService.userAdminDeleteById(userAdminDeleteByIdBo));
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      增加新数据.
     * @param userAdminAddByBo
     * @return String.class
     */
    @PostMapping("/add")
    @ApiOperation("增加img数据")
    public String userAdminAdd(@RequestBody UserAdminAddByBo userAdminAddByBo){
        return JSONArray.toJSONString(userAdminService.userAdminAdd(userAdminAddByBo));
    }

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      通过id更新userAdmin数据.
     * @param userAdminUpdateByIdBo
     * @return String.class
     */
    @ApiOperation("通过id修改Img数据")
    @PostMapping("/update")
    public String userAdminUpdateById(@RequestBody UserAdminUpdateByIdBo userAdminUpdateByIdBo){
        return JSONArray.toJSONString(userAdminService.userAdminUpdateById(userAdminUpdateByIdBo));
    }



}
