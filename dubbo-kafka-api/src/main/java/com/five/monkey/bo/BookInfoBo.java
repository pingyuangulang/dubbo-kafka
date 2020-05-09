package com.five.monkey.bo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 书籍表
 *
 * @author jim
 * @date 2020/4/29 17:34
 */
@Data
public class BookInfoBo implements Serializable {

    private static final long serialVersionUID = 4807284352115933889L;

    /** 主键 */
    private Long bookId;

    /** 书籍名称 */
    private String bookName;

    /** 作者id */
    private Long authorId;

    /** 作者真实名称 */
    private String authorName;

    /** 作者笔名 */
    private String writeName;

    /** 书籍单价 */
    private BigDecimal price;

}
