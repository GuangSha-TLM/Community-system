package com.gsxy.core.pojo.vo;

import java.util.List;

/**
 * @author Oh...Yeah!!! 2023-11-5
 * 用户查看通知返回结果的实体类
 */
public class NoticeListCountVo {

    private List<NoticeWithCreateByVo> list;
    private Long counts;

    public NoticeListCountVo() {
    }

    public NoticeListCountVo(List<NoticeWithCreateByVo> list, Long counts) {
        this.list = list;
        this.counts = counts;
    }

    public List<NoticeWithCreateByVo> getList() {
        return list;
    }

    public void setList(List<NoticeWithCreateByVo> list) {
        this.list = list;
    }

    public Long getCounts() {
        return counts;
    }

    public void setCounts(Long counts) {
        this.counts = counts;
    }

    @Override
    public String toString() {
        return "NoticeListCountVo{" +
                "list=" + list +
                ", counts=" + counts +
                '}';
    }
}
