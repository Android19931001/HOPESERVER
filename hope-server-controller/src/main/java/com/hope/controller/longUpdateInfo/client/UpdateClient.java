package com.hope.controller.longUpdateInfo.client;

import com.hope.controller.longUpdateInfo.dto.UpdateInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wangning
 */
@FeignClient(name = "${instance.Service.ServiceName}",url = "${instance.Service.ServiceHost}")
public interface UpdateClient {

    //    通过FeignClient调用service接口时参数的前的注解中需要加入入参名称
//    ======例如：getOmCustCashBaseById(@PathVariable String id)
//    修改成=====》getOmCustCashBaseById(@PathVariable("id") String id)

    /**
     * 通过id获取对象
     *
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/api/longUpdateInfo/select/{id}")
    ResponseEntity<UpdateInfo> queryUpdateInfoById(@PathVariable("id") String id);
}
