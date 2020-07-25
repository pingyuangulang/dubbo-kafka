package com.five.monkey.provider.file.enums;

import org.apache.commons.lang3.StringUtils;

/**
 *
 *
 * @author jim
 * @date 2020/7/20 18:39
 */
public enum FileTypeEnum {

    DEFAULT((byte) 0, "", "/default/", "默认文件"),

    IMAGE((byte) 1, "jpg,jpeg,png,ico,tif", "/image/", "图片"),

    DOC((byte) 2, "ppt,pptx,json,txt,xls,xlsx,pdf,doc,docx", "/doc/", "文档"),

    ZIP((byte) 3, "zip,rar", "/zip", "压缩包"),

    AUDIO((byte) 4, "m4a,wav,mp3,wma,au,aiff,aifc,aac,flac,mp2,ogg", "/audio/", "音频"),

    VIDEO((byte) 5, "avi,mp4,mov,mpg,wmv,f4v,flv,vob,3gp,rmvb,webm,m4v,m3u8", "/video/", "视频");

    /** 文件类型 */
    private Byte type;

    /** 文件后缀 */
    private String extensions;

    /** 目录 */
    private String dir;

    private String desc;

    FileTypeEnum(Byte type, String extensions, String dir, String desc) {
        this.type = type;
        this.extensions = extensions;
        this.dir = dir;
        this.desc = desc;
    }

    public Byte getType() {
        return type;
    }

    public String getExtensions() {
        return extensions;
    }

    public String getDir() {
        return dir;
    }

    public static FileTypeEnum getInstance(String extension) {
        if (StringUtils.isBlank(extension)) {
            return FileTypeEnum.DEFAULT;
        }
        FileTypeEnum[] fileTypeEnums = FileTypeEnum.values();
        FileTypeEnum fileTypeEnum = FileTypeEnum.DEFAULT;
        for (FileTypeEnum typeEnum : fileTypeEnums) {
            String extensions = typeEnum.getExtensions();
            if (StringUtils.isBlank(extensions)) {
                continue;
            }
            String[] extensionArray = extensions.split(",");
            for (String str : extensionArray) {
                if (StringUtils.equalsIgnoreCase(str, extension)) {
                    fileTypeEnum = typeEnum;
                    break;
                }
            }
        }
        return fileTypeEnum;
    }
}
