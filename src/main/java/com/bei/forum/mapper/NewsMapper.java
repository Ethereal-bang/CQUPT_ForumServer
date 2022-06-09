package com.bei.forum.mapper;

import com.bei.forum.pojo.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface NewsMapper {

    Map<String, Object>[] showComment(int postId);

    int send(News news);
}
