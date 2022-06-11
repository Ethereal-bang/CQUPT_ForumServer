package com.bei.forum.service;

import com.bei.forum.mapper.NewsMapper;
import com.bei.forum.mapper.NoticesMapper;
import com.bei.forum.pojo.Articles;
import com.bei.forum.pojo.Notices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticesServiceImpl implements NoticesService {

    NoticesMapper noticesMapper;
    NewsMapper newsMapper;

    @Autowired
    public void setNoticesMapper(NoticesMapper noticesMapper) {
        this.noticesMapper = noticesMapper;
    }

    @Autowired
    public void setNewsMapper(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    @Override
    public Notices get(int id) {
        Notices notice = noticesMapper.get(id)[0];
        notice.setLike(newsMapper.count(id, "like"));
        notice.setCollection(newsMapper.count(id, "collect"));
        return notice;
    }

    @Override
    public Notices[] getAll() {
        return noticesMapper.getAll();
    }

    @Override
    public Notices[] getByArea(String area) {
        return noticesMapper.getByArea(area);
    }
}
