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

}
