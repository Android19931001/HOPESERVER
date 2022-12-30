package com.hope.server.business.versionRelease.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.server.service.base.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * @author wangning
 */

@Data
@TableName("long_user_info")
public class LongUserInfo extends BaseEntity<LongUserInfo>{

    /**
     * 用户主键
     */
    private String id;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPwd;

    private String phoneNumber;

    private String headPortraitUrl;

}
