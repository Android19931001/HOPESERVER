package com.hope.server.business.versionRelease;

import com.hope.server.api.longUserInfo.domain.LongUserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wangning
 */
@FeignClient(value = "hope-server-service",url = "http://120.48.84.17:1041")
public interface HopeServiceClient {

    /**
     * 获取用户信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/longUserInfo/select/{id}", method = RequestMethod.GET)
    ResponseEntity<LongUserInfo> getUserInfoById(@PathVariable String id);
}
