package com.gsxy.core.pojo;

import javax.xml.crypto.Data;
import java.io.Serializable;

/**
 * @author zhuxinyu 2023-10-23
 *      班级实体类
 */
public class Org implements Serializable {
    private Long id;
    private Integer college;//学院
    private String grade;//年级
    private String name; //班级
    private String createBy; //创建人
    private Data createTime; //创建时间
    private String updateBy; //修改人
    private Data updateTime; //修改时间
    private Integer status;  //状态
    private Integer del_flag;//逻辑删除
    public Org(){

    }

    public Org(Long id, Integer college, String grade, String name, String createBy, Data createTime, String updateBy, Data updateTime, Integer status, Integer del_flag) {
        this.id = id;
        this.college = college;
        this.grade = grade;
        this.name = name;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.status = status;
        this.del_flag = del_flag;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Data getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Data createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Data getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Data updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }

    @Override
    public String toString() {
        return "Org{" +
                "id=" + id +
                ", college=" + college +
                ", grade='" + grade + '\'' +
                ", name='" + name + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", del_flag=" + del_flag +
                '}';
    }
}

