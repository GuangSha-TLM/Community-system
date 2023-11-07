package com.gsxy.core.pojo.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * SignInAdminWebSocket含token的Bo实体类
 */
public class SignInAdminWebSocketBo implements Serializable {

    private String token;
    private String content;//签到内容(管理员发布的)

    public SignInAdminWebSocketBo(String token, String content) {
        this.token = token;
        this.content = content;
    }

    public SignInAdminWebSocketBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SignInAdminWebSocketBo{" +
                "token='" + token + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
