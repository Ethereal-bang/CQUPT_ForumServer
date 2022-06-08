package com.bei.forum.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Getter
@Setter
public class Posts extends Articles {
    private Integer id;

    private String title, author;
    private String content;
    private String area, state;
    private final String type = "posts";

    private Date createTime;

    private Date updateTime;

    private Integer like;

    private Integer visit;

    private Integer collection;

    private Integer comment;

    public String getCreateTime() {
        SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return fd.format(createTime);
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        if (updateTime != null) {
            SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            return fd.format(updateTime);
        }
        return "";
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String getType() {
        return "posts";
    }
}