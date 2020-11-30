package com.hope.server.business.fileHandler.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hope.server.api.longHopeFile.dto.LongHopeFile;
import com.hope.server.api.longHopeFile.service.LongHopeFileService;
import com.hope.server.api.longUserInfo.domain.LongUserInfo;
import com.hope.server.api.longUserInfo.service.LongUserInfoService;
import com.hope.server.business.fileHandler.dto.HopeFileDTO;
import com.hope.server.business.fileHandler.service.HopeFileService;
import com.hope.server.utils.PropertiesQuery;
import com.server.service.base.Result;
import com.server.service.utils.Res;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

/**
 * @author wangning
 */
@Slf4j
@Service
public class HopeFileServiceImpl implements HopeFileService {


    @Autowired
    PropertiesQuery propertiesQuery;

    @Autowired
    LongUserInfoService longUserInfoService;

    @Autowired
    LongHopeFileService longHopeFileService;

    /**
     * 处理上传的文件
     *
     * @param * @param servletRequest
     * @return void
     * @author wangning
     * @date 2020/11/5
     */
    @Override
    public Result handlerUploadFile(HttpServletRequest servletRequest) {
        String id = servletRequest.getParameter("id");
        if (StringUtils.isEmpty(id)) {
            return Res.error("用户ID不能为空！");
        }
        String type = servletRequest.getParameter("type");
        if (StringUtils.isEmpty(type)) {
            return Res.error("文件类型不能为空");
        }
        InputStream inputStream;
        FileOutputStream fos;
        File file = null;
        //文件的访问地址
        String imgFilePath = "";
        try {
            String filePath = propertiesQuery.getFilePath() + File.separator + id;
            File directoryPath = new File(filePath);
            file = new File(filePath + File.separator + UUID.randomUUID().toString().replaceAll("-", "") + ".jpg");
            if (!directoryPath.exists()) {
                directoryPath.mkdirs();
            }
            file.createNewFile();
            inputStream = servletRequest.getPart("file").getInputStream();
            fos = new FileOutputStream(file);
            int ch = 0;
            while (-1 != (ch = inputStream.read())) {
                fos.write(ch);
            }
            fos.close();
            inputStream.close();
            LongUserInfo longUserInfo = longUserInfoService.getById(id);
            //用户不存在 删除文件
            if (null == longUserInfo) {
                file.delete();
                return Res.error("用户不存在");
            }
            imgFilePath = propertiesQuery.getIpAddress() + "/webservice/fileHandler/hope-file/" + file.getName();

            if (type.contains("1")) {
                QueryWrapper fileWrapper = new QueryWrapper();
                fileWrapper.eq("file_upload_user_id", id);
                fileWrapper.eq("file_upload_type", type);
                LongHopeFile existFileRecord = longHopeFileService.getOne(fileWrapper);
                //删除旧文件与旧记录
                if (null != existFileRecord) {
                    new File(existFileRecord.getFileUploadPath()).delete();
                    longHopeFileService.removeById(existFileRecord.getId());
                }
                longUserInfo.setHeadPortraitUrl(imgFilePath);
                longUserInfoService.saveOrUpdate(longUserInfo);
            }
            //将文件信息保存到数据库中
            LongHopeFile longHopeFile = new LongHopeFile();
            longHopeFile.setId(file.getName());
            longHopeFile.setFileUploadPath(file.getAbsolutePath());
            longHopeFile.setFileUploadType(type);
            longHopeFile.setFileUploadUserId(id);
            longHopeFile.setFileUploadUserName(longUserInfo.getUserName());
            longHopeFileService.save(longHopeFile);
        } catch (Exception e) {
            if (null != file) {
                file.delete();
            }
            log.error("上传文件发生异常", e);
            return Res.error("上传文件发生异常！");
        }
        return Res.success(imgFilePath);
    }



}
