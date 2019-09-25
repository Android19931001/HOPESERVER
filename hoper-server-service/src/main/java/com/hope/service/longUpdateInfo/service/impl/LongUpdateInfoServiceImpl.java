package com.hope.service.longUpdateInfo.service.impl;

import base.BaseServiceImpl;
import com.hope.service.longUpdateInfo.domain.LongUpdateInfoEntity;
import com.hope.service.longUpdateInfo.mapper.LongUpdateInfoMapper;
import com.hope.service.longUpdateInfo.service.LongUpdateInfoService;
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
