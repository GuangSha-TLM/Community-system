package com.gsxy.core.service;

import com.gsxy.core.pojo.bo.*;
import com.gsxy.core.pojo.vo.ResponseVo;

/**
 * 2023-10-27
 * 通知业务接口
 */
public interface NoticeService {


    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      用户查看通知.
     * @param noticeSelectByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo noticeSelectById(NoticeSelectByIdBo noticeSelectByIdBo);



    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      通过id删除数据.
     * @param noticeDeleteByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo noticeDeleteById(NoticeDeleteByIdBo noticeDeleteByIdBo);


    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      增加新数据.
     * @param noticeAddByBo
     * @return String.class
     */
    public ResponseVo noticeAdd(NoticeAddByBo noticeAddByBo);

    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      通过id更新数据.
     * @param noticeUpdateByIdBo
     * @return String.class
     */
    public ResponseVo userAdminUpdateById(NoticeUpdateByIdBo noticeUpdateByIdBo);


    /**
     * @author Oh...Yeah!!! 2023-10-28
     *    分页获取数据
     * @param noticePagingToGetDataBo
     * @return String.class
     */
    public ResponseVo pagingToGetNoticeData(NoticePagingToGetDataBo noticePagingToGetDataBo);


}

