package com.bei.forum.service;

import com.bei.forum.mapper.DiscussAreaMapper;
import com.bei.forum.mapper.NewsMapper;
import com.bei.forum.mapper.PostsMapper;
import com.bei.forum.mapper.UsersMapper;
import com.bei.forum.pojo.DiscussArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RootServiceImpl implements RootService {

    UsersMapper usersMapper;
    NewsMapper newsMapper;
    PostsMapper postsMapper;
    DiscussAreaMapper discussAreaMapper;

    @Autowired
    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Autowired
    public void setNewsMapper(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    @Autowired
    public void setPostsMapper(PostsMapper postsMapper) {
        this.postsMapper = postsMapper;
    }

    @Autowired
    public void setDiscussAreaMapper(DiscussAreaMapper discussAreaMapper) {
        this.discussAreaMapper = discussAreaMapper;
    }

    @Override
    public Map<String, Object> data() {
        Map<String, Object> ret = new HashMap<>();
        // 1.用户数量
        ret.put("allUsers", usersMapper.getAmount());
        // 2.评论数
        ret.put("comment", newsMapper.getCommentAmount());
        // 3.新增帖子数
        ret.put("newPosts", postsMapper.newPostAmount());
        return ret;
    }

    @Override
    public boolean addArea(String name, String url, String words) {
        return discussAreaMapper.addArea(new DiscussArea(name, url, words)) == 1;
    }

    @Override
    public DiscussArea[] showAreas() {
        return discussAreaMapper.showAreas();
    }

    @Override
    public boolean setArea(DiscussArea discussArea) {
        return discussAreaMapper.setArea(discussArea) == 1;
    }

}
