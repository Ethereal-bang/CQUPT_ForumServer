package com.bei.forum.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class DiscussArea {

    int id;
    String name, url, words;

    public DiscussArea(String name, String url, String words) {
        this.name = name;
        this.url = url;
        this.words = words;
    }
}
