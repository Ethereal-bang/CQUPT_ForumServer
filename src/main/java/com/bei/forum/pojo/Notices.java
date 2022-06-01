package com.bei.forum.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Notices extends Articles {
    private Integer id;

    private String title, content;

    private Date createTime;

    private Integer visit;

    private Integer like;

    private Integer collection;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

    public Integer getVisit() {
        return visit;
    }

    public void setVisit(Integer visit) {
        this.visit = visit;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getCollection() {
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }
}