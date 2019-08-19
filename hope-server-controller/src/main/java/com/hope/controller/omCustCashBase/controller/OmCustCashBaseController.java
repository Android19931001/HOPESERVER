package com.hope.controller.omCustCashBase.controller;

import base.BaseRes;
import base.ErrorResp;
import com.hope.controller.omCustCashBase.client.OmCustCahsBaseClient;
import com.hope.controller.omCustCashBase.dto.OmCustCashBaseDto;
import contant.Contants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.*;
import utils.Result;

/**
 * @author wangning
 */
@RestController
@RequestMapping("/hope-controller")
public class OmCustCashBaseController {

    private Logger logger = LoggerFactory.getLogger(OmCustCashBaseController.class);


    @Autowired
    OmCustCahsBaseClient omCustCahsBaseClient;

    @Timed(millis = Contants.TIME_PRIOD)
    @GetMapping("/getOmCustCashBaseById/{id}")
    public BaseRes<OmCustCashBaseDto> getOmCustCashBaseById(@PathVariable String id) {
        logger.info("OmCustCashBaseController-----入参id = {}", id);



        OmCustCashBaseDto omCustCashBaseDto = omCustCahsBaseClient.getOmCustCashBaseById(id).getBody();
        if (null == omCustCashBaseDto) {
            return Result.error(new ErrorResp("根据id：" + id + "未查询到数据"));
        }
        return Result.ok(omCustCashBaseDto);
    }
}
