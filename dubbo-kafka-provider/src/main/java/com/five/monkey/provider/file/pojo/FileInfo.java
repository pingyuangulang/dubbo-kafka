package com.five.monkey.provider.file.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 *
 * @author jim
 * @date 2020/7/20 18:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileInfo {

    /** 源文件名称 */
    private String sourceFileName;

    /** 上传后文件名称 */
    private String targetFileName;

    /** 文件上传路径 */
    private String realPath;

    /** 文件类型 */
    private Byte fileType;

    /** 文件大小,单位字节 */
    private Long fileSize;

}
