package com.bei.forum.mapper;

import com.bei.forum.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {

    int getCount(String email);

    boolean add(Users users);

    boolean update(Users users);

    int selectId(String email);

    int selectIdByName(String name);

    Users[] select(int id);

}
