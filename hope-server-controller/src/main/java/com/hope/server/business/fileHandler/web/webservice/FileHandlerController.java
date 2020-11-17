package com.hope.server.business.fileHandler.web.webservice;

import com.codahale.metrics.annotation.Timed;
import com.hope.server.api.longHopeFile.dto.LongHopeFile;
import com.hope.server.api.longHopeFile.service.LongHopeFileService;
import com.hope.server.api.longVersionRelease.dto.LongVersionRelease;
import com.hope.server.business.fileHandler.service.HopeFileService;
import com.hope.server.utils.PropertiesQuery;
import com.server.service.base.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author wangning
 */
@Slf4j
@RestController
@RequestMapping("/webservice")
public class FileHandlerController {

    @Autowired
    PropertiesQuery propertiesQuery;


    @Autowired
    HopeFileService hopeFileService;

    @Autowired
    LongHopeFileService longHopeFileService;


    /**
     * 查询APP更新信息
     *
     * @param * @param id
     * @return void
     * @author wangning
     * @date 2020/11/12
     */
    @Timed
    @PostMapping("/queryUpdateInfo")
    public void queryUpdateInfo(LongVersionRelease versionRelease) {
        log.info("查看");
    }


    /**
     * 上传图片
     *
     * @param * @param servletRequest
     * @return com.server.service.base.Result
     * @author wangning
     * @date 2020/11/4
     */
    @Timed
    @PostMapping("/fileHandler/hope-file-upload")
    public Result hopeFileUpload(HttpServletRequest servletRequest) {
        log.info("图片上传接口参数=============>{}", servletRequest);
        return hopeFileService.handlerUploadFile(servletRequest);
    }

    /**
     * 根据问价id获取图片资源
     *
     * @param * @param response
     * @return void
     * @author wangning
     * @date 2020/11/5
     */
    @Timed
    @GetMapping("/fileHandler/hope-file/{fileId}")
    public void getHopeLongImage(@PathVariable("fileId") String fileId, HttpServletResponse servletResponse) {
        try {
            //默认图片文件路径
            String filePath = propertiesQuery.getFilePath() + File.separator + "logo.png";
            if (StringUtils.isNotEmpty(fileId)) {
                LongHopeFile longHopeFile = longHopeFileService.getById(fileId);
                if (null != longHopeFile) {
                    filePath = longHopeFile.getFileUploadPath();
                }
            }
            System.out.println("路径为：" + propertiesQuery.getFilePath());
            File file = new File(filePath);
            FileInputStream is = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            OutputStream os = servletResponse.getOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            os.write(baos.toByteArray());
            is.close();
            baos.close();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 下载文件
     *
     * @param * @param fileId
     * @param servletResponse
     * @return void
     * @author wangning
     * @date 2020/11/16
     */
    @Timed
    @GetMapping("/fileHandler/download-hope-file/{fileId}")
    public void downloadFile(@PathVariable("fileId") String fileId, HttpServletResponse servletResponse) {
        try {
            //默认图片文件路径
            String filePath = propertiesQuery.getFilePath() + File.separator + "logo.png";
            if (StringUtils.isNotEmpty(fileId)) {
                LongHopeFile longHopeFile = longHopeFileService.getById(fileId);
                if (null != longHopeFile) {
                    filePath = longHopeFile.getFileUploadPath();
                }
            }
            System.out.println("路径为：" + propertiesQuery.getFilePath());
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);

            servletResponse.setHeader("content-type", "application/octet-stream");
            servletResponse.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            servletResponse.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            OutputStream os = servletResponse.getOutputStream();
            int ch = 0;
            while (-1 != (ch = fis.read())) {
                baos.write(ch);
            }
            os.write(baos.toByteArray());
            fis.close();
            baos.close();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
