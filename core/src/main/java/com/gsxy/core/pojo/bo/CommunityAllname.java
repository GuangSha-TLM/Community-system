package com.gsxy.core.pojo.bo;

import java.io.Serializable;

/**
 * @author zhuxinyu 2023-11-02
 *      查找所有社团
 */
public class CommunityAllname implements Serializable {
    private Long   communityId;//社团id
    private String name;//社团名字
    private String introduce;//社团介绍
    private String names;//创建人姓名

    public CommunityAllname(){

    }

    public CommunityAllname(Long communityId, String name, String introduce, String names) {
        this.communityId = communityId;
        this.name = name;
        this.introduce = introduce;
        this.names = names;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
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

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "CommunityAllname{" +
                "communityId=" + communityId +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", names='" + names + '\'' +
                '}';
    }
}
