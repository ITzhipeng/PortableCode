package com.huaian.portablecode.controller;

import com.alibaba.fastjson.JSONObject;
import com.huaian.portablecode.service.UserService;
import com.huaian.portablecode.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import com.huaian.portablecode.vo.ResultVo;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Resource
    private RedisUtil redisUtil;

    @PostMapping("register")
    public Object register(@RequestBody JSONObject object) {

        if (object.get("name").equals("") || object.get("name") == null) {
            return ResultVo.getFailed("姓名不可为空");
        } else if (object.get("sfzhm").equals("") || object.get("sfzhm") == null) {
            return ResultVo.getFailed("身份证号码不可为空");
        } else {
            userService.addUser(object.get("name").toString(), object.get("sfzhm").toString());
            return ResultVo.getSuccess("注册成功");
        }
    }
    @PostMapping("login")
    public Object wxLogin(@RequestParam(defaultValue = "") String js_code) throws Exception {
        if(!ObjectUtils.isEmpty(js_code)){
            JSONObject jsonArray = userService.login(js_code);
            JSONObject loginResult = new JSONObject();

            redisUtil.set("openid",jsonArray.get(3),1);

            return ResultVo.getSuccess("数据返回成功", loginResult);
        }else {
            return ResultVo.getFailed("js_code不可为空");
        }

    }
    @PostMapping("query")
    public List<String> query(){
        return userService.query();
    }
}
