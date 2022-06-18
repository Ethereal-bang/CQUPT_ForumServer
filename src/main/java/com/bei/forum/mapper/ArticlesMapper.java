package com.bei.forum.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ArticlesMapper {

    String get(int id);

    int add(String type);

    int lastId();   // 返回最新发布的id

}
