package com.five.monkey.provider.file;

import com.five.monkey.provider.file.pojo.FileInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

/**
 * 文件操作
 *
 * @author jim
 * @date 2020/7/20 18:12
 */
@Component
@Slf4j
public class FileOperator {

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    public FileInfo upload(MultipartFile file) {
        String sourceName = file.getOriginalFilename();
        Long fileSize = file.getSize();
        String suffix = FilenameUtils.getExtension(sourceName);


    }

    String upload(InputStream inputStream, String dir, String ext) {
        File file;
        String fileName;
        String realPath = resourceConfig.getResourceUploadPath() + dir;
        do {
            fileName = UUID.randomUUID().toString() + "." + ext;
            file = new File(realPath + fileName);
        } while (file.exists());
        // 目录不存在时创建
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        BufferedOutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(file));
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        } catch (Exception e) {
            log.error("文件上传失败!错误信息 : {}", e.getMessage());
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
        }
        return fileName;
    }
}
