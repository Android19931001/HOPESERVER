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
    private String content;

    /**
     * 标题
     */
    private String title;

    /**
     * 副标题
     */
    private String subTitle;

    /**
     * 用户称呼
     */
    private String userName;

    private String headPortraitUrl;
}
