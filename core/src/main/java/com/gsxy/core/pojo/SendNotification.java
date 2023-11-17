package com.gsxy.core.pojo;

import java.io.Serializable;
import java.util.Date;

public class SendNotification implements Serializable {

    private Long createBy;//创建人
    private Date createTime;//创建时间
    private String context = "签到";//签到内容
    private Long userId;//用户ID

    public SendNotification(Long createBy, Date createTime, String context, Long userId) {
        this.createBy = createBy;
        this.createTime = createTime;
        this.context = context;
        this.userId = userId;
    }

    public SendNotification() {
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SendNotification{" +
                "createBy=" + createBy +
                ", createTime=" + createTime +
                ", context='" + context + '\'' +
                ", userId=" + userId +
                '}';
    }
}
