package com.bei.forum.service;

import com.bei.forum.mapper.ArticlesMapper;
import com.bei.forum.mapper.NewsMapper;
import com.bei.forum.pojo.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticlesServiceImpl implements ArticlesService {

    ArticlesMapper articlesMapper;
    NoticesService noticesService;
    PostsService postsService;
    NewsMapper newsMapper;

    @Autowired
    public void setArticlesMapper(ArticlesMapper articlesMapper) {
        this.articlesMapper = articlesMapper;
    }

    @Autowired
    public void setNoticesService(NoticesService noticesService) {
        this.noticesService = noticesService;
    }

    @Autowired
    public void setPostsService(PostsService postsService) {
        this.postsService = postsService;
    }

    @Autowired
    public void setNewsMapper(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    @Override
    public Articles getArticle(int id) {
        // 1.获得id对应的类型
        String type = articlesMapper.get(id);
        // 2.由该类型去对应表查询
        Articles articles = new Articles();
        if (type.equals("notices")) {
            articles = noticesService.get(id);
        } else if (type.equals("posts")) {
            articles = postsService.get(id);
        }
        articles.setId(id);
        articles.setType(type);
        return articles;
    }

    @Override
    public List<Articles> oneCollect(int id) {
        // 1.获得收藏文章id列表
        int[] collected = newsMapper.oneCollected(id);
        // 2.返回对应文章
        List<Articles> articles = new ArrayList<>();
        for (int articleId : collected) {
            String type = articlesMapper.get(articleId);
            if (type.equals("notices")) {
                articles.add(noticesService.get(articleId));
            } else {
                articles.add(postsService.get(articleId));
            }
        }
        return articles;
    }
}
