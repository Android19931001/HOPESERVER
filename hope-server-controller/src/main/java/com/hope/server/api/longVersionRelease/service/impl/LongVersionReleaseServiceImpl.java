package com.hope.server.api.longVersionRelease.service.impl;

import com.hope.server.api.longVersionRelease.dto.LongVersionRelease;
import com.hope.server.api.longVersionRelease.mapper.LongVersionReleaseMapper;
import com.hope.server.api.longVersionRelease.service.LongVersionReleaseService;
import com.server.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author wangning
 */
@Service
public class LongVersionReleaseServiceImpl extends BaseServiceImpl<LongVersionReleaseMapper, LongVersionRelease> implements LongVersionReleaseService {

    private LongVersionReleaseMapper longVersionReleaseMapper;

    public LongVersionReleaseServiceImpl(LongVersionReleaseMapper longVersionReleaseMapper) {
        this.longVersionReleaseMapper = longVersionReleaseMapper;
    }
}
