package com.bei.forum.service;

import com.bei.forum.pojo.Posts;

import java.util.List;

public interface PostsService {

    Posts get(int id);

    Posts[] getAll();

    Posts[] getByArea(String area);

    Posts[] onePosted(String author);

    List<Posts> mostComment();

}
