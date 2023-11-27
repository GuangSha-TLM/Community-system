package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class SendNotificationBo implements Serializable {

    private String token;
    private String content;

    public SendNotificationBo(String token, String content) {
        this.token = token;
        this.content = content;
    }

    public SendNotificationBo() {
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
        return "SendNotificationBo{" +
                "token='" + token + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
