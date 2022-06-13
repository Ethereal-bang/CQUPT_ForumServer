package com.bei.forum.service;

import com.bei.forum.pojo.News;
import com.bei.forum.pojo.Posts;

import java.util.Map;

public interface NewsService {

    Map<String, Object>[] showComment(int postId);

    boolean send(News news);

    int count(int articleId, String type);

    Map<String, Object>[] received(int receiver);

    int noRead(int receiver);

    Posts[] mostComment();

}
