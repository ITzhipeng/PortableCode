package com.huaian.portablecode.service;

import com.huaian.portablecode.entity.UserDetail;

public interface IProfileService {
    UserDetail getProfileInfo(String openId, String cartNum);

    int changeProfileInfo(UserDetail userDetail);
}
