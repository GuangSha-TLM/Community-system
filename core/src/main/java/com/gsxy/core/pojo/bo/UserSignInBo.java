package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 * 用户签到返回前端实体类
 */
public class UserSignInBo implements Serializable {

    private String token;
    private Long userId;//用户ID
    private Integer status;//状态(0未签，1签到 默认为0)

    public UserSignInBo(String token, Long userId, Integer status) {
        this.token = token;
        this.userId = userId;
        this.status = status;
    }

    public UserSignInBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserSignInBo{" +
                "token='" + token + '\'' +
                ", userId=" + userId +
                ", status=" + status +
                '}';
    }
}
