package com.huaian.portablecode.service;


import com.alibaba.fastjson.JSONObject;
import com.huaian.portablecode.entity.UserDetail;
import com.huaian.portablecode.entity.UserHealthInfo;
import com.huaian.portablecode.entity.UserRegister;

import java.util.List;

public interface UserService {

    JSONObject login(String code);

    void addUser(String name,String sfzhm);

    //用户注册信息表
    void getUserRegis(UserRegister userRegister);

    //用户信息表
    void getUserInfo(UserDetail userDetail);

    //用户健康信息表
    void user_health_info(UserHealthInfo userHealthInfo);

    List<String> query();

    String getUserPhone(String sessionKey, String encrypdata, String ivdata);

    String getZjhm(String zjhm);
}
