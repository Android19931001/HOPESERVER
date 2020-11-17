package com.hope.server.business.versionRelease.dto;

import com.server.service.base.BaseEntity;
import lombok.Data;


/**
 * @author wangning
 */

@Data
public class VersionReleaseDTO extends BaseEntity{

    /**
     * 
     */
    private String id;
    /**
     * 
     */
    private String versionCode;
    /**
     * 
     */
    private String versionName;

    private String appName;


}
