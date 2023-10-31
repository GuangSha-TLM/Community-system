package com.gsxy.core.pojo;

import java.io.Serializable;

/**
 * 用户签到表
 */
public class SignIn implements Serializable {

    private Long id;
    private Long userId;//用户ID
    private Integer status;//签到状态（0:未签，1签到 注：默认为0）

    public SignIn(Long id, Long userId, Integer status) {
        this.id = id;
        this.userId = userId;
        this.status = status;
    }

    public SignIn() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "SignIn{" +
                "id=" + id +
                ", userId=" + userId +
                ", status=" + status +
                '}';
    }
}
