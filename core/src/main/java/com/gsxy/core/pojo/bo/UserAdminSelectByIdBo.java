package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 *  2023-10-24
 *  通过id查询useradmin
 */
public class UserAdminSelectByIdBo implements Serializable {

    private String token;
    private Long id;

    public UserAdminSelectByIdBo() {
    }

    public UserAdminSelectByIdBo(String token, Long id) {
        this.token = token;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserAdminSelectByIdBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
