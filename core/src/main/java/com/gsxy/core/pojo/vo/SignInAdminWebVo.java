package com.gsxy.core.pojo.vo;

import java.util.Date;

public class SignInAdminWebVo {

    private Long id;
    private Long communityId;
    private String content;
    private Date releaseTime;

    public SignInAdminWebVo(Long id, Long communityId, String content, Date releaseTime) {
        this.id = id;
        this.communityId = communityId;
        this.content = content;
        this.releaseTime = releaseTime;
    }

    public SignInAdminWebVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "SignInAdminWebVo{" +
                "id=" + id +
                ", communityId=" + communityId +
                ", content='" + content + '\'' +
                ", releaseTime=" + releaseTime +
                '}';
    }
}
