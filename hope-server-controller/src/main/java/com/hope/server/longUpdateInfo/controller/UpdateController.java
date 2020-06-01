package com.hope.server.longUpdateInfo.controller;

import com.server.service.base.BaseRes;
import com.server.service.base.ErrorResp;
import com.hope.server.longUpdateInfo.client.UpdateClient;
import com.hope.server.longUpdateInfo.dto.UpdateInfo;
import com.server.service.contant.Contants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.server.service.utils.Result;


/**
 * @author wangning
 */
@RestController
@RequestMapping("/webservice")
public class UpdateController {

    private Logger logger = LoggerFactory.getLogger(UpdateController.class);

    @Autowired
    UpdateClient updateClient;

    /**
     * 测试接口
     *
     * @param userInfo
     * @return
     */
    @Timed(millis = Contants.TIME_PRIOD)
    @GetMapping("/showSomeInfo/{userInfo}")
    public BaseRes<String> showSomeInfo(@PathVariable String userInfo) {
        if (StringUtils.isEmpty(userInfo)) {
            return Result.ok("false");
        }
        if ("2.2.7".equals(userInfo)) {
            return Result.ok("true");
        } else {
            return Result.ok("false");
        }
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
