package com.huaian.portablecode.service.Impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaian.portablecode.mapper.UserMapper;
import com.huaian.portablecode.service.UserService;
import com.huaian.portablecode.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Value("${app.url}")
    private String appUrl;

    @Value("${app.app-id}")
    private String appId;

    @Value("${app.secret-key}")
    private String secretKey;


    @Override
    public JSONObject login(String code) {
        Map<String, String> requestUrlParam = new HashMap<>();

        requestUrlParam.put("appid", appId); //小程序appId
        requestUrlParam.put("secret", secretKey); //小程序secret
        requestUrlParam.put("js_code", code); //小程序端返回的code
        //默认参数
        requestUrlParam.put("grant_type", "authorization_code");
        //发送post请求读取调用微信接口获取openid用户唯一标识
        JSONObject jsonObject = JSON.parseObject(HttpClientUtil.doGet(appUrl, requestUrlParam));
        return jsonObject;
    }

    @Override
    public void addUser(String name, String sfzhm) {
        userMapper.addUser(name, sfzhm);
    }

}
