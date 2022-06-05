package com.bei.forum.controller;

import com.bei.forum.common.Res;
import com.bei.forum.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return Res.ok().data("list", postsService.getAll());
    }
}

