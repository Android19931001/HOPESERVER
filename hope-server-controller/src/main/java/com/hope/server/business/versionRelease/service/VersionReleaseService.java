package com.hope.server.business.versionRelease.service;


import com.hope.server.api.longVersionRelease.dto.LongVersionRelease;
import com.hope.server.business.versionRelease.dto.VersionReleaseDTO;
import com.server.service.base.Result;

/**
 * @author wangning
 */
public interface VersionReleaseService {

    /**
     * 是否显示人脸识别按钮
     *
     * @param * @param versionName
     * @return boolean
     * @author wangning
     * @date 2020/10/30
     */
    boolean isShowFaceCredit(String versionName);


    /**
     * 查询APP更新信息
     *
     * @param * @param versionReleaseDTO
     * @return com.hope.server.business.versionRelease.dto.VersionReleaseDTO
     * @author wangning
     * @date 2020/11/18
     */
    Result queryUpdateInfo(LongVersionRelease versionReleaseDTO);
}
