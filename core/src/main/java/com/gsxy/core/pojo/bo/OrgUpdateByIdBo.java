package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.Org;

import java.io.Serializable;

public class OrgUpdateByIdBo implements Serializable {
    private String token;
    private Org org;

    public OrgUpdateByIdBo(){

    }

    public OrgUpdateByIdBo(String token, Org org) {
        this.token = token;
        this.org = org;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    @Override
    public String toString() {
        return "OrgUpdateByIdBo{" +
                "token='" + token + '\'' +
                ", org=" + org +
                '}';
    }
}
