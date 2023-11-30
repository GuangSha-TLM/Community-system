package com.gsxy.core.pojo.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * SignInAdminWebSocket含token的Bo实体类
 */
public class SignInAdminWebSocketBo implements Serializable {

    private String token;
    private String content;//签到内容(管理员发布的)
    private Date signInTime;//签到时长

    public SignInAdminWebSocketBo(String token, String content, Date signInTime) {
        this.token = token;
        this.content = content;
        this.signInTime = signInTime;
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

    public Date getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

    @Override
    public String toString() {
        return "SignInAdminWebSocketBo{" +
                "token='" + token + '\'' +
                ", content='" + content + '\'' +
                ", signInTime=" + signInTime +
                '}';
    }
}
