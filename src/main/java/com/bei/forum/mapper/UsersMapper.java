package com.bei.forum.mapper;

import com.bei.forum.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UsersMapper {

    int getCount(String email);

    boolean add(Users users);

}
