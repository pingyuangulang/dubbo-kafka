package com.five.monkey.consumer.controller;

import com.five.monkey.bo.AuthorBo;
import com.five.monkey.consumer.dubbo.ConsumeAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author jim
 * @date 2020/5/8 15:32
 */
@RestController
@RequestMapping("/consume/author")
public class AuthorController {

    @Autowired
    private ConsumeAuthorService authorService;

    @GetMapping("/{id}/getInfo")
    public AuthorBo getInfo(@PathVariable("id") Long id) {
        return authorService.findById(id);
    }
}
