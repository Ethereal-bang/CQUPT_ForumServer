package com.bei.forum.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Getter
@Setter
public class News {
    private Integer id;

    private Integer sender;

    private Integer receiver;

    private Integer carrierId;

    private String type;

    private Date createTime;

    private String content;

    private Boolean state;

    public String getCreateTime() {
        SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return fd.format(createTime);
    }

}