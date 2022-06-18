package com.bei.forum.controller;

import com.bei.forum.common.Res;
import com.bei.forum.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/root")
public class RooterController {

    RootService rootService;

    @Autowired
    public void setRootService(RootService rootService) {
        this.rootService = rootService;
    }

    @GetMapping("/data")
    public Res data() {
        return Res.ok().data("data", rootService.data());
    }

    @GetMapping("/addArea") // 创建区块
    public Res addArea(@RequestParam String name, @RequestParam String url, @RequestParam String words) {
        if (rootService.addArea(name, url, words)) {
            return Res.ok().setMsg("区块创建成功");
        } else {
            return Res.err().setMsg("区块创建失败");
        }
    }

    @GetMapping("/area")
    public Res showArea() {
        return Res.ok().data("list", rootService.showAreas());
    }
}
