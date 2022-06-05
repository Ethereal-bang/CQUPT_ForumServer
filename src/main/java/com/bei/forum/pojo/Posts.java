package com.bei.forum.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Posts extends Articles {
    private Integer id;

    private String title;
    private String content;
    private String area, state;
    private final String type = "posts";

    private Date createTime;

    private Date updateTime;

    private Integer like;

    private Integer visit;

    private Integer collection;

    private Integer comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getVisit() {
        return visit;
    }

    public void setVisit(Integer visit) {
        this.visit = visit;
    }

    public Integer getCollection() {
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String getType() {
        return "posts";
    }
}