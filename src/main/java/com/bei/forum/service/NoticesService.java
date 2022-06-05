package com.bei.forum.service;

import com.bei.forum.pojo.Notices;

public interface NoticesService {

    Notices get(int id);

    Notices[] getAll();

}
