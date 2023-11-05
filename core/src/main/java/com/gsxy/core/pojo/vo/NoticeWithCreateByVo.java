package com.gsxy.core.pojo.vo;

import com.gsxy.core.pojo.Notice;
import com.gsxy.core.pojo.User;

/**
 * @author Oh...Yeah!!! 2023-11-5
 * 用户查看通知的实体类
 */
public class NoticeWithCreateByVo {

    private Notice notice;
    private User user;

    public NoticeWithCreateByVo() {
    }

    public NoticeWithCreateByVo(Notice notice, User user) {
        this.notice = notice;
        this.user = user;
    }


    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "NoticeWithCreateByVo{" +
                "notice=" + notice +
                ", user=" + user +
                '}';
    }
}
