package com.bei.forum.service;

import com.bei.forum.mapper.NewsMapper;
import com.bei.forum.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class NewsServiceImpl implements NewsService {

    NewsMapper newsMapper;

    @Autowired
    public void setNewsMapper(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
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
        return newsMapper.received(receiver);
    }

}
