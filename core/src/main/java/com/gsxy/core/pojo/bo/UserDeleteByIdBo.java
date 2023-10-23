package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class UserDeleteByIdBo implements Serializable {

    private String token;
    private String id;

    public UserDeleteByIdBo(String token, String id) {
        this.token = token;
        this.id = id;
    }

    public UserDeleteByIdBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDeleteByIdBo{" +
                "token='" + token + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
