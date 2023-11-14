package com.gsxy.core.mapper;

import com.gsxy.core.pojo.Notice;
import com.gsxy.core.pojo.SendNotification;
import com.gsxy.core.pojo.bo.NoticePagingToGetDataBo;
import com.gsxy.core.pojo.bo.SendNotificationBo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @author Oh...Yeah!!! 2023-10-28
 * 通知持久层实现类
 */
@Mapper
public interface NoticeMapper {


    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      根据用户id查看所有的通知.
     * @param userId
     * @return List<Notice>.class
     */
    public List<Notice> selectByIdNotice(Long userId);


    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      通过id删除数据.
     * @param id
     * @return Long.class
     */
    public Long deleteByIdNotice(Long id);

    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      增加新数据.
     * @param notice
     * @return Long.class
     */
    public Long addNotice(Notice notice);

    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      通过id更新数据.
     * @param notice
     * @return Long.class
     */
    public Long updateByIdNotice(Notice notice);

    /**
     * @author Oh...Yeah!!! 2023-10-28
     *    分页获取数据
     * @param noticePagingToGetDataBo
     * @return String.class
     */
    public List<Notice> noticePagingToGetData(NoticePagingToGetDataBo noticePagingToGetDataBo);

    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      根据UUID查找通知.
     * @param string
     * @return Notice.class
     */
    public Notice seleByUUID(String string);


    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      查找所有未阅读的通知.
     * @param userId
     * @return Long.class
     */
    public Long selectReadNotice(Long userId);

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      根据id查询数据.
     * @param id
     * @return Notice.class
     */
    public Notice noticeSelectByNoticeId(Long id);

    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      根据通知Id设置通知的阅读状态.
     * @param id
     * @return void
     */
    public Long updateByIdToRead(Long id);



    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      设置通知的处理状态.
     * @param noticeId
     * @return void
     */
    public void updateByIdToDealt(Long noticeId);

    /**
     * @author hln 2023-11-13
     *      社长（管理员）向社团成员发起签到通知
     * @param sendNotification
     * @return
     */
    Long insertNotice(SendNotification sendNotification);

    /**
     * @author hln 2023-11-14
     *      根据userId查询通知数据
     * @param userId
     * @return
     */
    Long selectByUserIdNotice(Long userId, Date date);
}



