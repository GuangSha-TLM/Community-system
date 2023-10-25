package com.gsxy.core.pojo.bo;

import java.util.Date;

public class OrgAndUserBo {
    private Long id;
    private Integer college;//学院
    private String name;//班级
    private String grade;//年级
    private Date createTime;//创建时间
    private Date updateTime;//更新时间

    public OrgAndUserBo(){

    }
    public OrgAndUserBo(Long id, Integer college, String name, String grade, Date createTime, Date updateTime) {
        this.id = id;
        this.college = college;
        this.name = name;
        this.grade = grade;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCollege() {
        return college;
    }

    public void setCollege(Integer college) {
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "OrgAndUserBo{" +
                "id=" + id +
                ", college=" + college +
                ", org='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
