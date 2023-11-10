package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class ActiveAddBo implements Serializable {

    private String token;

    private String context;

    private String title;

    public ActiveAddBo(String token, String context, String title) {
        this.token = token;
        this.context = context;
        this.title = title;
    }

    public ActiveAddBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ActiveAddBo{" +
                "token='" + token + '\'' +
                ", context='" + context + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

