package com.bei.forum.mapper;

import com.bei.forum.pojo.Report;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportMapper {

    Report[] showAll();

    int addToPost(Report report);

    int addToComment(Report report);

    int del(int id);

}
