package com.bei.forum.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Getter
@Setter
public class Notices extends Articles {
    private Integer id;

    private String title, content, area, state;

    private Date createTime;

    private Integer visit;

    private Integer like;

    private Integer collection;

    public String getCreateTime() {
        SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return fd.format(createTime);
    }

    @Override
    public String getType() {
        return "notices";
    }

    public Notices(String title, String content, String area) {
        this.title = title;
        this.content = content;
        this.area = area;
    }

}