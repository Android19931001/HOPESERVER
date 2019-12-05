package com.hope.controller.longUpdateInfo.controller;

import base.BaseRes;
import base.ErrorResp;
import com.hope.controller.longUpdateInfo.client.UpdateClient;
import com.hope.controller.longUpdateInfo.dto.UpdateInfo;
import contant.Contants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.Result;


/**
 * @author wangning
 */
@RestController
@RequestMapping("/webservice")
public class UpdateController {

    private Logger logger = LoggerFactory.getLogger(UpdateController.class);

    @Autowired
    UpdateClient updateClient;

    @Timed(millis = Contants.TIME_PRIOD)
    @GetMapping("/queryUpdateInfo/{userInfo}")
    public BaseRes<UpdateInfo> showSomeInfo(@PathVariable String userInfo) {
        return Result.ok(userInfo);
    }

    @Timed(millis = Contants.TIME_PRIOD)
    @GetMapping("/queryUpdateInfo/{id}")
    public BaseRes<UpdateInfo> queryUpdateInfoById(@PathVariable String id) {
        logger.info("查询app版本信息id===" + id);
        if (StringUtils.isEmpty(id)) {
            return Result.error(new ErrorResp("查询id不能为空!"));
        }
        UpdateInfo updateInfo = updateClient.queryUpdateInfoById(id).getBody();
        if (null == updateInfo) {
            return Result.error(new ErrorResp("查询app版本更新信息失败"));
        }
        return Result.ok(updateInfo);
    }
}
