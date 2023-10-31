package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 * 用户签到返回给前端所需字段
 */
public class UserSignInStatusBo implements Serializable {

    private String name;//用户性名
    private Integer college;//学院
    private String grade;//年级
    private String professional;//专业
    private Integer org;//班级
    private String studentId;//学号
    private Integer status;//状态(0未签，1签到 默认为0)

    public UserSignInStatusBo(String name, Integer college, String grade, String professional, Integer org, String studentId, Integer status) {
        this.name = name;
        this.college = college;
        this.grade = grade;
        this.professional = professional;
        this.org = org;
        this.studentId = studentId;
        this.status = status;
    }

    public UserSignInStatusBo() {
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public Integer getOrg() {
        return org;
    }

    public void setOrg(Integer org) {
        this.org = org;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserSignInStatusBo{" +
                "name='" + name + '\'' +
                ", college=" + college +
                ", grade='" + grade + '\'' +
                ", professional='" + professional + '\'' +
                ", org=" + org +
                ", studentId='" + studentId + '\'' +
                ", status=" + status +
                '}';
    }
}
