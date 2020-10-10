package com.hope.server.business.userInfo.service;

import com.hope.server.api.longUserInfo.domain.LongUserInfo;
import com.hope.server.business.userInfo.dto.UserInfoDTO;
import com.server.service.base.BaseService;
import com.server.service.base.Result;

/**
 * @author wangning
 */
public interface UserInfoService {
    Result userLogin(LongUserInfo longUserInfo);
}
