package com.five.monkey.bo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author jim
 * @date 2020/4/29 18:14
 */
@Data
public class AuthorBo implements Serializable {

    private static final long serialVersionUID = 4571313820011525909L;

    /** 作者id */
    private Long id;

    /** 作者真实名称 */
    private String name;

    /** 作者笔名 */
    private String writeName;

    /** 作者年龄 */
    private Integer age;

    /** 作者性别 */
    private Byte gender;

    /** 作者手机号 */
    private String phone;

    /** 作者有效状态 */
    private Byte deleted;
}
