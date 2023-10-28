package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.CommunityUser;

import java.io.Serializable;

public class CommunityUserUpdateByIdBo implements Serializable {
    private Long id;
    private CommunityUser communityUser;

    public CommunityUserUpdateByIdBo(){

    }

    public CommunityUserUpdateByIdBo(Long id, CommunityUser communityUser) {
        this.id = id;
        this.communityUser = communityUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CommunityUser getCommunityUser() {
        return communityUser;
    }

    public void setCommunityUser(CommunityUser communityUser) {
        this.communityUser = communityUser;
    }

    @Override
    public String toString() {
        return "CommunityUserUpdateByIdBo{" +
                "id=" + id +
                ", communityUser=" + communityUser +
                '}';
    }
}
