package com.gsxy.core.pojo;

import java.io.Serializable;
import java.util.Date;

public class SignInAdmin implements Serializable {

    private Long id;
    private Long adminId;//管理员ID
    private Integer status;//签到状态(0 未签,1签到)
    private Date createTime;//签到发布时间

    public SignInAdmin(Long id, Long adminId, Integer status, Date createTime) {
        this.id = id;
        this.adminId = adminId;
        this.status = status;
        this.createTime = createTime;
    }

    public SignInAdmin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SignInAdmin{" +
                "id=" + id +
                ", adminId=" + adminId +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
