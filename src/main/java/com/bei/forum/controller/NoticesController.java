package com.bei.forum.controller;

import com.bei.forum.common.Res;
import com.bei.forum.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article/notice")
public class NoticesController {

    NoticesService noticesService;

    @Autowired
    public void setNoticesService(NoticesService noticesService) {
        this.noticesService = noticesService;
    }

    @RequestMapping("/showAll")
    public Res showAll() {
        return Res.ok()
                .data("notice", noticesService.getByArea("notice"))
                .data("game", noticesService.getByArea("game"));
    }
}
