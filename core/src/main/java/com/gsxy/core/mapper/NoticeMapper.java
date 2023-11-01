package com.gsxy.core.mapper;

import com.gsxy.core.pojo.Notice;
import com.gsxy.core.pojo.bo.NoticePagingToGetDataBo;
import org.apache.ibatis.annotations.Mapper;

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

}



