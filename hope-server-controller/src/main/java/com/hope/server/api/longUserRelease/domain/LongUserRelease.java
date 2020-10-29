package com.hope.server.api.longUserRelease.domain;

import com.server.service.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author wangning
 */

@Data
@TableName("long_user_release")
public class LongUserRelease extends BaseEntity{

    /**
     * 主键id
     */
    private String id;
    /**
     * 用户id
     */
    private String reUserId;
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
}
