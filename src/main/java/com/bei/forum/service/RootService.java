package com.bei.forum.service;

import org.springframework.stereotype.Service;

import java.util.Map;

public interface RootService {

    Map<String, Object> data();

    boolean addArea(String name, String url, String words);

}
