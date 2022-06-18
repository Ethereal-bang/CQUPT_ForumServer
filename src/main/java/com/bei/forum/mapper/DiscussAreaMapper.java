package com.bei.forum.mapper;

import com.bei.forum.pojo.DiscussArea;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DiscussAreaMapper {

    int addArea(DiscussArea discussArea);

    DiscussArea[] showAreas();

}
