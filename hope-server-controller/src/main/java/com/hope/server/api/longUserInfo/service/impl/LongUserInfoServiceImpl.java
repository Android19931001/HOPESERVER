package com.hope.server.api.longUserInfo.service.impl;

import com.server.service.base.BaseServiceImpl;
import com.hope.server.api.longUserInfo.domain.LongUserInfo;
import com.hope.server.api.longUserInfo.mapper.LongUserInfoMapper;
import com.hope.server.api.longUserInfo.service.LongUserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author wangning
 */
@Service
public class LongUserInfoServiceImpl extends BaseServiceImpl<LongUserInfoMapper, LongUserInfo> implements LongUserInfoService {

    private LongUserInfoMapper longUserInfoMapper;

    public LongUserInfoServiceImpl(LongUserInfoMapper longUserInfoMapper) {
        this.longUserInfoMapper = longUserInfoMapper;
    }
}
