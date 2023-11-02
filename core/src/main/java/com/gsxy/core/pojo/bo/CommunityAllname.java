package com.gsxy.core.pojo.bo;

import java.io.Serializable;

public class CommunityAllname implements Serializable {
    private String name;//社团名字
    private String introduce;//社团介绍
    private Long createBy;//社团创建人
    public CommunityAllname(){

    }

    public CommunityAllname(String name, String introduce, Long createBy) {
        this.name = name;
        this.introduce = introduce;
        this.createBy = createBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "CommunityAllname{" +
                "name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", createBy=" + createBy +
                '}';
    }
}
