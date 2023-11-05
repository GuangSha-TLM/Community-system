package com.gsxy.core.pojo.bo;

import io.swagger.models.auth.In;

import java.io.Serializable;

/**
 *  @author Oh...Yeah!!! 2023-10-31
 *  社长向用户发送回复通知
 */
public class CommunityReplyNoticeBo implements Serializable {

    private String token;
    private String context;
    private Long NoticeId;

    public CommunityReplyNoticeBo() {
    }

    public CommunityReplyNoticeBo(String token, String context, Long noticeId) {
        this.token = token;
        this.context = context;
        NoticeId = noticeId;
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

    public Long getNoticeId() {
        return NoticeId;
    }

    public void setNoticeId(Long noticeId) {
        NoticeId = noticeId;
    }

    @Override
    public String toString() {
        return "CommunityReplyNoticeBo{" +
                "token='" + token + '\'' +
                ", context='" + context + '\'' +
                ", NoticeId=" + NoticeId +
                '}';
    }
}