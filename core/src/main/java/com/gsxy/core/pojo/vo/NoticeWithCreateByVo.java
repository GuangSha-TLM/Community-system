package com.gsxy.core.pojo.vo;

import com.gsxy.core.pojo.Notice;
import com.gsxy.core.pojo.User;

/**
 * @author Oh...Yeah!!! 2023-11-5
 * 用户查看通知的实体类
 */
public class NoticeWithCreateByVo {

    private Long id;
    private String name;
    private Long UserEmailId;
    private Long createBy;
    private String  context;
    private String userName;
    private String professional;
    private String grade;

    public NoticeWithCreateByVo() {
    }

    public NoticeWithCreateByVo(Long id, String name, Long userEmailId, Long createBy, String context, String userName, String professional, String grade) {
        this.id = id;
        this.name = name;
        UserEmailId = userEmailId;
        this.createBy = createBy;
        this.context = context;
        this.userName = userName;
        this.professional = professional;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserEmailId() {
        return UserEmailId;
    }

    public void setUserEmailId(Long userEmailId) {
        UserEmailId = userEmailId;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "NoticeWithCreateByVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", UserEmailId=" + UserEmailId +
                ", createBy=" + createBy +
                ", context='" + context + '\'' +
                ", userName='" + userName + '\'' +
                ", professional='" + professional + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
