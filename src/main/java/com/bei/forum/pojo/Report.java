package com.bei.forum.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Report {

    int id, reporter, comment, post;
    String reported, type, content;

    public Report(int reporter, String reported, String type, String content) {
        this.reported = reported;
        this.reporter = reporter;
        this.type = type;
        this.content = content;
    }
}
