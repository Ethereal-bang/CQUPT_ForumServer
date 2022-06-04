package com.bei.forum.mapper;

import com.bei.forum.pojo.Avatar;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AvatarMapper {

    Avatar[] showAll();

    String get(int order);

}
