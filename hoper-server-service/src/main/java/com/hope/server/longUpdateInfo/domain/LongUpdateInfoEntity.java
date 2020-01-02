package com.hope.server.longUpdateInfo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hope.server.base.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * com.hope.server
 *
 * @author wangning
 */

@Data
@Getter
@Setter
@TableName("long_update_info")
public class LongUpdateInfoEntity extends BaseEntity {

    /**
     * 主键id
     */
    private int id;
    /**
     * app名称
     */
    private String appName;
    /**
     * 版本号，如：1
     */
    private String verCode;
    /**
     * 版本名称，如：1.1.1
     */
    private String verName;
    /**
     * 更新说明
     */
    private String updateNote;
    /**
     * Apk安装包更新地址
     */
    private String updateLink;

}
