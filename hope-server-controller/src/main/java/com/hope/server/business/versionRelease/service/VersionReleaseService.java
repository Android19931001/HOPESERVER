package com.hope.server.business.versionRelease.service;


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


}
