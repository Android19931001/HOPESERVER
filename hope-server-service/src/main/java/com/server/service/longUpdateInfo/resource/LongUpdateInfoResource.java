package com.server.service.longUpdateInfo.resource;


import com.server.service.contant.Contants;
import com.server.service.base.BaseNoResp;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.server.service.longUpdateInfo.domain.LongUpdateInfoEntity;
import com.server.service.longUpdateInfo.service.LongUpdateInfoService;
import com.server.service.utils.Res;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.*;


/**
 * @author wangning
 */
@RestController
@RequestMapping("/api")
public class LongUpdateInfoResource {

    private Logger logger = LoggerFactory.getLogger(LongUpdateInfoResource.class);

    @Autowired
    LongUpdateInfoService longUpdateInfoService;


    /**
     * 分页查询
     *
     * @param longUpdateInfoEntity
     * @param page
     * @return
     */
    @Timed(millis = Contants.TIME_PRIOD)
    @GetMapping("/longUpdateInfo/queryLongUpdateInfoList")
    public ResponseEntity<Page<LongUpdateInfoEntity>> queryLongUpdateInfoList(LongUpdateInfoEntity longUpdateInfoEntity, Page<LongUpdateInfoEntity> page) {
        logger.info("LongUpdateInfoEntity query queryLongUpdateInfoList() [ /longUpdateInfo/queryList]\ncom.hope.server.entity = {} \npage = {current = {},size = {}}", longUpdateInfoEntity, page.getCurrent(), page.getSize());
        page = (Page<LongUpdateInfoEntity>) longUpdateInfoService.page(page, new QueryWrapper<>());
        return ResponseEntity.ok().body(page);
    }


    /**
     * 分页查询（模糊查询）
     *
     * @param longUpdateInfoEntity
     * @param page
     * @return
     */
    @Timed(millis = Contants.TIME_PRIOD)
    @GetMapping("/longUpdateInfo/queryListByLike")
    public ResponseEntity<Page<LongUpdateInfoEntity>> queryListByLike(LongUpdateInfoEntity longUpdateInfoEntity, Page<LongUpdateInfoEntity> page) {
        logger.info("LongUpdateInfoEntity query queryLongUpdateInfoList() [ /longUpdateInfo/queryList]\ncom.hope.server.entity = {} \npage = {current = {},size = {}}", longUpdateInfoEntity, page.getCurrent(), page.getSize());
        QueryWrapper<LongUpdateInfoEntity> queryWrapper = new QueryWrapper<>();
//            模糊查询
        if (!StringUtils.isEmpty(longUpdateInfoEntity.getAppName())) {
            queryWrapper.like("app_name", longUpdateInfoEntity.getAppName());
            longUpdateInfoEntity.setAppName(null);
        }
//            精准查询
        if (StringUtils.isNotBlank(longUpdateInfoEntity.getAppName())) {
            queryWrapper.eq("ver_name", longUpdateInfoEntity.getAppName());
            longUpdateInfoEntity.setVerName(null);
        }
        page = (Page<LongUpdateInfoEntity>) longUpdateInfoService.page(page, queryWrapper);

        return ResponseEntity.ok().body(page);
    }

    /**
     * 根据id查询（查）
     *
     * @param id
     * @return
     */
    @Timed(millis = Contants.TIME_PRIOD)
    @GetMapping("/longUpdateInfo/select/{id}")
    public ResponseEntity<LongUpdateInfoEntity> selectLongUpdateInfoById(@PathVariable String id) {
        logger.info("查询的Id === {}", id);
        LongUpdateInfoEntity longUpdateInfoEntity = longUpdateInfoService.getById(id);
        return ResponseEntity.ok().body(longUpdateInfoEntity);
    }

    /**
     * 删除操作（删）
     *
     * @param id
     * @return
     */
    @Timed(millis = Contants.TIME_PRIOD)
    @DeleteMapping("/longUpdateInfo/remove/{id}")
    public BaseNoResp<Boolean> removeLongUpdateInfoById(@PathVariable String id) {
        logger.info("删除操作id === {}", id);
        return Res.noBody(longUpdateInfoService.removeById(id));
    }

    /**
     * 插入数据（增）（改）
     *
     * @param longUpdateInfoEntity
     * @return
     */
    @Timed(millis = Contants.TIME_PRIOD)
    @PostMapping("/longUpdateInfo/saveOrUpdate")
    public ResponseEntity<LongUpdateInfoEntity> saveLongUpdateInfo(@RequestBody LongUpdateInfoEntity longUpdateInfoEntity) {
        logger.info("添加操作 === {}", longUpdateInfoEntity);
        longUpdateInfoService.saveOrUpdate(longUpdateInfoEntity);
        return ResponseEntity.ok().body(longUpdateInfoEntity);
    }


}