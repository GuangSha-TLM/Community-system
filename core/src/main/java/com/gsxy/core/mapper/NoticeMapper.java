package com.gsxy.core.mapper;

import com.gsxy.core.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {


    /**
     * @author Oh… Yeah!!!, 2023-10-27
     *      根据id查询数据.
     * @param id
     * @return Notice.class
     */
    public Notice selectByIdNotice(Long id);


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



