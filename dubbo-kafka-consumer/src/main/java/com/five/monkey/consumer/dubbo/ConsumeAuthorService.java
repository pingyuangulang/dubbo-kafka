package com.five.monkey.consumer.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.five.monkey.api.AuthorService;
import com.five.monkey.bo.AuthorBo;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author jim
 * @date 2020/5/8 15:36
 */
@Component
public class ConsumeAuthorService {

    @Reference(interfaceClass = AuthorService.class)
    private AuthorService authorService;

    public AuthorBo findById(Long id) {
        return authorService.findById(id);
    }
}
