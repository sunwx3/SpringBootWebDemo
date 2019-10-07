package com.sunwx.springboot.utils;

import com.sunwx.springboot.exception.BizException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class DownloadService {
    Logger logger = LoggerFactory.getLogger(DownloadService.class);

    public <T> void download(HttpServletRequest request,
                             HttpServletResponse response, String fileName, Downloader downloader) {
        String codeType = "UTF-8";
        String userAgent = request.getHeader("USER-AGENT");
        if (StringUtils.isNotBlank(userAgent) && userAgent.contains("Windows")) {
            codeType = "GBK";
        }
        ServletOutputStream os = null;
        String msg = "";
        response.reset();
        try {
            fileName = new String(fileName.getBytes(codeType), "iso-8859-1");// 为了解决中文名称乱码问题
            os = response.getOutputStream();
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/octet-stream; charset=utf-8");

            downloader.download(os);
            os.flush();
        } catch (BizException e) {
            logger.error(e.getMessage());
            msg = e.getMessage();
            try {
                response.setContentType("text/html; charset=utf-8");
                os.write(msg.getBytes());
                os.flush();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            logger.error(Constants.DEF_FAIL_MSG, e);
            msg = e.getMessage();
            try {
                response.setContentType("text/html; charset=utf-8");
                os.write(msg.getBytes());
                os.flush();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

