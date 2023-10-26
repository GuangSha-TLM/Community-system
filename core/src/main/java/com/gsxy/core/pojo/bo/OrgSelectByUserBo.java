package com.gsxy.core.pojo.bo;

public class OrgSelectByUserBo {
    private Long id;
    private String token;
    private String username;//用户名
    private String name;//姓名
    private Integer college;//学院
    private String studentId;//学号
    private String org;//班级
    private String grade;//年级
    private Long updateBy;//创建人
    private Long createBy;//修改人

    public OrgSelectByUserBo(){

    }

    public OrgSelectByUserBo(Long id, String token, String username, String name, Integer college, String studentId, String org, String grade, Long updateBy, Long createBy) {
        this.id = id;
        this.token = token;
        this.username = username;
        this.name = name;
        this.college = college;
        this.studentId = studentId;
        this.org = org;
        this.grade = grade;
        this.updateBy = updateBy;
        this.createBy = createBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "OrgSelectByUserBo{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", college=" + college +
                ", studentId='" + studentId + '\'' +
                ", org='" + org + '\'' +
                ", grade='" + grade + '\'' +
                ", updateBy=" + updateBy +
                ", createBy=" + createBy +
                '}';
    }
}
