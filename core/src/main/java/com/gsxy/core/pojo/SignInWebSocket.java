package com.gsxy.core.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户签到表实体类-WebSocket实现
 */
public class SignInWebSocket implements Serializable {

    private Long id;
    private Long userId;//用户ID
    private String content;//签到响应内容
    private Long communityId;//社团ID
    private Date createTime;//签到时间

    public SignInWebSocket(Long id, Long userId, String content, Long communityId, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.communityId = communityId;
        this.createTime = createTime;
    }

    public SignInWebSocket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SignInWebSocket{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", communityId=" + communityId +
                ", createTime=" + createTime +
                '}';
    }
}
