package com.gsxy.core.mapper;

import com.gsxy.core.pojo.Img;
import org.apache.ibatis.annotations.Mapper;

/**
 *  2023-10-23
 *  图片持久层
 */
@Mapper
public interface ImgMapper {

    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      根据id查询数据.
     * @param id
     * @return Img.class
     */
    public Img selectByIdImg(Long id);

    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id删除Img数据.
     * @param id
     * @return String.class
     */
    public Long deleteByIdImg(Long id);

    /**
     * @author Oh… Yeah!!! 2023-10-23
     *      增加新数据.
     * @param img
     * @return String.class
     */
    public Long addImg(Img img);

    /**
     * @author Oh… Yeah, 2023-10-23
     *      通过id更新Img数据.
     * @param img
     * @return String.class
     */
    public Long updateByIdImg(Img img);
}
