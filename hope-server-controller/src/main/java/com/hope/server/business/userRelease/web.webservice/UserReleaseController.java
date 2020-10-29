package com.hope.server.business.userRelease.web.webservice;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codahale.metrics.annotation.Timed;
import com.hope.server.api.longUserRelease.domain.LongUserRelease;
import com.hope.server.business.userRelease.dto.UserReleaseDTO;
import com.hope.server.business.userRelease.service.UserReleaseService;
import com.server.service.base.Result;
import com.server.service.utils.Res;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author wangning
 */
@Slf4j
@RestController
@RequestMapping("/webservice")
public class UserReleaseController {


    @Autowired
    UserReleaseService userReleaseService;


    @Timed
    @GetMapping("/showSomeInfo")
    public Result showSomeInfo(String versionName) {
        if ("2.3.0".equals(versionName)) {
            return Res.ok(true);
        }
        return Res.ok(false);
    }


    /**
     * 查询用户发布的作品
     *
     * @param * @param userReleaseDTO
     * @return com.server.service.base.Result
     * @author wangning
     * @date 2020/9/2
     */
    @Timed
    @GetMapping("/release/queryUserRelease")
    public Result queryUserRelease(UserReleaseDTO userReleaseDTO, Page<LongUserRelease> page) {
        log.info("查询用户发布作品入参实体{},入参page对象pag.size={},page.current={}", userReleaseDTO, page.getSize(), page.getCurrent());
        return userReleaseService.queryUserRelease(userReleaseDTO, page);
    }

    /**
     * 用户发表作品
     *
     * @param * @param
     * @return com.server.service.base.Result
     * @author wangning
     * @date 2020/9/2
     */
    @Timed
    @PostMapping("/release/userRelease")
    public Result userRelease(@RequestBody LongUserRelease longUserRelease) {
        log.info("用户发布作品入参实体{}", longUserRelease);
        return userReleaseService.userRelease(longUserRelease);
    }

}