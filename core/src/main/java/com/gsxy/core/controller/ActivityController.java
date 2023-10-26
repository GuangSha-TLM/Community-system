package com.gsxy.core.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.core.pojo.Active;
import com.gsxy.core.pojo.bo.ActiveAddBo;
import com.gsxy.core.pojo.bo.ActiveDeleteByIdBo;
import com.gsxy.core.pojo.bo.ActiveSelectByIdBo;
import com.gsxy.core.pojo.bo.ActiveUpdateByIdBo;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.ActiveService;
import com.gsxy.core.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@Api(value = "活动板块接口",tags = {"活动板块接口"})
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActiveService activeService;

    /**
     * @auhtor hln 2023-10-25
     *      添加活动功能
     * @param activeAddBo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("添加活动")
    public String addActive(@RequestBody ActiveAddBo activeAddBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(activeService.addActive(activeAddBo));
    }

    /**
     * @author hln 2023-10-26
     *      根据id删除活动
     * @param activeDeleteByIdBo
     * @return
     */
    @PostMapping("/delete")
    @ApiOperation("根据id删除活动")
    public String deleteActive(@RequestBody ActiveDeleteByIdBo activeDeleteByIdBo){

        Map<String,String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(activeService.deleteActive(activeDeleteByIdBo));
    }

    /**
     * @author hln 2023-10-26
     *      根据id查询活动
     * @param activeSelectByIdBo
     * @return
     */
    @PostMapping("/select")
    @ApiOperation("根据id查询活动")
    public String selectActive(@RequestBody ActiveSelectByIdBo activeSelectByIdBo){

        Map<String,String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(activeService.selectActive(activeSelectByIdBo));
    }

    /**
     * @author hln 2023-10-26
     *      根据id修改活动
     * @param activeUpdateByIdBo
     * @return
     */
    @PostMapping("/update")
    @ApiOperation("根据id修改活动")
    public String updateActive(@RequestBody ActiveUpdateByIdBo activeUpdateByIdBo){

        Map<String,String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(activeService.updateActive(activeUpdateByIdBo));
    }

    /**
     * @author hln 2023-10-25
     *      查询所有活动功能
     * @return
     */
    @PostMapping("/findAll")
    @ApiOperation("查询所有活动")
    public String findAll(){
        return JSONArray.toJSONString(activeService.findAll());
    }

}
