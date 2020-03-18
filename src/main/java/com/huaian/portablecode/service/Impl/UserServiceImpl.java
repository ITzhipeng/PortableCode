package com.huaian.portablecode.service.Impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huaian.portablecode.entity.UserDetail;
import com.huaian.portablecode.entity.UserHealthInfo;
import com.huaian.portablecode.entity.UserRegister;
import com.huaian.portablecode.mapper.UserMapper;
import com.huaian.portablecode.service.UserService;
import com.huaian.portablecode.utils.HttpClientUtil;
import org.apache.shiro.codec.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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

    @Override
    public void getUserRegis(UserRegister userRegister) {
        userMapper.getUserRegis(userRegister);
    }

    @Override
    public void getUserInfo(UserDetail userDetail) {
        userMapper.getUserInfo(userDetail);
    }

    @Override
    public void user_health_info(UserHealthInfo userHealthInfo) {
        userMapper.user_health_info(userHealthInfo);
    }

    @Override
    public List<String> query() {
        return userMapper.query();
    }

    @Override
    public String getUserPhone(String sessionKey, String encrypdata, String ivdata) {
        byte[] encrypData = Base64.decode(encrypdata);
        byte[] ivData = Base64.decode(ivdata);
        byte[] key = Base64.decode(sessionKey);
        String str = "";
        try {
            str = decrypt(key, ivData, encrypData);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return str;

    }

    private String decrypt(byte[] sessionKey, byte[] ivData, byte[] encrypData) throws Exception {
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivData);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(sessionKey, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        //解析解密后的字符串  
        String decData =  new String(cipher.doFinal(encrypData), "UTF-8");
        logger.info("解密后数据：" + decData);
        return decData;
    }

}
