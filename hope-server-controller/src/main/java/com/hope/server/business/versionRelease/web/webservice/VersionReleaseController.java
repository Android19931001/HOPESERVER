package com.hope.server.business.versionRelease.web.webservice;


import com.codahale.metrics.annotation.Timed;
import com.hope.server.business.versionRelease.service.VersionReleaseService;
import com.server.service.base.Result;
import com.server.service.utils.Res;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author wangning
 */
@Slf4j
@RestController
@RequestMapping("/webservice")
public class VersionReleaseController {

    @Autowired
    VersionReleaseService versionReleaseService;

    /**
     * ios是否显示人脸识别按钮
     *
     * @param * @param versionName
     * @return com.server.service.base.Result
     * @author wangning
     * @date 2020/10/30
     */
    @Timed
    @GetMapping("/showSomeInfo")
    public Result showSomeInfo(String versionName) {
        log.info("===========>传入的版本名称为{}", versionName);
        if (StringUtils.isEmpty(versionName)) {
            return Res.error("版本名称为空!");
        }
        return Res.ok(versionReleaseService.isShowFaceCredit(versionName));
    }


}