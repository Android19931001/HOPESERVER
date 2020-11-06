package com.hope.server.api.longVersionRelease.dto;

import com.server.service.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author wangning
 */

@Data
@TableName("long_version_release")
public class LongVersionRelease extends BaseEntity{

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

}
