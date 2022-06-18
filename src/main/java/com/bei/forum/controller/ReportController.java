package com.bei.forum.controller;

import com.bei.forum.common.Res;
import com.bei.forum.pojo.Report;
import com.bei.forum.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {

    ReportService reportService;

    @Autowired
    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/add")
    public Res addReport(@RequestParam String type,
                         @RequestParam int reporter,
                         @RequestParam String reported,
                         @RequestParam(defaultValue = "-1") int comment,
                         @RequestParam(defaultValue = "-1") int post,
                         @RequestParam String content) {
        Report report = new Report(reporter, reported, type, content);
        if (type.equals("post")) {
            report.setPost(post);
        } else {
            report.setComment(comment);
        }
        if (reportService.add(report)) {
            return Res.ok().setMsg("举报已发出，正在受理");
        } else {
            return Res.err().setMsg("举报发送失败，请重试");
        }
    }

    @GetMapping("/del")
    public Res delReport(@RequestParam int id) {
        if (reportService.del(id)) {
            return Res.ok().setMsg("删除成功");
        } else {
            return Res.err().setMsg("删除失败");
        }
    }
}
