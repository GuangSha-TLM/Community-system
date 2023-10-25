package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.ActiveMapper;
import com.gsxy.core.pojo.Activity;
import com.gsxy.core.pojo.bo.ActiveAddBo;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.ActiveService;
import com.gsxy.core.util.ThreadLocalUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActiveService {

    @Autowired
    private ActiveMapper activeMapper;

    /**
     * @auhtor hln 2023-10-24
     *      添加活动功能
     * @param activityAddBo
     * @return
     */
    @Override
    public ResponseVo addActive(ActiveAddBo activityAddBo) {

        Long aLong = activeMapper.addActive(activityAddBo.getActivity());

        if (aLong == null){
            return new ResponseVo("增加失败",null,"0x500");
        }

        return new ResponseVo("增加成功",null,"0x200");
    }

    /**
     * @author hln 2023-10-25
     *      查询所有活动功能
     * @return
     */
    @Override
    public ResponseVo findAll() {

        List<Activity> list = activeMapper.findAll();

        if (list == null){
            return new ResponseVo("查询失败",list,"0x200");
        }

        return new ResponseVo("查询成功",list,"0x200");
    }

}
