package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 * @author zhuxinyu 2023-11-03
 *      删除社员
 */
public class CommunityUserdeleteUserBo implements Serializable {
    private String token;
    private Long communityId;//社团id
    private Long userId;//用户id
    public CommunityUserdeleteUserBo(){

    }

    public CommunityUserdeleteUserBo(String token, Long communityId, Long userId) {
        this.token = token;
        this.communityId = communityId;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CommunityUserdeleteUserBo{" +
                "token='" + token + '\'' +
                ", communityId=" + communityId +
                ", userId=" + userId +
                '}';
    }
}
