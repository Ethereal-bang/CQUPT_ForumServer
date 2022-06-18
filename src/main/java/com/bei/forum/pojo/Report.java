package com.bei.forum.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Report {

    int id, reporter, reported, comment, post;
    String type;

}
