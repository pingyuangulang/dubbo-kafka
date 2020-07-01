package com.five.monkey.provider.service;

import com.five.monkey.api.AuthorService;
import com.five.monkey.api.BookService;
import com.five.monkey.bo.AuthorBo;
import com.five.monkey.bo.BookInfoBo;
import com.five.monkey.mapper.extend.BookExtendMapper;
import com.five.monkey.model.Book;
import com.five.monkey.provider.annotation.RedisCache;
import com.five.monkey.provider.contains.KeyContains;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author jim
 * @date 2020/4/29 18:26
 */
@Service("bookServiceImpl")
@Slf4j
public class BookServiceImpl implements BookService {

    @Autowired
    private BookExtendMapper bookExtendMapper;

    @Autowired
    @Qualifier("authorServiceImpl")
    private AuthorService authorService;

    /**
     * 根据书籍id查询书籍信息
     *
     * @param bookId
     * @return
     */
    @Override
    @RedisCache(key = KeyContains.Book.BOOK_INFO, expire = 1L, timeUnit = TimeUnit.DAYS)
    public BookInfoBo findById(Long bookId) {
        BookInfoBo bookInfoBo = null;
        Book book = bookExtendMapper.selectByPrimaryKey(bookId);
        if (Objects.nonNull(book)) {
            bookInfoBo = new BookInfoBo();
            bookInfoBo.setBookId(bookId);
            bookInfoBo.setBookName(book.getName());
            bookInfoBo.setPrice(book.getPrice());
            AuthorBo authorBo = authorService.findById(book.getAuthorId());
            if (Objects.nonNull(authorBo)) {
                bookInfoBo.setAuthorId(authorBo.getId());
                bookInfoBo.setAuthorName(authorBo.getName());
                bookInfoBo.setWriteName(authorBo.getWriteName());
            }
        }
        return bookInfoBo;
    }
}
