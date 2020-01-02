package com.server.service.longUpdateInfo.service.impl;

import com.server.service.base.BaseServiceImpl;
import com.server.service.longUpdateInfo.domain.LongUpdateInfoEntity;
import com.server.service.longUpdateInfo.mapper.LongUpdateInfoMapper;
import com.server.service.longUpdateInfo.service.LongUpdateInfoService;
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
