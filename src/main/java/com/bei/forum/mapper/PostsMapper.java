package com.bei.forum.mapper;

import com.bei.forum.pojo.Posts;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostsMapper {

    Posts[] get(int id);

}
