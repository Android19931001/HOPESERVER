package com.hope.server.api.longUserInfo.domain;

import com.server.service.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author wangning
 */

@Data
@TableName("long_user_info")
public class LongUserInfo extends BaseEntity {

    /**
     * 用户表主键
     */
    private String id;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户手机号
     */
    private String phoneNumber;
    /**
     * 用户手机型号
     */
    private String phoneType;
    /**
     * 用户手机版本号
     */
    private String phoneVersion;
    /**
     * 用户登录密码
     */
    private String userPwd;

    /**
     * 用户头像
     */
    private String headPortraitUrl;

}
