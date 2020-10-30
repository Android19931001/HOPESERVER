package com.hope.server.api.longVersionRelease.web.webservice;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hope.server.api.longVersionRelease.dto.LongVersionRelease;
import com.server.service.base.BaseNoResp;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hope.server.api.longVersionRelease.service.LongVersionReleaseService;
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
public class LongVersionReleaseResource {

    private Logger logger = LoggerFactory.getLogger(LongVersionReleaseResource.class);

    @Autowired
    LongVersionReleaseService longVersionReleaseService;


    /**
         * 分页查询
         *
         * @param longVersionRelease
         * @param page
         * @return
         */
        @Timed
        @GetMapping("/longVersionRelease/queryLongVersionReleaseList")
        public ResponseEntity<Page<LongVersionRelease>> queryLongVersionReleaseList(LongVersionRelease longVersionRelease, Page<LongVersionRelease> page) {
            logger.info("LongVersionRelease query queryLongVersionReleaseList() [ /longVersionRelease/queryList]\n = {} \npage = {current = {},size = {}}", longVersionRelease, page.getCurrent(), page.getSize());
            page = longVersionReleaseService.page(page, new QueryWrapper<>());
            return ResponseEntity.ok().body(page);
        }


        /**
         * 分页查询（模糊查询）
         *
         * @param longVersionRelease
         * @param page
         * @return
         */
        @Timed
        @GetMapping("/longVersionRelease/queryListByLike")
        public ResponseEntity<Page<LongVersionRelease>> queryListByLike(LongVersionRelease longVersionRelease, Page<LongVersionRelease> page) {
            logger.info("LongVersionRelease query queryLongVersionReleaseList() [ /longVersionRelease/queryList]\n = {} \npage = {current = {},size = {}}", longVersionRelease, page.getCurrent(), page.getSize());
            QueryWrapper<LongVersionRelease> queryWrapper = new QueryWrapper<>();
            //模糊查询
            //if (!StringUtils.isEmpty(longVersionRelease.getAppName())) {
            //    queryWrapper.like("查询字段", longVersionRelease.getAppName());
            //    longUpdateInfo.setAppName(null);
            //}
            //精准查询
            //if (StringUtils.isNotBlank(longVersionRelease.getAppName())) {
            //    queryWrapper.eq("查询字段", longVersionRelease.getAppName());
            //    longUpdateInfo.setVerName(null);
            //}
            page = longVersionReleaseService.page(page,queryWrapper);

            return ResponseEntity.ok().body(page);
        }

    /**
     * 根据id查询（查）
     *
     * @param id
     * @return
     */
    @Timed
    @GetMapping("/longVersionRelease/select/{id}")
    public ResponseEntity<LongVersionRelease> selectLongVersionReleaseById(@PathVariable String id) {
        logger.info("查询的Id === {}", id);
        LongVersionRelease longVersionRelease = longVersionReleaseService.getById(id);
        return ResponseEntity.ok().body(longVersionRelease);
    }

    /**
     * 删除操作（删）
     *
     * @param id
     * @return
     */
    @Timed
    @DeleteMapping("/longVersionRelease/remove/{id}")
    public BaseNoResp<Boolean> removeLongVersionReleaseById(@PathVariable String id) {
        logger.info("删除操作id === {}", id);
        return Res.noBody(longVersionReleaseService.removeById(id));
    }

    /**
     * 插入数据（增）（改）
     *
     * @param longVersionRelease
     * @return
     */
    @Timed
    @PostMapping("/longVersionRelease/saveOrUpdate")
    public ResponseEntity<LongVersionRelease> saveLongVersionRelease(@RequestBody LongVersionRelease longVersionRelease) {
        logger.info("添加操作 === {}", longVersionRelease);
        longVersionReleaseService.saveOrUpdate(longVersionRelease);
        return ResponseEntity.ok().body(longVersionRelease);
    }


}