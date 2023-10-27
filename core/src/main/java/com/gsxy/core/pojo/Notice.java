package com.gsxy.core.pojo;

import java.util.Date;

/**
 *  2023-10-27
 *  通知实体类
 */
public class Notice {

    private Long id;
    //通知内容
    private String context;
    //用户id
    private Long userId;
    //关联的社团id
    private Long communityId;
    //关联的图片id
    private Long imgId;
    //关联的活动id
    private Long activeId;
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

    public Notice(Long id, String context, Long userId, Long communityId, Long imgId, Long activeId, Long createBy, Date createTime, Long updateBy, Date updateTime, Integer status, Integer delFlag) {
        this.id = id;
        this.context = context;
        this.userId = userId;
        this.communityId = communityId;
        this.imgId = imgId;
        this.activeId = activeId;
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Long getImgId() {
        return imgId;
    }

    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    public Long getActiveId() {
        return activeId;
    }

    public void setActiveId(Long activeId) {
        this.activeId = activeId;
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
                ", context='" + context + '\'' +
                ", userId=" + userId +
                ", communityId=" + communityId +
                ", imgId=" + imgId +
                ", activeId=" + activeId +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
