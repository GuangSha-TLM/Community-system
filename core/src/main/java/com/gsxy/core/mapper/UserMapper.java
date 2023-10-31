package com.gsxy.core.mapper;

import com.gsxy.core.pojo.CommunityUser;
import com.gsxy.core.pojo.User;
import com.gsxy.core.pojo.bo.PagingToGetUserDataBo;
import com.gsxy.core.pojo.bo.UserLoginBo;
import com.gsxy.core.pojo.bo.UserSignInBo;
import com.gsxy.core.pojo.bo.UserSignInStatusBo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * @author hln 2023-10-23
     *      用户登录
     * @param userLoginBo
     * @return
     */
    User userLogin(UserLoginBo userLoginBo);

    /**
     * @author hln 2023-10-23
     *      根据用户名查询用户是否存在
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * @author hln 2023-10-23
     *      用户注册
     * @param user
     * @return
     */
    Long userReg(User user);

    /**
     * @author hln 2023-10-23
     *      通过id查找用户
     * @param userId
     * @return
     */
    User selectByUserId(Long userId);

    /**
     * @author hln 2023-10-23
     *      通过id删除用户
     * @param id
     * @return
     */
    Long deleteByUserId(Long id);

    /**
     * @author hln 2023-10-23
     *      通过id修改用户
     * @param user
     * @return
     */
    Long updateByUserId(User user);

    /**
     * @author hln 2023-10-23
     *      查找所有信息
     * @return
     */
    List<User> userFindAll();

    /**
     * @author hln 2023-10-27
     *      分页查询
     * @param pagingToGetUserDataBo
     * @return
     */
    List<User> pagingToGetUserData(PagingToGetUserDataBo pagingToGetUserDataBo);

    /**
     * @author hln 2023-10-27
     *      获取活动总数
     * @param pagingToGetUserDataBo
     * @return
     */
    Long pagingToGetCountOfUserData(PagingToGetUserDataBo pagingToGetUserDataBo);

    /**
     * @param id
     * @return
     * @author hln 2023-10-29
     * 通过id获取管理员权限
     */
    Integer selectByUserAndUserAdminId(Long id);

    /**
     * @quthor hln 2023-10-30
     *      查询用户签到状态
     * @param userSignInBo
     * @return
     */
    void userSignIn(UserSignInBo userSignInBo);

    /**
     * @quthor hln 2023-10-30
     *      根据user_id获取社团id
     * @param userSignInBo
     * @return
     */
    UserSignInBo selectToGetCommunityIdByUserId(UserSignInBo userSignInBo);

    /**
     * @author hln 2023-10-31
     *      删除签到记录（如果该社团没有该用户）
     * @param userSignInBo1
     */
    void deleteSignIn(UserSignInBo userSignInBo1);
}
