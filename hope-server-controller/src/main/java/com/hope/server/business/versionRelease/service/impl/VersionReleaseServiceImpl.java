package com.hope.server.business.versionRelease.service.impl;

import com.hope.server.api.longVersionRelease.dto.LongVersionRelease;
import com.hope.server.api.longVersionRelease.service.LongVersionReleaseService;
import com.hope.server.business.versionRelease.service.VersionReleaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangning
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class VersionReleaseServiceImpl implements VersionReleaseService {

    @Autowired
    LongVersionReleaseService longVersionReleaseService;

    @Override
    public boolean isShowFaceCredit(String versionName) {

        LongVersionRelease longVersionRelease = longVersionReleaseService.getById("1323232");
        if (null == longVersionRelease) {
            return false;
        }
        if (longVersionRelease.getVersionName().equals(versionName)) {
            return true;
        }
        return false;
    }
}
