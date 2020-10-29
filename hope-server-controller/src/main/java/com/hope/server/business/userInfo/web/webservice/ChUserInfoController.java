package com.hope.server.business.userInfo.web.webservice;


import com.codahale.metrics.annotation.Timed;
import com.hope.server.business.userInfo.service.UserInfoService;
import com.server.service.base.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hope.server.api.longUserInfo.domain.LongUserInfo;


/**
 * @author wangning
 */
@Slf4j
@RestController
@RequestMapping("/webservice")
public class ChUserInfoController {


    @Autowired
    UserInfoService userInfoService;

    /**
     * 用户登录
     *
     * @param * @param longUserInfo
     * @return com.server.service.base.Result
     * @author wangning
     * @date 2020/9/2
     */
    @Timed
    @PostMapping("/userInfo/userLogin")
    public Result userLogin(@RequestBody LongUserInfo longUserInfo) {
        log.info("用户登录入参实体----{}", longUserInfo);
        return userInfoService.userLogin(longUserInfo);
    }

}