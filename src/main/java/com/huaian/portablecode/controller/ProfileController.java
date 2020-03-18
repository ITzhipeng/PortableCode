package com.huaian.portablecode.controller;

import com.huaian.portablecode.entity.UserDetail;
import com.huaian.portablecode.service.IProfileService;
import com.huaian.portablecode.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 我的  Controller类
 */

@RestController
@CrossOrigin
public class ProfileController {

    @Autowired
    IProfileService profileService;

    /**
     * 根据openId和证件号码查询个人信息
     * @param openId
     * @param cartNum
     */
    @PostMapping("queryProfileInfo")
    public ResultVo showProfileInfo(@RequestParam(defaultValue = "") String openId,
                                    @RequestParam(defaultValue = "") String cartNum){
        if(ObjectUtils.isEmpty(openId)){
            return ResultVo.getFailed("openId为空！");
        }else if(ObjectUtils.isEmpty(cartNum)){
            return ResultVo.getFailed("cartNum为空！");
        }else{
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
