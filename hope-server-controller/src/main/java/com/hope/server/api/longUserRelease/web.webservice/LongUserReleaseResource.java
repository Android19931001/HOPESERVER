package com.hope.server.api.longUserRelease.web.webservice;


import com.server.service.base.BaseNoResp;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hope.server.api.longUserRelease.domain.LongUserRelease;
import com.hope.server.api.longUserRelease.service.LongUserReleaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.codahale.metrics.annotation.Timed;
import org.springframework.web.bind.annotation.*;
import com.server.service.utils.Res;


/**
 * @author wangning
 */
@RestController
@RequestMapping("/api")
public class LongUserReleaseResource {

    private Logger logger = LoggerFactory.getLogger(LongUserReleaseResource.class);

    @Autowired
    LongUserReleaseService longUserReleaseService;


    /**
         * 分页查询
         *
         * @param longUserRelease
         * @param page
         * @return
         */
        @Timed
        @GetMapping("/longUserRelease/queryLongUserReleaseList")
        public ResponseEntity<Page<LongUserRelease>> queryLongUserReleaseList(LongUserRelease longUserRelease, Page<LongUserRelease> page) {
            logger.info("UserReleaseDTO query queryLongUserReleaseList() [ /userRelease/queryList]\n = {} \npage = {current = {},size = {}}", longUserRelease, page.getCurrent(), page.getSize());
            page = longUserReleaseService.page(page, new QueryWrapper<>());
            return ResponseEntity.ok().body(page);
        }


        /**
         * 分页查询（模糊查询）
         *
         * @param longUserRelease
         * @param page
         * @return
         */
        @Timed
        @GetMapping("/longUserRelease/queryListByLike")
        public ResponseEntity<Page<LongUserRelease>> queryListByLike(LongUserRelease longUserRelease, Page<LongUserRelease> page) {
            logger.info("UserReleaseDTO query queryLongUserReleaseList() [ /userRelease/queryList]\n = {} \npage = {current = {},size = {}}", longUserRelease, page.getCurrent(), page.getSize());
            QueryWrapper<LongUserRelease> queryWrapper = new QueryWrapper<>();
            //模糊查询
            //if (!StringUtils.isEmpty(userRelease.getAppName())) {
            //    queryWrapper.like("查询字段", userRelease.getAppName());
            //    longUpdateInfo.setAppName(null);
            //}
            //精准查询
            //if (StringUtils.isNotBlank(userRelease.getAppName())) {
            //    queryWrapper.eq("查询字段", userRelease.getAppName());
            //    longUpdateInfo.setVerName(null);
            //}
            page = longUserReleaseService.page(page,queryWrapper);

            return ResponseEntity.ok().body(page);
        }

    /**
     * 根据id查询（查）
     *
     * @param id
     * @return
     */
    @Timed
    @GetMapping("/longUserRelease/select/{id}")
    public ResponseEntity<LongUserRelease> selectLongUserReleaseById(@PathVariable String id) {
        logger.info("查询的Id === {}", id);
        LongUserRelease longUserRelease = longUserReleaseService.getById(id);
        return ResponseEntity.ok().body(longUserRelease);
    }

    /**
     * 删除操作（删）
     *
     * @param id
     * @return
     */
    @Timed
    @DeleteMapping("/longUserRelease/remove/{id}")
    public BaseNoResp<Boolean> removeLongUserReleaseById(@PathVariable String id) {
        logger.info("删除操作id === {}", id);
        return Res.noBody(longUserReleaseService.removeById(id));
    }

    /**
     * 插入数据（增）（改）
     *
     * @param longUserRelease
     * @return
     */
    @Timed
    @PostMapping("/longUserRelease/saveOrUpdate")
    public ResponseEntity<LongUserRelease> saveLongUserRelease(@RequestBody LongUserRelease longUserRelease) {
        logger.info("添加操作 === {}", longUserRelease);
        longUserReleaseService.saveOrUpdate(longUserRelease);
        return ResponseEntity.ok().body(longUserRelease);
    }


}