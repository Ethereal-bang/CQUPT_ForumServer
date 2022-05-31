package com.bei.forum.service;

public interface UsersService {

    boolean isExists(String email);

    boolean addByEmail(String email);
}
