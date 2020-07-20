package com.five.monkey.provider.file.pojo;

import lombok.Data;

/**
 *
 *
 * @author jim
 * @date 2020/7/20 18:14
 */
@Data
public class FileInfo {

    /** 源文件名称 */
    private String sourceFileName;

    /** 上传后文件名称 */
    private String targetFileName;

    /** 文件类型 */
    private Byte fileType;

    /** 文件大小,单位字节 */
    private Long fileSize;

}
