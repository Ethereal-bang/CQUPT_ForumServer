package com.bei.forum.controller;

import com.bei.forum.common.Res;
import com.bei.forum.pojo.Articles;
import com.bei.forum.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticlesController {

    ArticlesService articlesService;

    @Autowired
    public void setArticlesService(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }

    @RequestMapping("/{id}")
    public Res getArticle(@PathVariable int id) {
        Articles articles = articlesService.getArticle(id);
        return Res.ok().data("articles", articles);
    }
}
