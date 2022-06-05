package com.bei.forum.service;

import com.bei.forum.mapper.NoticesMapper;
import com.bei.forum.pojo.Notices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticesServiceImpl implements NoticesService {

    NoticesMapper noticesMapper;

    @Autowired
    public void setNoticesMapper(NoticesMapper noticesMapper) {
        this.noticesMapper = noticesMapper;
    }

    @Override
    public Notices get(int id) {
        return noticesMapper.get(id)[0];
    }

    @Override
    public Notices[] getAll() {
        return noticesMapper.getAll();
    }

    @Override
    public Notices[] getByArea(String area) {
        return noticesMapper.getByArea(area);
    }
}
