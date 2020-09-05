package com.leyou.service;

import com.leyou.entity.User;
import com.leyou.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {
        if(id == 6){
            throw new RuntimeException();
        }
//        try {
//            Thread.sleep(1000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return this.userMapper.selectByPrimaryKey(id);
    }
}