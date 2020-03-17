package com.huaian.portablecode.service;


import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface UserService {

    JSONObject login(String code);

    void addUser(String name,String sfzhm);

    List<String> query();

}
