package com.hope.server.business.userRelease.dto;

import com.server.service.base.BaseEntity;
import lombok.Data;


/**
 * @author wangning
 */

@Data
public class UserReleaseDTO extends BaseEntity {

    /**
     * 主键id
     */
    private String id;
    /**
     * 用户id
     */
    private String reUserId;
    /**
     * 用户名称
     */
    private String reUserName;
    /**
     * 发布的内容
     */
    private String reText;
    /**
     * 作品图片地址
     */
    private String reImgUrl;
    /**
     * 作品视频地址
     */
    private String reVideoUrl;
    /**
     * 发布时间
     */
    private String reDate;

    /**
     * 用户头像
     */
    private String headPortraitUrl;

}
