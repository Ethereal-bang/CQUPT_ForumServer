package com.bei.forum.service;

import com.bei.forum.pojo.Users;

public interface UsersService {

    boolean isExists(String email);

    boolean addByEmail(String email);

    boolean update(Users users);

    int selectId(String email);

    Users selectById(int id);
}
