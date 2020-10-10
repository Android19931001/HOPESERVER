package com.hope.server.api.longUserRelease.service.impl;

import com.server.service.base.BaseServiceImpl;
import com.hope.server.api.longUserRelease.domain.LongUserRelease;
import com.hope.server.api.longUserRelease.mapper.LongUserReleaseMapper;
import com.hope.server.api.longUserRelease.service.LongUserReleaseService;
import org.springframework.stereotype.Service;

/**
 * @author wangning
 */
@Service
public class LongUserReleaseServiceImpl extends BaseServiceImpl<LongUserReleaseMapper, LongUserRelease> implements LongUserReleaseService {

    private LongUserReleaseMapper longUserReleaseMapper;

    public LongUserReleaseServiceImpl(LongUserReleaseMapper longUserReleaseMapper) {
        this.longUserReleaseMapper = longUserReleaseMapper;
    }
}
