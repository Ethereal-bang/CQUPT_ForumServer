package com.bei.forum.service;

import com.bei.forum.mapper.PostsMapper;
import com.bei.forum.pojo.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsServiceImpl implements PostsService {

    PostsMapper postsMapper;

    @Autowired
    public void setPostsMapper(PostsMapper postsMapper) {
        this.postsMapper = postsMapper;
    }

    @Override
    public Posts get(int id) {
        return postsMapper.get(id)[0];
    }
}
