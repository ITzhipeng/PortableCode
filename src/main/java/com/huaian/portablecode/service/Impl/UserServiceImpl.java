package com.huaian.portablecode.service.Impl;


import com.huaian.portablecode.mapper.UserMapper;
import com.huaian.portablecode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public void addUser(String name, String sfzhm) {
        userMapper.addUser(name, sfzhm);
    }

}
