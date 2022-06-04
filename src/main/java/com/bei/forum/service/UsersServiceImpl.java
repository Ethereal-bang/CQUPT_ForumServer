package com.bei.forum.service;

import com.bei.forum.mapper.UsersMapper;
import com.bei.forum.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    UsersMapper usersMapper;

    @Autowired
    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public boolean isExists(String email) {
        return usersMapper.getCount(email) == 1;
    }

    @Override
    public boolean addByEmail(String email) {
        Users users = new Users();
        users.setEmail(email);
        users.setName(email);
        return usersMapper.add(users);
    }

    @Override
    public boolean update(Users users) {
        return usersMapper.update(users);
    }

    @Override
    public int selectId(String email) {
        return usersMapper.selectId(email);
    }

    @Override
    public Users selectById(int id) {
        return usersMapper.select(id)[0];
    }

}
