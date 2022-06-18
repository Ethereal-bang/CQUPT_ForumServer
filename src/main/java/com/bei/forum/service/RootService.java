package com.bei.forum.service;

import com.bei.forum.pojo.DiscussArea;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface RootService {

    Map<String, Object> data();

    boolean addArea(String name, String url, String words);

    DiscussArea[] showAreas();

    boolean setArea(DiscussArea discussArea);

}
