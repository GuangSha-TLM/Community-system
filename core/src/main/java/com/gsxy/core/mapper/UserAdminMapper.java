package com.gsxy.core.mapper;

import com.gsxy.core.pojo.UserAdmin;
import org.apache.ibatis.annotations.Mapper;

/**
 *  2023-10-24
 *  管理员持久层
 */
@Mapper
public interface UserAdminMapper {


    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      根据id查询数据.
     * @param id
     * @return UserAdmin.class
     */
    public UserAdmin selectByIdUserAdmin(Long id);


    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      通过id删除UserAdmin数据.
     * @param id
     * @return Long.class
     */
    public Long deleteByIdUserAdmin(Long id);


    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      增加新数据.
     * @param userAdmin
     * @return Long.class
     */
    public Long addUserAdmin(UserAdmin userAdmin);


    /**
     * @author Oh… Yeah!!!, 2023-10-23
     *      通过id更新userAdmin数据.
     * @param userAdmin
     * @return Long.class
     */
    public Long updateByIdUserAdmin(UserAdmin userAdmin);



}
