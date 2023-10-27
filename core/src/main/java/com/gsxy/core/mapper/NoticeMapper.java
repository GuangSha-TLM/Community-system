package com.gsxy.core.mapper;

import com.gsxy.core.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {


    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      用户查看通知.
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


}



