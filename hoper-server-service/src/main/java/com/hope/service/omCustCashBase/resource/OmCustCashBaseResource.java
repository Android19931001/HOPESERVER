package com.hope.service.omCustCashBase.resource;

import base.BaseNoResp;
import com.hope.service.omCustCashBase.domain.OmCustCashBaseEntity;
import com.hope.service.omCustCashBase.service.impl.OmCustCashBaseServiceImpl;
import contant.Contants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import utils.Result;


/**
 * @author wangning
 */
@RestController
@RequestMapping("/webservice")
public class OmCustCashBaseResource {

    private Logger logger = LoggerFactory.getLogger(OmCustCashBaseResource.class);

    @Autowired
    OmCustCashBaseServiceImpl omCustCashBaseService;

    @Autowired
    RestTemplate restTemplate;

    /**
     * 根据id查询（查）
     *
     * @param id
     * @return
     */
    @Timed(millis = Contants.TIME_PRIOD)
    @GetMapping("/omCustCashBase/select/{id}")
    public ResponseEntity<OmCustCashBaseEntity> selectOmCustCashBaseById(@PathVariable String id) {
        logger.info("查询的Id === {}", id);
        OmCustCashBaseEntity omCustCashBaseEntity = omCustCashBaseService.getById(id);
        return ResponseEntity.ok().body(omCustCashBaseEntity);
    }

    /**
     * 删除操作（删）
     *
     * @param id
     * @return
     */
    @Timed(millis = Contants.TIME_PRIOD)
    @DeleteMapping("/omCustCashBase/remove/{id}")
    public BaseNoResp<Boolean> removeOmCustCashBaseById(@PathVariable String id) {
        logger.info("删除操作id === {}", id);
        return Result.noBody(omCustCashBaseService.removeById(id));
    }

    /**
     * 插入数据（增）（改）
     *
     * @param omCustCashBaseEntity
     * @return
     */
    @Timed(millis = Contants.TIME_PRIOD)
    @PostMapping("/omCustCashBase/saveOrUpdate")
    public ResponseEntity<OmCustCashBaseEntity> saveOmCustCashBase(@RequestBody OmCustCashBaseEntity omCustCashBaseEntity) {
        logger.info("添加操作 === {}", omCustCashBaseEntity);
        omCustCashBaseService.saveOrUpdate(omCustCashBaseEntity);
        return ResponseEntity.ok().body(omCustCashBaseEntity);
    }


}