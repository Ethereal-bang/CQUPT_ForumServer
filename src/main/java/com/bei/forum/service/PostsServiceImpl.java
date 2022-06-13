package com.bei.forum.service;

import com.bei.forum.mapper.NewsMapper;
import com.bei.forum.mapper.PostsMapper;
import com.bei.forum.pojo.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostsServiceImpl implements PostsService {

    PostsMapper postsMapper;
    NewsMapper newsMapper;

    @Autowired
    public void setPostsMapper(PostsMapper postsMapper) {
        this.postsMapper = postsMapper;
    }

    @Autowired
    public void setNewsMapper(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    @Override
    public Posts get(int id) {
        Posts post = postsMapper.get(id)[0];
        post.setLike(newsMapper.count(id, "like"));
        post.setCollection(newsMapper.count(id, "collect"));
        post.setComment(newsMapper.count(id, "comment"));
        return post;
    }

    @Override
    public Posts[] getAll() {
        return postsMapper.getAll();
    }

    @Override
    public Posts[] getByArea(String area) {
        return postsMapper.getByArea(area);
    }

    @Override
    public Posts[] onePosted(String author) {
        Posts[] posts = postsMapper.onePosted(author);
        for (Posts p : posts) {
            p.setLike(newsMapper.count(p.getId(), "like"));
            p.setCollection(newsMapper.count(p.getId(), "collect"));
            p.setComment(newsMapper.count(p.getId(), "comment"));
        }
        return posts;
    }

    @Override
    public List<Posts> mostComment() {
        int [] ids = newsMapper.mostComment();
        List<Posts> posts = new ArrayList<>();
        for (int id : ids) {
            posts.add(postsMapper.get(id)[0]);
        }
        return posts;
    }
}
