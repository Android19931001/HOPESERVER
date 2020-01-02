package com.hope.server.longUpdateInfo.service.impl;

import com.hope.server.base.BaseServiceImpl;
import com.hope.server.longUpdateInfo.domain.LongUpdateInfoEntity;
import com.hope.server.longUpdateInfo.mapper.LongUpdateInfoMapper;
import com.hope.server.longUpdateInfo.service.LongUpdateInfoService;
import org.springframework.stereotype.Service;

/**
 * @author wangning
 */
@Service
public class LongUpdateInfoServiceImpl extends BaseServiceImpl<LongUpdateInfoMapper, LongUpdateInfoEntity> implements LongUpdateInfoService {

    private LongUpdateInfoMapper longUpdateInfoMapper;

    public LongUpdateInfoServiceImpl(LongUpdateInfoMapper longUpdateInfoMapper) {
        this.longUpdateInfoMapper = longUpdateInfoMapper;
    }
}
