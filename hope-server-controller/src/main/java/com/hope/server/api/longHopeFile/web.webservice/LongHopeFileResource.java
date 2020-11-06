package com.hope.server.api.longHopeFile.web.webservice;


import com.server.service.base.BaseNoResp;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hope.server.api.longHopeFile.dto.LongHopeFile;
import com.hope.server.api.longHopeFile.service.LongHopeFileService;
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
public class LongHopeFileResource {

    private Logger logger = LoggerFactory.getLogger(LongHopeFileResource.class);

    @Autowired
    LongHopeFileService longHopeFileService;


    /**
         * 分页查询
         *
         * @param longHopeFile
         * @param page
         * @return
         */
        @Timed
        @GetMapping("/longHopeFile/queryLongHopeFileList")
        public ResponseEntity<Page<LongHopeFile>> queryLongHopeFileList(LongHopeFile longHopeFile, Page<LongHopeFile> page) {
            logger.info("LongHopeFile query queryLongHopeFileList() [ /longHopeFile/queryList]\n = {} \npage = {current = {},size = {}}", longHopeFile, page.getCurrent(), page.getSize());
            page = longHopeFileService.page(page, new QueryWrapper<>());
            return ResponseEntity.ok().body(page);
        }


        /**
         * 分页查询（模糊查询）
         *
         * @param longHopeFile
         * @param page
         * @return
         */
        @Timed
        @GetMapping("/longHopeFile/queryListByLike")
        public ResponseEntity<Page<LongHopeFile>> queryListByLike(LongHopeFile longHopeFile, Page<LongHopeFile> page) {
            logger.info("LongHopeFile query queryLongHopeFileList() [ /longHopeFile/queryList]\n = {} \npage = {current = {},size = {}}", longHopeFile, page.getCurrent(), page.getSize());
            QueryWrapper<LongHopeFile> queryWrapper = new QueryWrapper<>();
            //模糊查询
            //if (!StringUtils.isEmpty(longHopeFile.getAppName())) {
            //    queryWrapper.like("查询字段", longHopeFile.getAppName());
            //    longUpdateInfo.setAppName(null);
            //}
            //精准查询
            //if (StringUtils.isNotBlank(longHopeFile.getAppName())) {
            //    queryWrapper.eq("查询字段", longHopeFile.getAppName());
            //    longUpdateInfo.setVerName(null);
            //}
            page = longHopeFileService.page(page,queryWrapper);

            return ResponseEntity.ok().body(page);
        }

    /**
     * 根据id查询（查）
     *
     * @param id
     * @return
     */
    @Timed
    @GetMapping("/longHopeFile/select/{id}")
    public ResponseEntity<LongHopeFile> selectLongHopeFileById(@PathVariable String id) {
        logger.info("查询的Id === {}", id);
        LongHopeFile longHopeFile = longHopeFileService.getById(id);
        return ResponseEntity.ok().body(longHopeFile);
    }

    /**
     * 删除操作（删）
     *
     * @param id
     * @return
     */
    @Timed
    @DeleteMapping("/longHopeFile/remove/{id}")
    public BaseNoResp<Boolean> removeLongHopeFileById(@PathVariable String id) {
        logger.info("删除操作id === {}", id);
        return Res.noBody(longHopeFileService.removeById(id));
    }

    /**
     * 插入数据（增）（改）
     *
     * @param longHopeFile
     * @return
     */
    @Timed
    @PostMapping("/longHopeFile/saveOrUpdate")
    public ResponseEntity<LongHopeFile> saveLongHopeFile(@RequestBody LongHopeFile longHopeFile) {
        logger.info("添加操作 === {}", longHopeFile);
        longHopeFileService.saveOrUpdate(longHopeFile);
        return ResponseEntity.ok().body(longHopeFile);
    }


}