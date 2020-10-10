package com.hope.server.business.userInfo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hope.server.api.longUserInfo.domain.LongUserInfo;
import com.hope.server.api.longUserInfo.service.LongUserInfoService;
import com.hope.server.business.userInfo.mapper.UserInfoMapper;
import com.hope.server.business.userInfo.service.UserInfoService;
import com.server.service.base.Result;
import com.server.service.utils.Res;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangning
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    LongUserInfoService longUserInfoService;

    private UserInfoMapper chUserInfoMapper;

    public UserInfoServiceImpl(UserInfoMapper chUserInfoMapper) {
        this.chUserInfoMapper = chUserInfoMapper;
    }

    /**
     * 用户登录
     *
     * @param * @param longUserInfo
     * @return com.server.service.base.Result
     * @author wangning
     * @date 2020/9/2
     */
    @Override
    public Result userLogin(LongUserInfo longUserInfo) {
        if (StringUtils.isEmpty(longUserInfo.getPhoneNumber())) {
            return Res.error("账号为空！");
        }
        if (StringUtils.isEmpty(longUserInfo.getUserPwd())) {
            return Res.error("密码为空！");
        }
        LongUserInfo result = null;
        try {
            QueryWrapper userWrapper = new QueryWrapper();
            userWrapper.eq("phone_number", longUserInfo.getPhoneNumber());
            userWrapper.last(" limit 1");
            result = longUserInfoService.getOne(userWrapper);
            if (null == result) {
                return Res.error("用户不存在");
            } else if (!result.getUserPwd().equals(longUserInfo.getUserPwd())) {
                return Res.error("密码不正确");
            }
        } catch (Exception e) {
            log.info("保存用户信息异常", e);
            return Res.error("保存用户信息异常");
        }
        result.setUserPwd("");
        return Res.ok(result);
    }
}
