package com.server.service.longUserInfo.service.impl;

import com.server.service.base.BaseServiceImpl;
import com.server.service.longUserInfo.domain.LongUserInfo;
import com.server.service.longUserInfo.mapper.LongUserInfoMapper;
import com.server.service.longUserInfo.service.LongUserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author wangning
 */
@Service
public class LongUserInfoServiceImpl extends BaseServiceImpl<LongUserInfoMapper, LongUserInfo> implements LongUserInfoService {

    /*private LongUserInfoMapper longUserInfoMapper;

    public LongUserInfoServiceImpl(LongUserInfoMapper longUserInfoMapper) {
        this.longUserInfoMapper = longUserInfoMapper;
    }*/
}
