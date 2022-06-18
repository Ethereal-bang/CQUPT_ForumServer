package com.bei.forum.service;

import com.bei.forum.mapper.*;
import com.bei.forum.pojo.DiscussArea;
import com.bei.forum.pojo.Notices;
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
    ArticlesMapper articlesMapper;
    NoticesMapper noticesMapper;

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

    @Autowired
    public void setArticlesMapper(ArticlesMapper articlesMapper) {
        this.articlesMapper = articlesMapper;
    }

    @Autowired
    public void setNoticesMapper(NoticesMapper noticesMapper) {
        this.noticesMapper = noticesMapper;
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

    @Override
    public boolean delArea(int id) {
        return discussAreaMapper.delArea(id) == 1;
    }

    @Override
    public boolean addNotice(Notices notice) {
        // 1.更新articles表(_id,type)
        if (articlesMapper.add("notices") == 1) {
            // 2.获得_id
            notice.setId(articlesMapper.lastId());
            // 2.更新notices表
            return noticesMapper.add(notice) == 1;
        }
        return false;
    }

}
