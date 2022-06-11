package com.bei.forum.service;

import com.bei.forum.pojo.Articles;

import java.util.List;

public interface ArticlesService {

    Articles getArticle(int id);

    List<Articles> oneCollect(int id);
}
