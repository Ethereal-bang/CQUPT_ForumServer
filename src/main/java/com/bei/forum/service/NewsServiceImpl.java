package com.bei.forum.service;

import com.bei.forum.mapper.ArticlesMapper;
import com.bei.forum.mapper.NewsMapper;
import com.bei.forum.mapper.NoticesMapper;
import com.bei.forum.mapper.PostsMapper;
import com.bei.forum.pojo.News;
import com.bei.forum.pojo.Notices;
import com.bei.forum.pojo.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class NewsServiceImpl implements NewsService {

    NewsMapper newsMapper;
    ArticlesMapper articlesMapper;
    NoticesMapper noticesMapper;
    PostsMapper postsMapper;

    @Autowired
    public void setNewsMapper(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    @Autowired
    public void setArticlesMapper(ArticlesMapper articlesMapper) {
        this.articlesMapper = articlesMapper;
    }

    @Autowired
    public void setNoticesMapper(NoticesMapper noticesMapper) {
        this.noticesMapper = noticesMapper;
    }

    @Autowired
    public void setPostsMapper(PostsMapper postsMapper) {
        this.postsMapper = postsMapper;
    }

    @Override
    public Map<String, Object>[] showComment(int postId) {
        return newsMapper.showComment(postId);
    }

    @Override
    public boolean send(News news) {
        news.setCreateTime(new Date());
        return newsMapper.send(news) == 1;
    }

    @Override
    public int count(int articleId, String type) {
        return newsMapper.count(articleId, type);
    }

    @Override
    public Map<String, Object>[] received(int receiver) {
        Map<String, Object>[] news = newsMapper.received(receiver);
        for (Map<String, Object> m : news) {
            int id = (Integer) m.get("carrier_id");
            String type = articlesMapper.get(id);
            if (type.equals("notices")) {
                Notices notices = noticesMapper.get(id)[0];
                m.put("area", notices.getArea());
            } else {
                Posts posts = postsMapper.get(id)[0];
                m.put("area", posts.getArea());
            }
            // 请求到的消息都标记为已读
            newsMapper.read(receiver);
        }
        return news;
    }

    @Override
    public int noRead(int receiver) {
        return newsMapper.noRead(receiver);
    }

    @Override
    public Posts[] mostComment() {
        return new Posts[0];
    }

}
