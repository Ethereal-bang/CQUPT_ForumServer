package com.bei.forum.controller;

import com.bei.forum.common.Res;
import com.bei.forum.pojo.News;
import com.bei.forum.service.NewsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/news")
public class NewsController {

    NewsService newsService;

    @Autowired
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping("/{postId}/showComment")
    public Res showComment(@PathVariable int postId) {
        return Res.ok().data("list", newsService.showComment(postId));
    }

    @PostMapping("/send")
    public Res send(@RequestBody News news) {
        if (newsService.send(news)) {
            return Res.ok().setMsg("操作成功");
        } else {
            return Res.err().setMsg("操作失败");
        }
    }
}
