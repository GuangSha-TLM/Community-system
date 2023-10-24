package com.gsxy.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.bo.ImgAddByBo;
import com.gsxy.core.pojo.bo.ImgDeleteByIdBo;
import com.gsxy.core.pojo.bo.ImgSelectByIdBo;
import com.gsxy.core.pojo.bo.ImgUpdateByIdBo;
import com.gsxy.core.service.ImgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  2023-10-12
 *  图片板块接口
 */
@CrossOrigin
@Api(value = "图片版块接口",tags = {"图片版块接口"})
@RestController
@RequestMapping("/img")
public class ImgController {

    @Autowired
    private ImgService imgService;

    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      根据id查询数据.
     * @param imgSelectByIdBo
     * @return String.class
     */
    @PostMapping("/select")
    @ApiOperation("根据id查询img数据")
    public String imgSelect(@RequestBody ImgSelectByIdBo imgSelectByIdBo){
        return JSONArray.toJSONString(imgService.imgSelectById(imgSelectByIdBo));
    }


    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id删除Img数据.
     * @param imgDeleteByIdBo
     * @return String.class
     */
    @PostMapping("/delete")
    @ApiOperation("通过id删除img数据")
    public String imgDeleteById(@RequestBody ImgDeleteByIdBo imgDeleteByIdBo){
        return JSONArray.toJSONString(imgService.imgDeleteById(imgDeleteByIdBo));
    }


    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      增加新数据.
     * @param imgAddByBo
     * @return String.class
     */
    @PostMapping("/add")
    @ApiOperation("增加img数据")
    public String imgAdd(@RequestBody ImgAddByBo imgAddByBo){
        return JSONArray.toJSONString(imgService.imgAdd(imgAddByBo));
    }



    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id更新Img数据.
     * @param imgUpdateByIdBo
     * @return String.class
     */
    @ApiOperation("通过id修改Img数据")
    @PostMapping("/update")
    public String imgUpdateById(@RequestBody ImgUpdateByIdBo imgUpdateByIdBo){
        return JSONArray.toJSONString(imgService.imgUpdateById(imgUpdateByIdBo));
    }



}
