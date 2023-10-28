package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.Notice;

import java.io.Serializable;

/**
 *  @author Oh...Yeah!!! 2023-10-28
 *  通过id查询数据
 */
public class NoticeSelectByIdBo implements Serializable {

    private String token;

    public NoticeSelectByIdBo() {
    }

    public NoticeSelectByIdBo(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "NoticeSelectByIdBo{" +
                "token='" + token + '\'' +
                '}';
    }
}
