package com.gsxy.core.mapper;

import com.gsxy.core.pojo.UserAdmin;
import com.gsxy.core.pojo.bo.UserAdminPagingToGetDataBo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  管理员持久层
 */
@Mapper
public interface UserAdminMapper {

    @Select("select * from user_admin where user_id = #{userId} limit 1")
    public UserAdmin queryByUserId(@Param("userId")Long userId);

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

    /**
     * @author Oh...Yeah!!! 2023-10-28
     *    分页获取数据
     * @param userAdminPagingToGetDataBo
     * @return String.class
     */
    public List<UserAdmin> userAdminPagingToGetData(UserAdminPagingToGetDataBo userAdminPagingToGetDataBo);
}
