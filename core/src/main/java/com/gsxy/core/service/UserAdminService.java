package com.gsxy.core.service;

import com.gsxy.core.pojo.bo.UserAdminAddByBo;
import com.gsxy.core.pojo.bo.UserAdminDeleteByIdBo;
import com.gsxy.core.pojo.bo.UserAdminSelectByIdBo;
import com.gsxy.core.pojo.bo.UserAdminUpdateByIdBo;
import com.gsxy.core.pojo.vo.ResponseVo;

/**
 * 2023-10-24
 * 管理员业务接口
 */
public interface UserAdminService {


    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      根据id查询数据.
     * @param userAdminSelectByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo userAdminSelectById(UserAdminSelectByIdBo userAdminSelectByIdBo);


    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      通过id删除UserAdmin数据.
     * @param userAdminDeleteByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo userAdminDeleteById(UserAdminDeleteByIdBo userAdminDeleteByIdBo);

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      增加新数据.
     * @param userAdminAddByBo
     * @return ResponseVo.class
     */
    public ResponseVo userAdminAdd(UserAdminAddByBo userAdminAddByBo);

    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      通过id更新userAdmin数据.
     * @param userAdminUpdateByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo userAdminUpdateById(UserAdminUpdateByIdBo userAdminUpdateByIdBo);


    /**
     * @author Oh… Yeah!!!, 2023-10-24
     *      管理员登录验证
     * @param userAdminLoginBo
     * @return String.classs
     */
 /*   public ResponseVo userAdminLogin(UserAdminLoginBo userAdminLoginBo);

*/

}
