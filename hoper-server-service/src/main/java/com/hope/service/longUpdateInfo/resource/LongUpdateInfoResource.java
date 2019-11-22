package com.hope.service.longUpdateInfo.resource;


import base.BaseNoResp;
import com.hope.service.longUpdateInfo.domain.LongUpdateInfoEntity;
import com.hope.service.longUpdateInfo.service.impl.LongUpdateInfoServiceImpl;
import contant.Contants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.*;
import utils.Result;


/**
 * @author wangning
 */
@RestController
@RequestMapping("/api")
public class LongUpdateInfoResource {

    private Logger logger = LoggerFactory.getLogger(LongUpdateInfoResource.class);

    @Autowired
    LongUpdateInfoServiceImpl longUpdateInfoService;

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
        return Result.noBody(longUpdateInfoService.removeById(id));
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