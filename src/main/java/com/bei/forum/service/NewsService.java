package com.bei.forum.service;

import com.bei.forum.pojo.News;

import java.util.Map;

public interface NewsService {

    Map<String, Object>[] showComment(int postId);

    boolean send(News news);

    int count(int articleId, String type);
}
