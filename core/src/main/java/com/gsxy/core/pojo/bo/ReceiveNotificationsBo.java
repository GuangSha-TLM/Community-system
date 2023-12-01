package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class ReceiveNotificationsBo implements Serializable {

    private String token;
    private String content;//签到内容
    private String uuid;//uuid

    public ReceiveNotificationsBo(String token, String content, String uuid) {
        this.token = token;
        this.content = content;
        this.uuid = uuid;
    }

    public ReceiveNotificationsBo() {
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "ReceiveNotificationsBo{" +
                "token='" + token + '\'' +
                ", content='" + content + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
