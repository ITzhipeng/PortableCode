package com.huaian.portablecode.controller;

import com.alibaba.fastjson.JSONObject;
import com.huaian.portablecode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.huaian.portablecode.vo.ResultVo;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public Object register(@RequestParam(defaultValue = "") String name,
                           @RequestParam(defaultValue = "") String sfzhm) {
        if (name.equals("") || name == null) {
            return ResultVo.getFailed("姓名不可为空");
        } else if (sfzhm.equals("") || sfzhm == null) {
            return ResultVo.getFailed("身份证号码不可为空");
        } else {
            userService.addUser(name, sfzhm);
            return ResultVo.getSuccess("注册成功");
        }
    }
    @PostMapping("login")
    public Object wxLogin(@RequestParam(defaultValue = "") String js_code) throws Exception {
        if(!ObjectUtils.isEmpty(js_code)){
            JSONObject loginResult = userService.login(js_code);
            return ResultVo.getSuccess("数据返回成功", loginResult);
        }else {
            return ResultVo.getFailed("js_code不可为空");
        }
    }
    @PostMapping("query")
    public String query(){
        return userService.query();
    }
}
