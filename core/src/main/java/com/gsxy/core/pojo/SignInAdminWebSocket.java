package com.gsxy.core.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员发起签到实体类-WebSocket实现
 */
public class SignInAdminWebSocket implements Serializable {

    private Long id;
    private Long adminId;//管理员ID
    private Long communityId;//社团ID
    private String content;//签到内容(管理员发布的)
    private Date releaseTime;//发布时间

    public SignInAdminWebSocket(Long id, Long adminId, Long communityId, String content, Date releaseTime) {
        this.id = id;
        this.adminId = adminId;
        this.communityId = communityId;
        this.content = content;
        this.releaseTime = releaseTime;
    }

    public SignInAdminWebSocket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Override
    public String toString() {
        return "SignInAdminWebSocket{" +
                "id=" + id +
                ", adminId=" + adminId +
                ", communityId=" + communityId +
                ", content='" + content + '\'' +
                ", releaseTime=" + releaseTime +
                '}';
    }
}