package com.bei.forum.mapper;

import com.bei.forum.pojo.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface NewsMapper {

    Map<String, Object>[] showComment(int postId);

    int send(News news);

    int count(int articleId, String type);

    int[] oneCollected(int id);

    Map<String, Object>[] received(int receiver);

    void read(int receiver); // 全部置为已读

    int noRead(int receiver);   // 返回未读消息数

    int[] mostComment();

    int[] recentComment();

    int getCommentAmount();
}
