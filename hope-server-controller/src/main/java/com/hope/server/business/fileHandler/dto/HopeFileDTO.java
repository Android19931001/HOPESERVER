package com.hope.server.business.fileHandler.dto;

import com.server.service.base.BaseEntity;
import lombok.Data;


/**
 * @author wangning
 */

@Data
public class HopeFileDTO extends BaseEntity{

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
