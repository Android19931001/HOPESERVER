package com.hope.server.business.versionRelease.service.impl;

import com.hope.server.api.longHopeFile.dto.LongHopeFile;
import com.hope.server.api.longHopeFile.service.LongHopeFileService;
import com.hope.server.api.longVersionRelease.dto.LongVersionRelease;
import com.hope.server.api.longVersionRelease.service.LongVersionReleaseService;
import com.hope.server.business.versionRelease.dto.VersionReleaseDTO;
import com.hope.server.business.versionRelease.service.VersionReleaseService;
import com.server.service.base.Result;
import com.server.service.utils.Res;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
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

    @Autowired
    LongHopeFileService longHopeFileService;

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

    /**
     * 查询APP更新信息
     *
     * @param * @param id
     * @return void
     * @author wangning
     * @date 2020/11/12
     */
    @Override
    public Result queryUpdateInfo(LongVersionRelease versionReleaseDTO) {
        if (StringUtils.isEmpty(versionReleaseDTO.getId())) {
            return Res.error("APP的id为空");
        }
        if (StringUtils.isEmpty(versionReleaseDTO.getVersionName())) {
            return Res.error("APP的版本名为空");
        }
        if (StringUtils.isEmpty(versionReleaseDTO.getVersionCode())) {
            return Res.error("APP的版本号为空");
        }
        LongVersionRelease cacheVersion = longVersionReleaseService.getById(versionReleaseDTO.getId());
        if (null == cacheVersion) {
            return Res.error("未查询到APP相关的版本信息");
        }
        if (!cacheVersion.getVersionCode().equals(versionReleaseDTO.getVersionCode()) ||
                !cacheVersion.getVersionName().equals(versionReleaseDTO.getVersionName())) {
            LongHopeFile longHopeFile = longHopeFileService.getById(versionReleaseDTO.getId());
            if (null == longHopeFile) {
                return Res.error("未查到源文件,请上传apk文件");
            }
            VersionReleaseDTO releaseDTO = new VersionReleaseDTO();
            BeanUtils.copyProperties(cacheVersion, releaseDTO);
            releaseDTO.setDownloadPath("http://121.36.66.235/webservice/fileHandler/download-hope-file/" + versionReleaseDTO.getId());
            return Res.ok(releaseDTO);
        }
        return Res.error("当前版本无需更新!");
    }
}
