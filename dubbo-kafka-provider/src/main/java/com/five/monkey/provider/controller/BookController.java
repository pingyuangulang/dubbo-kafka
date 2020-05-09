package com.five.monkey.provider.controller;

import com.five.monkey.api.BookService;
import com.five.monkey.bo.BookInfoBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author jim
 * @date 2020/5/8 15:10
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @GetMapping("/{id}/getInfo")
    public BookInfoBo getInfo(@PathVariable("id") Long id) {
        return bookService.findById(id);
    }
}
