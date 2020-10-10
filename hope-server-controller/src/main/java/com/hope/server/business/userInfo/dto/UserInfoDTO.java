package com.hope.server.business.userInfo.dto;

import com.server.service.base.BaseEntity;
import lombok.Data;


/**
 * @author wangning
 */

@Data
public class UserInfoDTO extends BaseEntity{

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

}
