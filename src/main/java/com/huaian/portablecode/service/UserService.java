package com.huaian.portablecode.service;


import com.alibaba.fastjson.JSONObject;

public interface UserService {

    JSONObject login(String code);

    void addUser(String name,String sfzhm);

    String query();

}
