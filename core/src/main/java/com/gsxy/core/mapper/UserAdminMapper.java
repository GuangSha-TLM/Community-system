package com.gsxy.core.mapper;

import com.gsxy.core.pojo.SignInAdmin;
import com.gsxy.core.pojo.UserAdmin;
import com.gsxy.core.pojo.bo.SignInAdminBo;
import com.gsxy.core.pojo.bo.UserAdminPagingToGetDataBo;
import com.gsxy.core.pojo.bo.UserSignInStatusBo;
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

    /**
     * 2023-10-28
     *      在管理员库中查找目标用户.
     * @param userId
     * @return UserAdmin.class
     */
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

    /**
     * @author hln 2023-10-31
     *      插入发起签到信息到sign_in_admin表中
     * @param signInAdmin
     */
    void insertSignInAdmin(SignInAdmin signInAdmin);

    /**
     * @author hln 2023-10-31
     *      根据admin_id查询sign_in_admin表中相应数据
     * @param signInAdmin
     * @return
     */
    Long selectToGetByAdminId(SignInAdmin signInAdmin);

    /**
     * @author hln 2023-11-01
     *      管理员查看所有签到状态
     * @param userSignInStatusBo
     * @return
     */
    List<UserSignInStatusBo> findAllSignInStatus(UserSignInStatusBo userSignInStatusBo);
}
