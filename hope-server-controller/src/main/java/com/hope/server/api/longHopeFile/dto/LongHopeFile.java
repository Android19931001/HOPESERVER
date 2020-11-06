package com.hope.server.api.longHopeFile.dto;

import com.server.service.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author wangning
 */

@Data
@TableName("long_hope_file")
public class LongHopeFile extends BaseEntity{

    /**
     * 
     */
    private String id;
    /**
     * 
     */
    private String fileUploadUserId;
    /**
     * 
     */
    private String fileUploadUserName;
    /**
     * 
     */
    private String fileUploadPath;
    /**
     * 
     */
    private String fileUploadType;



}
