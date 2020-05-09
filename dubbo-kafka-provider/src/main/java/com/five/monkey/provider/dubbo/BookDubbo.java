package com.five.monkey.provider.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.five.monkey.api.BookService;
import com.five.monkey.bo.BookInfoBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 *
 * @author jim
 * @date 2020/4/29 18:28
 */
@Service(interfaceClass = BookService.class, timeout = 3000)
public class BookDubbo implements BookService {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    /**
     * 根据书籍id查询书籍信息
     *
     * @param bookId
     * @return
     */
    @Override
    public BookInfoBo findById(Long bookId) {
        return bookService.findById(bookId);
    }
}
