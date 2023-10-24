package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 * 用户登录
 */
public class UserLoginBo implements Serializable {

    private String token;
    private String username;
    private String password;

    public UserLoginBo(String token, String username, String password) {
        this.token = token;
        this.username = username;
        this.password = password;
    }

    public UserLoginBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginBo{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}