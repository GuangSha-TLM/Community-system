package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.Active;

import java.io.Serializable;

public class ActivePagingQueryByTitleBo implements Serializable {

    private String token;
    private Active active;

    public ActivePagingQueryByTitleBo(String token, Active active) {
        this.token = token;
        this.active = active;
    }

    public ActivePagingQueryByTitleBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Active getActive() {
        return active;
    }

    public void setActive(Active active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ActivePagingQueryByTitleBo{" +
                "token='" + token + '\'' +
                ", active=" + active +
                '}';
    }
}
