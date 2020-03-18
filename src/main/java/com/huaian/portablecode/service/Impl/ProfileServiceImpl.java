package com.huaian.portablecode.service.Impl;

import com.huaian.portablecode.entity.UserDetail;
import com.huaian.portablecode.mapper.ProfileMapper;
import com.huaian.portablecode.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProfileServiceImpl implements IProfileService {

    @Autowired
    ProfileMapper  profileMapper;

    @Override
    public UserDetail getProfileInfo(String openId, String cartNum) {
        return profileMapper.getInfoByOpenIdAndCartNum(openId, cartNum);
    }

    @Override
    public int changeProfileInfo(UserDetail userDetail) {
        // 修改更新时间
        userDetail.setUpd_time(new Date());
        return profileMapper.update(userDetail);
    }
}
