package com.huaian.portablecode.controller;

import com.alibaba.fastjson.JSONObject;
import com.huaian.portablecode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.huaian.portablecode.vo.ResultVo;
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public Object register(String name, String sfzhm) {
        JSONObject jsonObject = new JSONObject();
        userService.addUser(name,sfzhm);
        return ResultVo.getSuccess("注册成功");
    }
}
