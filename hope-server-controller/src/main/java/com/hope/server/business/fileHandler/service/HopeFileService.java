package com.hope.server.business.fileHandler.service;


import com.hope.server.business.fileHandler.dto.HopeFileDTO;
import com.server.service.base.Result;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @author wangning
 */
public interface HopeFileService {

    /**
     * 处理上传的文件
     *
     * @param * @param servletRequest
     * @return void
     * @author wangning
     * @date 2020/11/5
     */
    Result handlerUploadFile(HttpServletRequest servletRequest);


}
