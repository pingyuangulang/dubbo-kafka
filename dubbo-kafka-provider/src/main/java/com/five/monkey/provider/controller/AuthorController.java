package com.five.monkey.provider.controller;

import com.five.monkey.api.AuthorService;
import com.five.monkey.bo.AuthorBo;
import com.five.monkey.provider.kafka.provider.AuthorProvider;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 *
 * @author jim
 * @date 2020/5/7 15:44
 */
@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    @Qualifier("authorServiceImpl")
    private AuthorService authorService;

    @Autowired
    private AuthorProvider authorProvider;

    @GetMapping("/{id}/getInfo")
    public AuthorBo getInfo(@PathVariable("id") Long id) {
        return authorService.findById(id);
    }

    @PostMapping("/save/by/kafka")
    public Map<String, Boolean> saveByKafka(@RequestBody AuthorBo authorBo) {
        Map<String, Boolean> map = Maps.newHashMap();
        boolean flag = authorProvider.send(authorBo);
        map.put("status", flag);
        return map;
    }
}
