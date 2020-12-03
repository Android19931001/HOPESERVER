package com.hope.server.api.longArtComment.web.webservice;


import com.server.service.base.BaseNoResp;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hope.server.api.longArtComment.dto.LongArtComment;
import com.hope.server.api.longArtComment.service.LongArtCommentService;
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
public class LongArtCommentResource {

    private Logger logger = LoggerFactory.getLogger(LongArtCommentResource.class);

    @Autowired
    LongArtCommentService longArtCommentService;


    /**
         * 分页查询
         *
         * @param longArtComment
         * @param page
         * @return
         */
        @Timed
        @GetMapping("/longArtComment/queryLongArtCommentList")
        public ResponseEntity<Page<LongArtComment>> queryLongArtCommentList(LongArtComment longArtComment, Page<LongArtComment> page) {
            logger.info("LongArtComment query queryLongArtCommentList() [ /longArtComment/queryList]\n = {} \npage = {current = {},size = {}}", longArtComment, page.getCurrent(), page.getSize());
            page = longArtCommentService.page(page, new QueryWrapper<>());
            return ResponseEntity.ok().body(page);
        }


        /**
         * 分页查询（模糊查询）
         *
         * @param longArtComment
         * @param page
         * @return
         */
        @Timed
        @GetMapping("/longArtComment/queryListByLike")
        public ResponseEntity<Page<LongArtComment>> queryListByLike(LongArtComment longArtComment, Page<LongArtComment> page) {
            logger.info("LongArtComment query queryLongArtCommentList() [ /longArtComment/queryList]\n = {} \npage = {current = {},size = {}}", longArtComment, page.getCurrent(), page.getSize());
            QueryWrapper<LongArtComment> queryWrapper = new QueryWrapper<>();
            //模糊查询
            //if (!StringUtils.isEmpty(longArtComment.getAppName())) {
            //    queryWrapper.like("查询字段", longArtComment.getAppName());
            //    longUpdateInfo.setAppName(null);
            //}
            //精准查询
            //if (StringUtils.isNotBlank(longArtComment.getAppName())) {
            //    queryWrapper.eq("查询字段", longArtComment.getAppName());
            //    longUpdateInfo.setVerName(null);
            //}
            page = longArtCommentService.page(page,queryWrapper);

            return ResponseEntity.ok().body(page);
        }

    /**
     * 根据id查询（查）
     *
     * @param id
     * @return
     */
    @Timed
    @GetMapping("/longArtComment/select/{id}")
    public ResponseEntity<LongArtComment> selectLongArtCommentById(@PathVariable String id) {
        logger.info("查询的Id === {}", id);
        LongArtComment longArtComment = longArtCommentService.getById(id);
        return ResponseEntity.ok().body(longArtComment);
    }

    /**
     * 删除操作（删）
     *
     * @param id
     * @return
     */
    @Timed
    @DeleteMapping("/longArtComment/remove/{id}")
    public BaseNoResp<Boolean> removeLongArtCommentById(@PathVariable String id) {
        logger.info("删除操作id === {}", id);
        return Res.noBody(longArtCommentService.removeById(id));
    }

    /**
     * 插入数据（增）（改）
     *
     * @param longArtComment
     * @return
     */
    @Timed
    @PostMapping("/longArtComment/saveOrUpdate")
    public ResponseEntity<LongArtComment> saveLongArtComment(@RequestBody LongArtComment longArtComment) {
        logger.info("添加操作 === {}", longArtComment);
        longArtCommentService.saveOrUpdate(longArtComment);
        return ResponseEntity.ok().body(longArtComment);
    }


}