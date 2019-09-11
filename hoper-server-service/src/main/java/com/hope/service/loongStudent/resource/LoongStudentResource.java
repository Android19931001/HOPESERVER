package com.hope.service.loongStudent.resource;


import Contant.Contants;
import base.BaseNoResp;
import com.hope.service.loongStudent.domain.LoongStudentEntity;
import com.hope.service.loongStudent.service.impl.LoongStudentServiceImpl;
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
@RequestMapping("/webservice")
public class LoongStudentResource {

    private Logger logger = LoggerFactory.getLogger(LoongStudentResource.class);

    @Autowired
    LoongStudentServiceImpl loongStudentService;

    /**
     * 根据id查询（查）
     *
     * @param id
     * @return
     */
    @Timed(millis = Contants.TIME_PRIOD)
    @GetMapping("loongStudent/select/{id}")
    public ResponseEntity<LoongStudentEntity> selectLoongStudentById(@PathVariable String id) {
        logger.info("查询的Id === {}", id);
        LoongStudentEntity loongStudentEntity = loongStudentService.getById(id);
        return ResponseEntity.ok().body(loongStudentEntity);
    }

    /**
     * 删除操作（删）
     *
     * @param id
     * @return
     */
    @Timed(millis = Contants.TIME_PRIOD)
    @DeleteMapping("loongStudent/remove/{id}")
    public BaseNoResp<Boolean> removeLoongStudentById(@PathVariable String id) {
        logger.info("删除操作id === {}", id);
        return Result.noBody(loongStudentService.removeById(id));
    }

    /**
     * 插入数据（增）（改）
     *
     * @param loongStudentEntity
     * @return
     */
    @Timed(millis = Contants.TIME_PRIOD)
    @PostMapping("loongStudent/saveOrUpdate")
    public ResponseEntity<LoongStudentEntity> saveLoongStudent(@RequestBody LoongStudentEntity loongStudentEntity) {
        logger.info("添加操作 === {}", loongStudentEntity);
        loongStudentService.saveOrUpdate(loongStudentEntity);
        return ResponseEntity.ok().body(loongStudentEntity);
    }


}