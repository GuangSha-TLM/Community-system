package com.gsxy.core.pojo.bo;

import java.io.Serializable;
import java.util.Date;

public class UserAndUserAdminBo implements Serializable {

    private String username;
    private String name;
    private Integer college;
    private String studentId;
    private Integer org;
    private String professional;
    private String grade;
    private Date loginTime;
    private Integer role;

    public UserAndUserAdminBo(String username, String name, Integer college, String studentId, Integer org, String professional, String grade, Date loginTime, Integer role) {
        this.username = username;
        this.name = name;
        this.college = college;
        this.studentId = studentId;
        this.org = org;
        this.professional = professional;
        this.grade = grade;
        this.loginTime = loginTime;
        this.role = role;
    }

    public UserAndUserAdminBo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCollege() {
        return college;
    }

    public void setCollege(Integer college) {
        this.college = college;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getOrg() {
        return org;
    }

    public void setOrg(Integer org) {
        this.org = org;
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

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "user" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", college=" + college +
                ", studentId='" + studentId + '\'' +
                ", org=" + org +
                ", professional='" + professional + '\'' +
                ", grade='" + grade + '\'' +
                ", loginTime=" + loginTime +
                ", role=" + role +
                '}';
    }
}
