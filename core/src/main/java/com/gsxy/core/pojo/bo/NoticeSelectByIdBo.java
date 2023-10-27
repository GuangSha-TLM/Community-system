package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.Notice;

import java.io.Serializable;

/**
 *  2023-10-27
 *  通过id查询数据
 */
public class NoticeSelectByIdBo implements Serializable {

    private String token;
    private Long id;

    public NoticeSelectByIdBo() {
    }

    public NoticeSelectByIdBo(String token, Long id) {
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
        return "NoticeSelectByIdBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
