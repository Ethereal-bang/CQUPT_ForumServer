package com.bei.forum.controller;

import com.bei.forum.common.Res;
import com.bei.forum.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article/post")
public class PostsController {

    PostsService postsService;

    @Autowired
    public void setPostsService(PostsService postsService) {
        this.postsService = postsService;
    }

    @RequestMapping("/showAll")
    public Res showAll() {
        return Res.ok()
                .data("share", postsService.getByArea("share"))
                .data("tech", postsService.getByArea("tech"))
                .data("study", postsService.getByArea("study"))
                .data("work", postsService.getByArea("work"));
    }

    @GetMapping("/onePosted")
    public Res onePost(@RequestParam String author) {
        return Res.ok().data("list", postsService.onePosted(author));
    }

    @GetMapping("/mostComment")
    public Res mostComment() {
        return Res.ok().data("list", postsService.mostComment());
    }

    @GetMapping("/recentComment")
    public Res recentComment() {
        return Res.ok().data("list", postsService.recentComment());
    }
}

