package com.bei.forum.service;

import com.bei.forum.mapper.ReportMapper;
import com.bei.forum.pojo.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ReportServiceImpl implements ReportService {

    ReportMapper reportMapper;

    @Autowired
    public void setReportMapper(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }

    @Override
    public boolean add(Report report) {
        if (Objects.equals(report.getType(), "post")) {
            return reportMapper.addToPost(report) == 1;
        } else if (Objects.equals(report.getType(), "comment")) {
            return reportMapper.addToComment(report) == 1;
        }
        return false;
    }

    @Override
    public boolean del(int id) {
        return reportMapper.del(id) == 1;
    }
}
