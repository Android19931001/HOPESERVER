package com.hope.server.business.userRelease.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hope.server.api.longUserRelease.domain.LongUserRelease;
import com.hope.server.business.userRelease.dto.UserReleaseDTO;
import com.server.service.base.BaseService;
import com.server.service.base.Result;

/**
 * @author wangning
 */
public interface UserReleaseService {
    /**
     * 查询用户发布的作品
     *
     * @param *    @param userReleaseDTO
     * @param page
     * @return com.server.service.base.Result
     * @author wangning
     * @date 2020/9/2
     */
    Result queryUserRelease(UserReleaseDTO userReleaseDTO, Page<LongUserRelease> page);

    /**
     * 用户发布作品
     *
     * @param * @param longUserRelease
     * @return com.server.service.base.Result
     * @author wangning
     * @date 2020/9/2
     */
    Result userRelease(LongUserRelease longUserRelease);
}
