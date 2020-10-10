package com.server.service.longUserInfo.resource;


import com.server.service.base.BaseNoResp;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.server.service.longUserInfo.domain.LongUserInfo;
import com.server.service.longUserInfo.service.LongUserInfoService;
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
public class LongUserInfoResource {

    private Logger logger = LoggerFactory.getLogger(LongUserInfoResource.class);

    @Autowired
    LongUserInfoService longUserInfoService;


    /**
     * 分页查询
     *
     * @param longUserInfo
     * @param page
     * @return
     */
    @Timed
    @GetMapping("/longUserInfo/queryLongUserInfoList")
    public ResponseEntity<Page<LongUserInfo>> queryLongUserInfoList(LongUserInfo longUserInfo, Page<LongUserInfo> page) {
        logger.info("LongUserInfo query queryLongUserInfoList() [ /longUserInfo/queryList]\n = {} \npage = {current = {},size = {}}", longUserInfo, page.getCurrent(), page.getSize());
        page = (Page<LongUserInfo>) longUserInfoService.page(page, new QueryWrapper<>());
        return ResponseEntity.ok().body(page);
    }


    /**
     * 分页查询（模糊查询）
     *
     * @param longUserInfo
     * @param page
     * @return
     */
    @Timed
    @GetMapping("/longUserInfo/queryListByLike")
    public ResponseEntity<Page<LongUserInfo>> queryListByLike(LongUserInfo longUserInfo, Page<LongUserInfo> page) {
        logger.info("LongUserInfo query queryLongUserInfoList() [ /longUserInfo/queryList]\n = {} \npage = {current = {},size = {}}", longUserInfo, page.getCurrent(), page.getSize());
        QueryWrapper<LongUserInfo> queryWrapper = new QueryWrapper<>();
        //模糊查询
        //if (!StringUtils.isEmpty(longUserInfo.getAppName())) {
        //    queryWrapper.like("查询字段", longUserInfo.getAppName());
        //    longUpdateInfo.setAppName(null);
        //}
        //精准查询
        //if (StringUtils.isNotBlank(longUserInfo.getAppName())) {
        //    queryWrapper.eq("查询字段", longUserInfo.getAppName());
        //    longUpdateInfo.setVerName(null);
        //}
        page = (Page<LongUserInfo>) longUserInfoService.page(page, queryWrapper);

        return ResponseEntity.ok().body(page);
    }

    /**
     * 根据id查询（查）
     *
     * @param id
     * @return
     */
    @Timed
    @GetMapping("/longUserInfo/select/{id}")
    public ResponseEntity<LongUserInfo> selectLongUserInfoById(@PathVariable String id) {
        logger.info("查询的Id === {}", id);
        LongUserInfo longUserInfo = longUserInfoService.getById(id);
        return ResponseEntity.ok().body(longUserInfo);
    }

    /**
     * 删除操作（删）
     *
     * @param id
     * @return
     */
    @Timed
    @DeleteMapping("/longUserInfo/remove/{id}")
    public BaseNoResp<Boolean> removeLongUserInfoById(@PathVariable String id) {
        logger.info("删除操作id === {}", id);
        return Res.noBody(longUserInfoService.removeById(id));
    }

    /**
     * 插入数据（增）（改）
     *
     * @param longUserInfo
     * @return
     */
    @Timed
    @PostMapping("/longUserInfo/saveOrUpdate")
    public ResponseEntity<LongUserInfo> saveLongUserInfo(@RequestBody LongUserInfo longUserInfo) {
        logger.info("添加操作 === {}", longUserInfo);
        longUserInfoService.saveOrUpdate(longUserInfo);
        return ResponseEntity.ok().body(longUserInfo);
    }


}