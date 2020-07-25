package com.five.monkey.provider.file;

import com.five.monkey.provider.file.enums.FileTypeEnum;
import com.five.monkey.provider.file.pojo.FileInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    @Value("${file.upload.path.prefix}")
    private String fileUploadPathPrefix;


    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    public FileInfo upload(MultipartFile file) throws IOException {
        String sourceName = file.getOriginalFilename();
        Long fileSize = file.getSize();
        String extension = FilenameUtils.getExtension(sourceName);
        FileTypeEnum fileTypeEnum = FileTypeEnum.getInstance(extension);
        String realPath = fileUploadPathPrefix + fileTypeEnum.getDir();
        String targetFileName = upload(file.getInputStream(), realPath, extension);
        return new FileInfo(sourceName, targetFileName, realPath, fileTypeEnum.getType(), fileSize);
    }

    /**
     * 文件上传
     *
     * @param inputStream 文件输入流
     * @param realPath 文件上传路径
     * @param ext 文件后缀名，如jpg,mp4,xlsx等
     * @return 文件新名称
     */
    private String upload(InputStream inputStream, String realPath, String ext) {
        File file;
        String fileName;
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
