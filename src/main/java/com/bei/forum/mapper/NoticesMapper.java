package com.bei.forum.mapper;

import com.bei.forum.pojo.Notices;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticesMapper {

    Notices[] get(int id);

}
