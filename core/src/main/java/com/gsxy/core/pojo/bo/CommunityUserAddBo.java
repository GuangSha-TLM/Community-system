package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.CommunityUser;

import java.io.Serializable;

public class CommunityUserAddBo implements Serializable {
    private String token;
    private CommunityUser communityUser;//社团用户实体类
    public CommunityUserAddBo(){

    }

    public CommunityUserAddBo(String token, CommunityUser communityUser) {
        this.token = token;
        this.communityUser = communityUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public CommunityUser getCommunityUser() {
        return communityUser;
    }

    public void setCommunityUser(CommunityUser communityUser) {
        this.communityUser = communityUser;
    }

    @Override
    public String toString() {
        return "CommunityUserAddBo{" +
                "token='" + token + '\'' +
                ", communityUser=" + communityUser +
                '}';
    }
}
