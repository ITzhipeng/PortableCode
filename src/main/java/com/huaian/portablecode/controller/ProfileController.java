package com.huaian.portablecode.controller;

import com.alibaba.fastjson.JSONObject;
import com.huaian.portablecode.entity.UserDetail;
import com.huaian.portablecode.service.IProfileService;
import com.huaian.portablecode.utils.RedisUtil;
import com.huaian.portablecode.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 我的  Controller类
 */

@RestController
@CrossOrigin
public class ProfileController {

    @Autowired
    IProfileService profileService;
    @Resource
    private RedisUtil redisUtil;

    /**
     * 根据ticket和证件号码查询个人信息
     * @param ticket
     * @param cartNum
     */
    @PostMapping("queryProfileInfo")
    public ResultVo showProfileInfo(@RequestParam(defaultValue = "") String ticket,
                                    @RequestParam(defaultValue = "") String cartNum){
        if(ObjectUtils.isEmpty(ticket)){
            return ResultVo.getFailed("ticket为空！");
        }else if(ObjectUtils.isEmpty(cartNum)){
            return ResultVo.getFailed("cartNum为空！");
        }else{
            JSONObject json = (JSONObject) redisUtil.get(ticket);
            if(ObjectUtils.isEmpty(json)){
                return ResultVo.getFailed("获取用户openid失败，请检查联系后端 ");
            }
            String openId = (String) json.get("openid");
            UserDetail profileInfo = profileService.getProfileInfo(openId, cartNum);
            return ResultVo.getSuccess("个人信息返回成功",profileInfo);
        }
    }

    @PostMapping("changeProfileInfo")
    public ResultVo changeProfileInfo(@RequestBody UserDetail userDetail){
        if(ObjectUtils.isEmpty(userDetail)){
            return ResultVo.getFailed("提交用户信息为空");
        }else{
            profileService.changeProfileInfo(userDetail);
            return ResultVo.getSuccess("修改成功！");
        }
    }
}
