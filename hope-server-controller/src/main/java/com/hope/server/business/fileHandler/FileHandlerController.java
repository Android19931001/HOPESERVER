package com.hope.server.business.fileHandler;

import com.codahale.metrics.annotation.Timed;
import com.hope.server.utils.PropertiesQuery;
import com.server.service.base.Result;
import com.server.service.utils.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author wangning
 */
@RestController
@RequestMapping("/webservice")
public class FileHandlerController {

    @Autowired
    PropertiesQuery propertiesQuery;

    @Timed
    @GetMapping("/hope-long/text")
    public void getHopeLongImage(HttpServletResponse response) {

        try {
            System.out.println("路径为：" + propertiesQuery.getFilePath());
            File file = new File(propertiesQuery.getFilePath() + File.separator + "logo.png");
            FileInputStream is = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            OutputStream os = response.getOutputStream();
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
}
