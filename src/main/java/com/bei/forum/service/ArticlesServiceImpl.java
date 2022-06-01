package com.bei.forum.service;

import com.bei.forum.mapper.ArticlesMapper;
import com.bei.forum.pojo.Articles;
import com.bei.forum.pojo.Notices;
import com.bei.forum.pojo.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticlesServiceImpl implements ArticlesService {

    ArticlesMapper articlesMapper;
    NoticesService noticesService;
    PostsService postsService;

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
}
