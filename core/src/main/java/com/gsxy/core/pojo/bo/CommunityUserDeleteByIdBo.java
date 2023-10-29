package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class CommunityUserDeleteByIdBo implements Serializable {
    private String token;
    private Long id;
    public CommunityUserDeleteByIdBo(){

    }

    public CommunityUserDeleteByIdBo(String token, Long id) {
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
        return "CommunityUserDeleteByIdBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
