package com.bei.forum.service;

import com.bei.forum.mapper.NewsMapper;
import com.bei.forum.mapper.PostsMapper;
import com.bei.forum.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RootServiceImpl implements RootService {

    UsersMapper usersMapper;
    NewsMapper newsMapper;
    PostsMapper postsMapper;

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
}
