package com.bei.forum.service;

import com.bei.forum.pojo.DiscussArea;
import com.bei.forum.pojo.Notices;
import com.bei.forum.pojo.Report;
import com.bei.forum.pojo.Users;

import java.util.Map;

public interface RootService {

    Map<String, Object> data();

    boolean addArea(String name, String url, String words);

    DiscussArea[] showAreas();

    boolean setArea(DiscussArea discussArea);

    boolean delArea(int id);

    boolean addNotice(Notices notice);

    Users[] showUsers();

    Report[] showReports();

}
