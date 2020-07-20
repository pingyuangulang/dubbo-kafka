package com.five.monkey.provider.file.enums;

/**
 *
 *
 * @author jim
 * @date 2020/7/20 18:39
 */
public enum FileTypeEnum {

    IMAGE((byte) 0, "jpg,jpeg,png,ico,tif", "图片"),

    DOC((byte) 1, "ppt,pptx,json,txt,xls,xlsx,pdf,doc,docx", "文档"),

    ZIP((byte) 2, "zip,rar", "压缩包"),

    AUDIO((byte) 3, "m4a,wav,mp3,wma,au,aiff,aifc,aac,flac,mp2,ogg", "音频"),

    VIDEO((byte) 4, "avi,mp4,mov,mpg,wmv,f4v,flv,vob,3gp,rmvb,webm,m4v,m3u8", "视频");

    /** 文件类型 */
    private Byte type;

    /** 文件后缀 */
    private String extensions;

    private String desc;

    FileTypeEnum(Byte type, String extensions, String desc) {
        this.type = type;
        this.extensions = extensions;
        this.desc = desc;
    }

    public static FileTypeEnum getInstance(String extensions) {

    }
}
