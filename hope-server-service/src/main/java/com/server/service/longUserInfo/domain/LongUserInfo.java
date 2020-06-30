package com.server.service.longUserInfo.domain;

import com.server.service.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * @author wangning
 */

@Data
@Getter
@Setter
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

}
