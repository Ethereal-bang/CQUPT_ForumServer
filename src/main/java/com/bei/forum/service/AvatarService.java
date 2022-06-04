package com.bei.forum.service;

import com.bei.forum.pojo.Avatar;

import java.util.List;

public interface AvatarService {

    Avatar[] showAll();

    String get(int order);

}
