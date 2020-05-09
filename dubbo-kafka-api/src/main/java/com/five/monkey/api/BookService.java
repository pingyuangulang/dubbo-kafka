package com.five.monkey.api;

import com.five.monkey.bo.BookInfoBo;

/**
 *
 *
 * @author jim
 * @date 2020/4/29 17:34
 */
public interface BookService {

    /**
     * 根据书籍id查询书籍信息
     *
     * @param bookId
     * @return
     */
    BookInfoBo findById(Long bookId);
}
