package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class SignInWebSocketBo implements Serializable {

    private String token;
    private String content;//用户响应签到内容

    public SignInWebSocketBo(String token, String content) {
        this.token = token;
        this.content = content;
    }

    public SignInWebSocketBo() {
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
        return "SignInWebSocketBo{" +
                "token='" + token + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
