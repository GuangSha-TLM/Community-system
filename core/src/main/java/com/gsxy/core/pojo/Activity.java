package com.gsxy.core.pojo;


import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.Date;

public class Activity implements Serializable {

    private Long id;//ID
    private String title;//活动标题
    private Text context;//活动内容
    private Integer community;//所属社团活动
    private String communityList;//status为1的时候存放所有参加社团的json str
    private Date startTime;//开始时间
    private Date endTime;//结束时间
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
    private Integer updateBy;//修改人
    private Integer createBy;//创建人
    private Integer status;//0为私有活动 1多个社团活动 2 所有社团活动
    private Integer delFlag;//逻辑删除

    public Activity(Long id, String title, Text context, Integer community, String communityList, Date startTime, Date endTime, Date createTime, Date updateTime, Integer updateBy, Integer createBy, Integer status, Integer delFlag) {
        this.id = id;
        this.title = title;
        this.context = context;
        this.community = community;
        this.communityList = communityList;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
        this.createBy = createBy;
        this.status = status;
        this.delFlag = delFlag;
    }

    public Activity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Text getContext() {
        return context;
    }

    public void setContext(Text context) {
        this.context = context;
    }

    public Integer getCommunity() {
        return community;
    }

    public void setCommunity(Integer community) {
        this.community = community;
    }

    public String getCommunityList() {
        return communityList;
    }

    public void setCommunityList(String communityList) {
        this.communityList = communityList;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
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
        return "Activity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", context=" + context +
                ", community=" + community +
                ", communityList='" + communityList + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", updateBy=" + updateBy +
                ", createBy=" + createBy +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
