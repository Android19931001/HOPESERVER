package com.hope.server.business.versionRelease.web.webservice;


import com.codahale.metrics.annotation.Timed;
import com.hope.server.api.longVersionRelease.dto.LongVersionRelease;
import com.hope.server.business.versionRelease.HopeServiceClient;
import com.hope.server.business.versionRelease.dto.LongUserInfo;
import com.hope.server.business.versionRelease.service.VersionReleaseService;
import com.server.service.base.Result;
import com.server.service.utils.Res;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;


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
     * 格式化成sql
     *
     * @param str
     * @return
     */
    @Timed
    @GetMapping("/formatToSql/{str}")
    public String formatToSql(@PathVariable("str") String str) {
        log.info("格式化成sql入参---------------->{}", str);
        return versionReleaseService.formatToSql(str);
    }


    /**
     * 查询APP更新信息
     *
     * @param * @param versionRelease
     * @return com.hope.server.business.versionRelease.dto.VersionReleaseDTO
     * @author wangning
     * @date 2020/11/18
     */
    @Timed
    @PostMapping("/queryUpdateInfo")
    public Result queryUpdateInfo(@RequestBody LongVersionRelease versionRelease) {
        log.info("查看app更新信息入参---------------->{}", versionRelease);
        return versionReleaseService.queryUpdateInfo(versionRelease);
    }

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