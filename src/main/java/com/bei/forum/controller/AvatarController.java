package com.bei.forum.controller;

import com.bei.forum.common.Res;
import com.bei.forum.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avatar")
public class AvatarController {

    AvatarService avatarService;

    @Autowired
    public void setAvatarService(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @RequestMapping("/showAll")
    public Res showAll() {
        return Res.ok().data("list", avatarService.showAll());
    }

    @RequestMapping("/{order}")
    public Res getOne(@PathVariable int order) {
        return Res.ok().data("link", avatarService.get(order));
    }

}
