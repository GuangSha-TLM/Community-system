package com.gsxy.core.pojo;

import java.util.Date;

/**
 * @author Oh...Yeah!!! 2023-10-28
 *  通知实体类
 */
public class Notice {

    private Long id;
    //收件箱人的id
    private Long userEmailId;
    //通知内容
    private String context;
    //用于查找新增的通知
    private String uuid;
    //关联的图片id
    private Long imgId;
    //名字
    private String name;
    //通知的阅读状态
    private Integer read;
    //通知的处理状态
    private Integer dealt;
    //创建人
    private Long createBy;
    //创建时间
    private Date createTime;
    //更新人
    private Long updateBy;
    //更新时间
    private Date updateTime;
    //状态
    private Integer status;
    //逻辑删除
    private Integer delFlag;

    public Notice() {
    }

    public Notice(Long id, Long userEmailId, String context, String uuid, Long imgId, String name, Integer read, Integer dealt, Long createBy, Date createTime, Long updateBy, Date updateTime, Integer status, Integer delFlag) {
        this.id = id;
        this.userEmailId = userEmailId;
        this.context = context;
        this.uuid = uuid;
        this.imgId = imgId;
        this.name = name;
        this.read = read;
        this.dealt = dealt;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.status = status;
        this.delFlag = delFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(Long userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getImgId() {
        return imgId;
    }

    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }

    public Integer getDealt() {
        return dealt;
    }

    public void setDealt(Integer dealt) {
        this.dealt = dealt;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
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

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", userEmailId=" + userEmailId +
                ", context='" + context + '\'' +
                ", uuid='" + uuid + '\'' +
                ", imgId=" + imgId +
                ", name='" + name + '\'' +
                ", read=" + read +
                ", dealt=" + dealt +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
