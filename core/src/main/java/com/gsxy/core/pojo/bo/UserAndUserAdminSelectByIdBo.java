package com.gsxy.core.pojo.bo;

import java.io.Serializable;
import java.util.Date;

public class UserAndUserAdminSelectByIdBo implements Serializable {

    private String token;
    private Integer college;
    private String grade;
    private Long id;
    private Date loginTime;
    private String name;
    private Integer org;
    private String password;
    private String professional;
    private String studentId;
    private String username;
    private Integer role;

    public UserAndUserAdminSelectByIdBo(String token, Integer college, String grade, Long id, Date loginTime, String name, Integer org, String password, String professional, String studentId, String username, Integer role) {
        this.token = token;
        this.college = college;
        this.grade = grade;
        this.id = id;
        this.loginTime = loginTime;
        this.name = name;
        this.org = org;
        this.password = password;
        this.professional = professional;
        this.studentId = studentId;
        this.username = username;
        this.role = role;
    }

    public UserAndUserAdminSelectByIdBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getCollege() {
        return college;
    }

    public void setCollege(Integer college) {
        this.college = college;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrg() {
        return org;
    }

    public void setOrg(Integer org) {
        this.org = org;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "token='" + token + '\'' +
                ", college=" + college +
                ", grade='" + grade + '\'' +
                ", id=" + id +
                ", loginTime=" + loginTime +
                ", name='" + name + '\'' +
                ", org=" + org +
                ", password='" + password + '\'' +
                ", professional='" + professional + '\'' +
                ", studentId='" + studentId + '\'' +
                ", username='" + username + '\'' +
                ", role=" + role +
                '}';
    }
}
