package com.bei.forum.service;

import com.bei.forum.mapper.AvatarMapper;
import com.bei.forum.pojo.Avatar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvatarServiceImpl implements AvatarService {

    AvatarMapper avatarMapper;

    @Autowired
    public void setAvatarMapper(AvatarMapper avatarMapper) {
        this.avatarMapper = avatarMapper;
    }

    @Override
    public Avatar[] showAll() {
        return avatarMapper.showAll();
    }

    @Override
    public String get(int order) {
        return avatarMapper.get(order);
    }

}
