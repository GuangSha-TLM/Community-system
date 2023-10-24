package com.gsxy.core.pojo;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhuxinyu 2023-10-23
 *      社团实体类
 */
public class Community implements Serializable {
    private Long id;
    private String name;    //社团班级
    private String createBy;    //创建人
    private Date createTime;    //创建时间
    private String updateBy;    //修改人
    private Date updateTime;    //修改时间
    private Integer status;     //状态
    private Integer del_flag;   //逻辑删除
    private String remark;      //备注
    public Community(){

    }

    public Community(Long id, String name, String createBy, Date createTime, String updateBy, Date updateTime, Integer status, Integer del_flag, String remark) {
        this.id = id;
        this.name = name;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.status = status;
        this.del_flag = del_flag;
        this.remark = remark;
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", del_flag=" + del_flag +
                ", remark='" + remark + '\'' +
                '}';
    }
}
