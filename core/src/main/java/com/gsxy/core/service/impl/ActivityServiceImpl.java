package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.ActiveMapper;
import com.gsxy.core.pojo.Active;
import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;
import com.gsxy.core.service.ActiveService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActiveService {

    @Autowired
    private ActiveMapper activeMapper;

    /**
     * @auhtor hln 2023-10-24
     *      添加活动功能
     * @param activeAddBo
     * @return
     */
    @Override
    public ResponseVo addActive(ActiveAddBo activeAddBo) {

        Long aLong = activeMapper.addActive(activeAddBo.getActive());

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

        List<Active> list = activeMapper.findAll();

        if (list == null){
            return new ResponseVo("查询失败",null,"0x500");
        }

        return new ResponseVo("查询成功",list,"0x200");
    }

    /**
     * @author hln 2023-10-26
     *      根据id删除活动
     * @param activeDeleteByIdBo
     * @return
     */
    @Override
    public ResponseVo deleteActive(ActiveDeleteByIdBo activeDeleteByIdBo) {

        Long aLong = activeMapper.deleteActiveById(activeDeleteByIdBo.getId());

        if(aLong == null || aLong == 0L){
            return new ResponseVo("删除失败",null,"0x500");
        }

        return new ResponseVo("删除成功",aLong,"0x200");
    }

    /**
     * @author hln 2023-10-26
     *      根据id查询活动
     * @param activeSelectByIdBo
     * @return
     */
    @Override
    public ResponseVo selectActive(ActiveSelectByIdBo activeSelectByIdBo) {

        Long aLong = activeMapper.selectActiveById(activeSelectByIdBo);

        if(aLong == null || aLong == 0L){
            return new ResponseVo("查询失败",null,"0x500");
        }

        return new ResponseVo("查询成功",aLong,"0x200");
    }

    /**
     * @author hln 2023-10-26
     *      根据id修改活动
     * @param activeUpdateByIdBo
     * @return
     */
    @Override
    public ResponseVo updateActive(ActiveUpdateByIdBo activeUpdateByIdBo) {

        activeUpdateByIdBo.getActive().setUpdateBy(activeUpdateByIdBo.getActive().getId());
        activeUpdateByIdBo.getActive().setUpdateTime(new Date());
        Active active = activeUpdateByIdBo.getActive();
        Long aLong = activeMapper.updateActiveById(active);

        if (aLong == null || aLong == 0L) {
            return new ResponseVo("修改失败",null,"0x500");
        }

        return new ResponseVo("修改成功",active.getId(),"0x200");
    }

    /**
     * @author hln 2023-10-27
     *      根据title进行模糊查询
     * @param activePagingQueryByTitleBo
     * @return
     */
    @Override
    public ResponseVo pagingQuery(ActivePagingQueryByTitleBo activePagingQueryByTitleBo) {

        //调用数据库查询出所有符合条件的数据
        List<Active> list = activeMapper.pagingQueryByTitleBo(activePagingQueryByTitleBo);

        //判断集合是否为空，若为空则查询失败
        if(list == null){
            return new ResponseVo("查询失败",null,"0x500");
        }

        //若list不为空，返回结果
        return new ResponseVo("查询成功",list,"0x200");
    }

}
